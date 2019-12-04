package week10_extra_gui_examples.hello_resizable_jtable.hello_jtable_resizable_abstract;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * Created by clara on 4/18/18.
 */
public class HelloTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable table;
    private JSlider rows;
    private JSlider columns;
    
    HelloTableGUI() {
        setContentPane(containsTable);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // create vector of vectors with initial data
        rows.setValue(2);
        columns.setValue(2);
        
        Vector<String> row1 = new Vector<>();
        row1.add("?");
        row1.add("?");
    
        Vector<String> row2 = new Vector<>();
        row2.add("?");
        row2.add("?");
    
        Vector<Vector<String>> data  = new Vector<>();
        data.add(row1);
        data.add(row2);
    
        table.setModel(new ResizableTableModel(this, data));
        pack();
        
        rows.addChangeListener(l -> updateTable());
        columns.addChangeListener(l -> updateTable());
    
    }
    
    public void updateTable() {
        // recreate data Vector otherwise error
        AbstractTableModel model = (AbstractTableModel) table.getModel();
        model.fireTableDataChanged();
        
    }
    
    public class ResizableTableModel extends AbstractTableModel {
        
        Vector<Vector<String>> data;
        
        HelloTableGUI gui;
        ResizableTableModel(HelloTableGUI gui, Vector<Vector<String>> data) {
            this.gui = gui;
            this.data = data;
        }
        
        @Override
        public int getRowCount() {
            return gui.rows.getValue();
        }
        
        @Override
        public int getColumnCount() {
            return gui.columns.getValue();
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data.get(rowIndex).get(columnIndex);
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }
        
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            System.out.println(aValue);
            data.get(rowIndex).set(columnIndex, aValue.toString());
            // where you have the opportunity to write to database
        }
    }
}






