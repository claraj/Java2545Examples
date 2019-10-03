package week10_extra_gui_examples.file_chooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by clara on 12/6/17.
 */
public class SelectAFileGUI extends JFrame{
    private JPanel panel1;
    private JButton selectAFileButton;
    private JLabel fileNameLabel;
    
    public SelectAFileGUI() {
        
        setContentPane(panel1);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        selectAFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                // Create and show a file chooser dialog
                
                JFileChooser fileChooser = new JFileChooser();
                
                // Optional - set options, filter to only allow certain types of filename
                // see documentation  https://docs.oracle.com/javase/8/docs/api/javax/swing/JFileChooser.html

                // Default is single file selection. See docs for multi-selection
                
                int returnVal = fileChooser.showOpenDialog(SelectAFileGUI.this);
                
                // Did user choose a file by clicking 'Open' (or Select or whatever the OS displayed)
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    
                    // Get a File object representing the selected file
                    
                    File fileSelected = fileChooser.getSelectedFile();
                    
                    // Then can use this in your program, for example;
                    fileNameLabel.setText(fileSelected.toString());
                    
                    // If you had used multi-selection, you can call getSelectedFiles to get an array of Files.
                }
                
            }
        });
    }
}
