package week10_extra_gui_examples.image_in_jtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.Vector;

/**
 * Created by clara on 6/5/19.
 */
public class AnimalTableGUI extends JFrame {
    
    private JPanel mainPanel;
    private JTable animalTable;
    
    Vector<Animal> animals;
    
    
    AnimalTableGUI() {
        
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        animals = AnimalImageDB.fetchAll();
        animalTable.setRowHeight(150);
        
        this.setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
    
    
        animalTable.setModel(new DefaultTableModel() {
            
            @Override
            public int getColumnCount() {
                return 2;
            }
    
            @Override
            public int getRowCount() {
                return animals.size();
            }
            
            
            /*
            * First part of displaying images - override the getColumnClass method for the table model.
            * JTable already knows how to display images, if the object in a table cell is an ImageIcon object
            * But you need to tell the JTable that a cell does contain an ImageIcon.
            * https://stackoverflow.com/questions/4941372/how-to-insert-image-into-jtable-cell
            * */
            @Override
            public Class getColumnClass(int col) {
                if (col == 0) return String.class;
                if (col == 1) return ImageIcon.class;
                return null;
            }
            
            @Override
            public Object getValueAt(int row, int col) {
                
                if (col == 0) {
                    return animals.get(row).getName();
                }
                
                /* Second part of displaying images - create an ImageIcon for the cell, and return that.
                 * The database contains an entry like "bird.jpeg" or "zebra.jpeg" for each animal and the image files are in the /images/ folder
                 * so create a string with the correct path to that image file. Create an ImageIcon for that file, and return. Since the
                 * getColumnClass method will return ImageIcon.class for the second column, the images are displayed automatically. */
                
                if (col == 1) {
                    String filename = animals.get(row).getImageFile();
                    File imageFile = new File("images", filename);
                    ImageIcon icon = new ImageIcon(imageFile.getPath());
                    return icon;
                }
                
                return null;
                
            }
            
        });
        
    }
    
}
