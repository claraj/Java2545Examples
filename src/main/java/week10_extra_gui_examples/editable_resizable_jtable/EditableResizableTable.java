package week10_extra_gui_examples.editable_resizable_jtable;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by clara on 12/5/19.
 */

public class EditableResizableTable extends JFrame {
    private JPanel containsTable;
    private JTable table;
    private JSlider rows;
    private JSlider columns;
    private JButton createTableButton;
    private JLabel rowLabel;
    private JLabel columnLabel;
    
    
    EditableResizableTable() {
        setContentPane(containsTable);
        
        rows.setMinimum(1);
        rows.setMaximum(20);
        
        columns.setMinimum(1);
        columns.setMaximum(20);
        
        rows.addChangeListener(l -> updateLabel(rows, rowLabel, "Row(s)") );
        columns.addChangeListener(l -> updateLabel(columns, columnLabel, "Column(s)") );
        
        rows.setValue(10);
        columns.setValue(10);
        
        createTableButton.addActionListener(l -> createTable() );
    
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    }
    
    public void updateLabel(JSlider slider, JLabel label, String suffix) {
        label.setText(slider.getValue() + " " + suffix);
    }
    
    
    public void createTable() {
        // create vector of vectors with initial data
        Vector<Vector<String>> data = createVectors(rows.getValue(), columns.getValue());
        table.setModel(new ResizableTableModel(data));
        pack();
    }
    
    
    public Vector<Vector<String>> createVectors(int rows, int col) {
        Vector<Vector<String>> vector = new Vector<>();
        
        for (int r = 0 ; r < rows ; r++) {
            // Create row vector
            Vector<String> oneRow = new Vector<>();
            for (int c = 0 ; c < col ; c++) {
                oneRow.add("?");
            }
            vector.add(oneRow);
        }
        return vector;
    }
    
}






