package week11_database_and_gui.pizza_stats;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;


public class BirdGUI extends JFrame {
    
    private JTable birdDataTable;
    private JPanel rootPanel;
    
    private BirdDatabase db;
    
    private DefaultTableModel tableModel;
    private Vector columnNames;
    
    BirdGUI(BirdDatabase db) {
    
        this.db = db;
    
        setContentPane(rootPanel);
        pack();
        setTitle("Bird Database Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        configureTable();
    
        setVisible(true);
        
    }
    
    
    private void configureTable() {
    
        //Set up JTable
        birdDataTable.setGridColor(Color.BLACK);
    
        columnNames = db.getColumnNames();
        Vector data = db.getAllBirds();
    
        // Custom methods for DefaultTableModel
        // Want to customize which cells are editable - the isCellEditable method
        // And, what happens when an editable cell is edited - the setValueAt method
        tableModel = new DefaultTableModel(data, columnNames);
    
        birdDataTable.setModel(tableModel);
    
    }
    
    
    
    
}