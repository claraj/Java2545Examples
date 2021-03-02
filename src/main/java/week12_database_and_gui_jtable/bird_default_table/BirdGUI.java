package week12_database_and_gui_jtable.bird_default_table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class BirdGUI extends JFrame {
    
    private JTable birdDataTable;
    private JPanel mainPanel;
    
    private BirdDatabase db;
    
    BirdGUI(BirdDatabase db) {
    
        this.db = db;
    
        setContentPane(mainPanel);
        pack();
        setTitle("Bird Database Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configureTable();
        setVisible(true);
    }
    
    
    private void configureTable() {

        Vector<String> columnNames = db.getColumnNames();
        Vector<Vector> data = db.getAllBirds();

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        birdDataTable.setModel(tableModel);

    }
}


