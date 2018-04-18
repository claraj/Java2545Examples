package week9_extra_gui_examples.ide_jtable.hello_jtable;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;

public class HashMapTableModel extends AbstractTableModel{
    
    private HashMap data;
    
    HashMapTableModel(HashMap map) {
        this.data = map;
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
}


