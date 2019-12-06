package week10_extra_gui_examples.editable_resizable_jtable;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * Created by clara on 12/6/19.
 */
public class ResizableTableModel extends AbstractTableModel {
    
    private Vector<Vector<String>> data;
    
    ResizableTableModel(Vector<Vector<String>> data) {
        this.data = data;
    }
    
    public void setData(Vector<Vector<String>> data) {
        this.data = data;
    }
    
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return data.get(0).size();
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
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        
        String newValue = (String) value;
        data.get(rowIndex).set(columnIndex, newValue);
        
        // Can validate and reset to previous value if not acceptable
        // This is where you have the opportunity to write to database
        
    }
}
