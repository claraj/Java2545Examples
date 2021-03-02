package week12_database_and_gui_jtable.bird_default_table.ide_jtable.ide_jtable_abstract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by clara on 4/18/18.
 */
public class IdeTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable ideTable;
    private JTextField newIde;
    private JTextField newLanguage;
    private JButton addButton;
    
    IdeTableGUI(HashMap languages) {
        setContentPane(containsTable);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        String[] columnNames = {"Language", "IDE"};
        
        HashMapTableModel tableModel = new HashMapTableModel(languages, columnNames);
        
        ideTable.setModel(tableModel);
    
        pack();
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = newLanguage.getText();
                String ide = newIde.getText();
                
                languages.put(language, ide);
                tableModel.fireTableDataChanged();    // Updates the GUI
            }
        });
        
    }
}


