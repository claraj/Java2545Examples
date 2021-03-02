package week12_database_and_gui_jtable.bird_default_table.hello_jtable.hello_jtable_abstract;

import javax.swing.*;

/**
 * Created by clara on 4/18/18.
 */
public class HelloTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable helloTable;
    private JSlider rows;
    private JSlider columns;
    private JScrollPane table;
    
    HelloTableGUI() {
        setContentPane(containsTable);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        helloTable.setModel(new HelloTableModel());
        pack();
    
    }
}


