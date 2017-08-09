package week9_extra_gui_examples.tabbed_j_frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 5/6/15.
 */
public class Tab2 {
    private JTextArea textArea1;
    private JButton button1;
    private JPanel tabTwoJPanel;

    public Tab2() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button1,  "The text in the text box is " + textArea1.getText());
            }
        });
    }

    public  JPanel getPanel(){
        return tabTwoJPanel;
    }

}
