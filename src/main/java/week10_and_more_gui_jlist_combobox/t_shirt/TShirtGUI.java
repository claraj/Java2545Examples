package week10_and_more_gui_jlist_combobox.t_shirt;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by clara on 10/16/19.
 */
public class TShirtGUI extends JFrame {
    private JPanel mainPanel;
    private JComboBox sizeComboBox;
    private JLabel selectedSizeLabel;
    private JComboBox<String> colorComboBox;
    private JLabel selectedColorLabel;
    
    TShirtGUI() {

        setTitle("T-Shirt Order Form");

        sizeComboBox.addItem("Small");
        sizeComboBox.addItem("Medium");
        sizeComboBox.addItem("Large");

        String[] colors = {"Red", "Purple", "Green"};  // Or any colors of your choice

        DefaultComboBoxModel<String> colorModel = new DefaultComboBoxModel<>(colors);
        colorComboBox.setModel(colorModel);
        
        // Example ways of adding and removing data from the DefaultComboBoxModel
        
        colorModel.addElement("Pink");   // Adds to the end
        
        List<String> moreColors = List.of("Gray", "Blue", "Orange");
        colorModel.addAll(moreColors);    // Adds a list to the end
        
        colorModel.insertElementAt("Magenta", 2);  // Add at a particular position
        
        colorModel.removeElementAt(4);    // Remove by position
        colorModel.removeElement("Gray");  // Remove by value
        
        int numberOfColors = colorModel.getSize();
        String color3 = colorModel.getElementAt(3);   // Get element by position
        int magentaIndex = colorModel.getIndexOf("Magenta");
        int violetIndex = colorModel.getIndexOf("Violet");   // Not in the model, returns -1

        System.out.println("There are " + numberOfColors + " colors. " +
                "Element 2 is " + color3 + ". Magenta is at position " + magentaIndex +
                " and Violet is at position " + violetIndex);

        setContentPane(mainPanel);
        setPreferredSize(new Dimension(300, 150));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sizeComboBox.setSelectedIndex(-1);  // Unselect
        colorComboBox.setSelectedIndex(-1);

        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSizeLabel.setText("You selected " + sizeComboBox.getSelectedItem());
            }
        });

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColorLabel.setText("You selected " + colorComboBox.getSelectedItem());
            }
        });
    }
}



