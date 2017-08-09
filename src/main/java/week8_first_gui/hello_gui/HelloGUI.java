package week8_first_gui.hello_gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by we4954cp on 8/25/2016.
 */
public class HelloGUI extends JFrame{
    private JPanel mainPanel;
    private JButton clickMeButton;
    private JLabel myFirstLabel;

    protected HelloGUI() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFirstLabel.setText("Hello, GUI!");
            }
        });
    }
}
