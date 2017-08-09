package week9_extra_gui_examples.two_windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindowGUI extends JFrame{
    private JButton openWindowForUserInputButton;
    private JPanel rootPanel;
    private JLabel userInputLabel;


    MainWindowGUI() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        openWindowForUserInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Open another window.
                AskUserForInputGUI getUserInput = new AskUserForInputGUI(MainWindowGUI.this);
            }
        });

    }

    //This is called from the other window to send data back here
    public void sendData(String name, String favoriteColor) {
        userInputLabel.setText("Your name is " + name + " and your favorite color is " + favoriteColor);
    }
}
