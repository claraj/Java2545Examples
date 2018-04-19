package week9_extra_gui_examples.hello_jtable.hello_jtable_default;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class HelloTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable helloTable;
    
    HelloTableGUI() {
        setContentPane(containsTable);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Hello!");
        tableModel.addColumn("Greetings!");

        tableModel.addRow(new String[]{"hello", "hola"});
        tableModel.addRow(new String[]{"bonjour", "ni hao"});
        
        helloTable.setModel(tableModel);
        
        pack();
    }
}


