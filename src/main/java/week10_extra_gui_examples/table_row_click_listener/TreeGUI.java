package week10_extra_gui_examples.table_row_click_listener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Created by clara on 4/30/18.
 */
public class TreeGUI extends JFrame {
    
    private JPanel mainPanel;
    private JTable treeTable;
    
    private String[] treeNames = { "Giant Sequoia", "Oak", "Giant Redwood" };
    private Integer[] treeHeights = { 250, 100, 380 };
    private String[] treeDescriptions = new String[]{
            "On average, the world's largest tree by mass. Native to California's Sierra Mountains.",
            "Common hardwood tree with many sub-species. The seeds of this tree are known as acorns.",
            "The world's tallest tree, native to California's northern coast."
    };
    
    
    TreeGUI(){
        
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        configureTable();
        
        setVisible(true);
        
    }
    
    
    private void configureTable() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name", treeNames);
        model.addColumn("Height (feet)", treeHeights);
        model.addColumn("Description", treeDescriptions);
        
        treeTable.setModel(model);
        
        addClickMessageDialogs();
 
    }
    
    
    
    private void addClickMessageDialogs() {
        
        treeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ListSelectionModel listSelectionModel = treeTable.getSelectionModel();

        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
    
                int row = e.getFirstIndex();
                if (row != -1) {
                    String treeDescription = (String) treeTable.getValueAt(row, 2);
                    JOptionPane.showMessageDialog(TreeGUI.this, treeDescription);
                }
            }
        });
    }
    
    
}
