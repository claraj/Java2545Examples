package week12_database_and_gui_jtable.bird_default_table.ide_jtable.ide_jtable_default;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

/**
 * Created by clara on 4/18/18.
 */
public class IdeTableGUI extends JFrame {
    private JPanel containsTable;
    private JTable ideTable;
    
    private JTextField newIde;
    private JTextField newLanguage;
    private JButton addButton;
    private JButton reportButton;
    
    IdeTableGUI(Map<String, String> languages) {
    
        DefaultTableModel tableModel = new DefaultTableModel();
     
        tableModel.addColumn("Language");
        tableModel.addColumn("IDE");
    
        // add the initial data to the JTable DefaultTableModel
        for (String language : languages.keySet()) {
            tableModel.addRow(new String[]{language, languages.get(language)});
        }
        
        ideTable.setModel(tableModel);
        ideTable.setAutoCreateRowSorter(true);
        
        setContentPane(containsTable);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = newLanguage.getText();
                String ide = newIde.getText();
                String[] newIdeRow = { language, ide };
                tableModel.addRow(newIdeRow);
            }
        });
    
        reportButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vector row: tableModel.getDataVector()){
                    String language = (String) row.get(0);
                    String ide = (String) row.get(1);
                    System.out.println("An IDE for " + language + " is " + ide);
                }
            }
        });
    }
}
