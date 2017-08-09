package week9_and_more_gui_jlist_combobox.creditcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class CCValidator extends JFrame {
    private JPanel rootPanel;
    private JTextField creditCardNumbertextField;
    private JButton validateButton;
    private JButton quitButton;
    private JLabel validMessageLabel;
    private JComboBox ccTypeComboBox;

    private boolean resetMessageOnKeyPress = false;

    private final String VISA = "Visa";
    private final String MASTERCARD = "Mastercard";
    private final String AMEX = "American Express";

    protected CCValidator() {

        super("Credit Card Validator");
        setContentPane(rootPanel);

        setPreferredSize(new Dimension(500, 200));   //Set preferred size before call to pack()

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        ccTypeComboBox.addItem(VISA);
        ccTypeComboBox.addItem(MASTERCARD);
        ccTypeComboBox.addItem(AMEX);


        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ccNumber = creditCardNumbertextField.getText();

                String cardType = ccTypeComboBox.getSelectedItem().toString();

                boolean valid = false;

                if (cardType.equals(VISA)) {
                    valid = isVisaCreditCardNumberValid(ccNumber);
                }
                else if (cardType.equals(MASTERCARD)) {
                    //TODO Mastercard validation
                }
                else if (cardType.equals(AMEX)) {
                    //TODO American express card validation
                }

                if (valid) {
                    validMessageLabel.setText("Credit card number is valid");
                } else {
                    validMessageLabel.setText("Credit card number is invalid");
                }

                resetMessageOnKeyPress = true;
            }
        });



        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        // Listener for user making selections from JComboBox
        ccTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateButton.setText("Click to validate " + ccTypeComboBox.getSelectedItem());
            }
        });

        // Listener for user typing in JTextField.
        // Used to reset the valid or not valid message when user enters a new card.
        creditCardNumbertextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (resetMessageOnKeyPress) {
                    validMessageLabel.setText("~ Valid or not valid displayed here ~");
                    resetMessageOnKeyPress = false;
                }
            }
        });
    }


    private static boolean isVisaCreditCardNumberValid(String cc) {

        if (!cc.startsWith("4") || (cc.length() != 16)){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 16 ; i++ ) {
            int thisDigit = Integer.parseInt((cc.substring(i, i+1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9 ) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }
        if (sum % 10 == 0) {
            return true;
        }
        return false;
    }

}



