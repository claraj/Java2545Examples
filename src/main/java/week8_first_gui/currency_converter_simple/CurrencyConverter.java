package week8_first_gui.currency_converter_simple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JPanel mainPanel;
    private JLabel eurosResultLabel;
    
    private double dollarsToEurosExchangeRate = 0.84;
    //1 Dollar is equivalent to 0.84 Euros; as of Sept 16 2017.
    
    CurrencyConverter() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        getRootPane().setDefaultButton(convertButton);
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Read input from JTextField and convert to a double, and handle exceptions.
                String dollarString = dollarsTextField.getText();
                
                try {
                    double dollars = Double.parseDouble(dollarString);
                    double euros = dollars * dollarsToEurosExchangeRate;
                    //Use format String to show the values with 2 decimal places
                    String resultString = String.format("%.2f dollars is equivalent to %.2f Euros", dollars, euros);
                    eurosResultLabel.setText(resultString);
                    
                } catch (NumberFormatException nfe) {
                    //Pop up a dialog box with an error message.
                    JOptionPane.showMessageDialog(CurrencyConverter.this,
                            "Please enter a number without $ symbols or other characters");
                    
                    //In some circumstances, you may want to clear the JTextField of the invalid input like this,
                    //dollarsTextField.setText("");
                    //But here, you probably want to leave the invalid input so use can see what they typed, and correct it.
                }
            }
        });
    }
}


