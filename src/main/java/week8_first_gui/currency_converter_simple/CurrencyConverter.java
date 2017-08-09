package week8_first_gui.currency_converter_simple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 8/26/16.
 */
public class CurrencyConverter extends JFrame{
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JPanel rootPanel;
    private JLabel eurosResultLabel;
    private JComboBox currencComboBox;

    private double dollarsToEurosExchangeRate = 0.89;  //1 Dollar is equivalent to 0.89 Euros; as of 26 Aug 2016.
                                //TODO how could you keep this program up to date with the latest exchange rates?

    protected CurrencyConverter(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Read input from JTextField and convert to a double. Must handle exceptions!
                String dollarString = dollarsTextField.getText();

                try {
                    double dollars = Double.parseDouble(dollarString);
                    double euros = dollars * dollarsToEurosExchangeRate;
                    //Use format strings to round to 2 decimal places, and is neater than joining strings
                    String resultString = String.format("%.2f dollars is equivalent to %.2f Euros", dollars, euros);
                    eurosResultLabel.setText(resultString);

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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
