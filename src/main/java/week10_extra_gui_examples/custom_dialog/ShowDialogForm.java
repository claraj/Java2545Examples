package week10_extra_gui_examples.custom_dialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by admin on 12/11/16. Examples of JOptionPane - a dialog box.
 *
 * More in the Java tutorial and the JOptionPane documentation.
 *
 * http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 *
 */
public class ShowDialogForm extends JFrame {
    private JButton showMessageDialogButton;
    private JButton showOKCancelDialogButton;
    private JButton showCustomDialogButton;
    private JLabel okCancelResultLabel;
    private JPanel mainPanel;
    private JButton showAnotherCustomDialogButton;
    private JButton showInputDialogAskButton;
    private JLabel userInputLabel;
    
    ShowDialogForm() {
        
        // A basic message dialog with an Ok button.
        showMessageDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ShowDialogForm.this, "Here's a message. Please click ok.");
            }
        });
        
        //An OK-Cancel dialog.
        showOKCancelDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(ShowDialogForm.this, "Please click Ok or Cancel", "Input Requested", JOptionPane.OK_CANCEL_OPTION);
                
                if (choice == JOptionPane.OK_OPTION) {
                    okCancelResultLabel.setText("You clicked OK");
                }
                
                if (choice == JOptionPane.CANCEL_OPTION) {
                    okCancelResultLabel.setText("You clicked Cancel");
                }
            }
        });
        
        
        //A dialog to ask the user for input
        
        showInputDialogAskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(ShowDialogForm.this, "Please enter some text");
                userInputLabel.setText("You typed '" + input + "'");
            }
        });
        
        
        //A custom dialog. Anything more complex, or with more logic, or that needs to return data to the main program, should be implemented as a JDialog instead.
        
        showCustomDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JPanel panel = new JPanel(new BorderLayout());
                JSpinner spinner = new JSpinner(new SpinnerDateModel());
                JLabel label = new JLabel();
                panel.add(spinner, BorderLayout.NORTH);
                panel.add(label, BorderLayout.SOUTH);
                spinner.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        Date now = new Date();
                        if (now.after((Date)spinner.getModel().getValue())){
                            label.setText("The Past");
                        } else {
                            label.setText("The Future");
                        }
                    }
                });
                
                JOptionPane.showMessageDialog(ShowDialogForm.this, panel, "Please select a date", JOptionPane.QUESTION_MESSAGE);
        
            }
        });
        
        //And another dialog - this one shows an image from a file
        showAnotherCustomDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                JPanel panel = getImagePanel();
                JOptionPane.showMessageDialog(ShowDialogForm.this, panel, "Image", JOptionPane.PLAIN_MESSAGE);
                
            }
        });
        
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
    }
    
    private JPanel getImagePanel() {
        
        //Read image from file. Display
        JPanel panel = new JPanel();
        try {
            BufferedImage image = ImageIO.read(new File("rocket.jpg"));
            ImageIcon icon = new ImageIcon(image);
            JLabel iconLabel = new JLabel(icon);
            panel.add(iconLabel);
        } catch (IOException ioe) {
            JLabel errorLabel = new JLabel("Error, could not read image file");
            panel.add(errorLabel);
        }
        return panel;
        
    }
}
