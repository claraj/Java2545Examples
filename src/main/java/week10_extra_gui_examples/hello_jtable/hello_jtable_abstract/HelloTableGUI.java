package week10_extra_gui_examples.hello_jtable.hello_jtable_abstract;

import javax.swing.*;

/**
 * Created by clara on 4/18/18.
 */
public class HelloTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable helloTable;
    
    HelloTableGUI() {
        setContentPane(containsTable);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        helloTable.setModel(new HelloTableModel());
        pack();
    
    }
}


