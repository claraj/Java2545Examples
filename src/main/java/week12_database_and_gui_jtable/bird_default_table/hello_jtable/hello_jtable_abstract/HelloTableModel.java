package week12_database_and_gui_jtable.bird_default_table.hello_jtable.hello_jtable_abstract;

import javax.swing.table.AbstractTableModel;

public class HelloTableModel extends AbstractTableModel{
    @Override
    public int getRowCount() {
        return 4;
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "Hello!";
    }
}


