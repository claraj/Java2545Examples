package week12_database_and_gui_jtable.bird_default_table.ide_jtable.ide_jtable_abstract;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;

public class HashMapTableModel extends AbstractTableModel{
    
    private HashMap data;
    private String[] columnNames;
    
    HashMapTableModel(HashMap map, String[] columnNames) {
        this.data = map;
        this.columnNames = columnNames;
        
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Object key = data.keySet().toArray()[rowIndex];
        
        if (columnIndex == 0) {
            return key;
        } else {
            return data.get(key);
        }
        
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
}


