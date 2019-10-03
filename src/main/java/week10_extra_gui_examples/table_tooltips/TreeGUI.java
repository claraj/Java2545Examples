package week10_extra_gui_examples.table_tooltips;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;


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
        
    }
    
    
    private void createUIComponents() {
        // Note that the JTable's Custom Create checkbox in the GUI designer properties is checked,
        // to intercept the call to create the JTable, so we can create our own JTable with
        // the getToolTipText method overridden.
        
        treeTable = new JTable() {
            public String getToolTipText(MouseEvent e) {

                String toolTip = null;

                Point p = e.getPoint();
                int row = rowAtPoint(p);
                int col = columnAtPoint(p);

                if (row >= 0) {
                    toolTip = getValueAt(row, col).toString();
                }

                return toolTip;
            }
        };
    
    }
}
