package week8_first_gui.shout_text_views_labels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 8/26/16.
 */
public class LabelsTextViews extends JFrame{
    private JTextField wordTextField;
    private JButton submitWordButton;
    private JPanel rootPanel;
    private JLabel shoutLabel;

    protected LabelsTextViews() {
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        submitWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Read the word the user typed into the wordTextField JTextField
                //Convert it to uppercase, and set the tex of the shoutLabel JLabel to "shout" the word back to the user
                String word = wordTextField.getText();
                String shout = word.toUpperCase() + "!!!!";   //And add some exclamation points...
                shoutLabel.setText(shout);

                //Bonus - let's make the text large too
                Font largerFont = new Font(Font.MONOSPACED, Font.BOLD, 40);
                shoutLabel.setFont(largerFont);
                pack();    //This re-sizes the window to fit all of the UI components, including the larger text

            }
        });

    }
}
