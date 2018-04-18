package week9_extra_gui_examples.hello_jtable.hello_jtable;

import javax.swing.*;

/**
 * Created by clara on 4/18/18.
 */
public class HelloTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable ideTable;
    
    HelloTableGUI() {
        setContentPane(containsTable);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ideTable.setModel(new HelloTableModel());
        
    }
}


