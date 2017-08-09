package week9_extra_gui_examples.two_windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AskUserForInputGUI extends JFrame{
    private JTextField nameTextField;
    private JTextField colorTextField;
    private JButton saveAndReturnToMainButton;
    private JPanel userInputRootPanel;

    AskUserForInputGUI(final MainWindowGUI parentComponent) {

        setContentPane(userInputRootPanel);
        pack();
        setVisible(true);
        parentComponent.setEnabled(false);  //Prevent any actions in the parent component

        saveAndReturnToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String favoriteColor = colorTextField.getText();
                parentComponent.sendData(name, favoriteColor);   // Send data back to parent window
                parentComponent.setEnabled(true);                // enable parent component
                AskUserForInputGUI.this.dispose();               // Close this window
            }
        });
    }
}
