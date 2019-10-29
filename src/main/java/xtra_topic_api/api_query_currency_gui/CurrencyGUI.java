package xtra_topic_api.api_query_currency_gui;

import kong.unirest.Unirest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by clara on 10/29/19.
 */
public class CurrencyGUI extends JFrame {
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JPanel mainPanel;
    private JLabel conversionResult;
    
    CurrencyGUI() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String dollarsString = dollarsTextField.getText();
                try {
                    double dollars = Double.parseDouble(dollarsString);
                    dollarsTextField.setEnabled(false);
                    convertButton.setEnabled(false);
                    CurrencyWorker worker = new CurrencyWorker();
                    worker.execute();
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CurrencyGUI.this, "Enter a number.");
                }
                
            }
        });
    }
    
    
    private void calcAndDisplayResults(String exchangeRate) {
        String dollarsString = dollarsTextField.getText();
        double dollars = Double.parseDouble(dollarsString);
        double exchange = Double.parseDouble(exchangeRate);
        double euro = dollars * exchange;
        conversionResult.setText(String.format("%.2f dollars is %.2f euros.", dollars, euro));
        dollarsTextField.setEnabled(true);
        convertButton.setEnabled(true);
        
    }
    
    
    private class CurrencyWorker extends SwingWorker<String, Void> {
        
        @Override
        protected String doInBackground() throws Exception {
            
            // "https://api.exchangeratesapi.io/latest?base=USD&symbols=EUR"
            String exchangeRateURL = "https://api.exchangeratesapi.io/latest";
            
            // Create a map of query parameter names and value
            Map<String, Object> params = Map.of("base", "USD", "symbols", "EUR");
            
            RateData response = Unirest.get(exchangeRateURL)
                    .queryString(params)
                    .asObject(RateData.class)    // Turn the response into a RateData object
                    .getBody();
            
            System.out.println(response);
            
            return response.getRates().getEUR();
        }
        
        @Override
        protected void done() {
            try {
                calcAndDisplayResults(get());
            } catch (Exception e) {
                System.err.println("Error getting exchange rate because " + e);
            }
        }
    }
    
    
}
