package week8_first_gui.currency_converter_dropdown_box;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


/* Currency converter with a drop-down box to select the currency from */

public class CurrencyConverter extends JFrame{
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JPanel rootPanel;
    private JLabel conversionResultLabel;
    //JComboBoxes can also use generics to only display one type of object
    private JComboBox<String> currencyComboBox;
    
    private double dollarsToEurosExchangeRate = 0.84;  //1 Dollar is equivalent to 0.84 Euros; as of 16 Sep 2017.
    private double dollarsToPoundsExchangeRate = 0.74;  //1 Dollar is equivalent to 0.74 UK Pounds
    //TODO how could you keep this program up to date with the latest exchange rates?
    
    //Constants to display in the JComboBox; and keys in the exchangeRates HashMap
    private final String EUROS = "Euros";
    private final String POUNDS = "Pounds";
    
    //Map of names of currencies and their exchange rates with dollars
    private HashMap<String, Double> exchangeRates = new HashMap<>();
    

    protected CurrencyConverter(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set up exchange rates HashMap. Will refer to this when the conversion is performed.
        exchangeRates.put(EUROS, dollarsToEurosExchangeRate);
        exchangeRates.put(POUNDS, dollarsToPoundsExchangeRate);

        //Set up JComboBox - add the currencies we can convert to
        currencyComboBox.addItem(EUROS);
        currencyComboBox.addItem(POUNDS);
    
        getRootPane().setDefaultButton(convertButton);
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Read input from JTextField and convert to a double. Must handle exceptions! And then perform conversion.
                String dollarString = dollarsTextField.getText();

                try {
                    double dollars = Double.parseDouble(dollarString);
                    String toCurrency = (String) currencyComboBox.getSelectedItem();  // Convert selected item to expected type

                    //Get the exchange rate for this currency from the HashMap, using whatever was selected from the JComboBox as the key
                    double exchangeRate = exchangeRates.get(toCurrency);

                    //And the math
                    double converted = dollars * exchangeRate;

                    //Format String to display values with 2 decimal places
                    String resultString = String.format("%.2f dollars is equivalent to %.2f %s", dollars, converted, toCurrency);
                    conversionResultLabel.setText(resultString);

                } catch (NumberFormatException pe) {
                    //Pop up a dialog box with an error message.
                    JOptionPane.showMessageDialog(CurrencyConverter.this, "Please enter a number without $ symbols or other characters");

                    //In some circumstances, you may want to clear the JTextField of the invalid input like this,
                    //dollarsTextField.setText("");
                    //But here, you probably want to leave the invalid input so use can see what they typed, and correct it.
                }
            }
        });
    }
}
