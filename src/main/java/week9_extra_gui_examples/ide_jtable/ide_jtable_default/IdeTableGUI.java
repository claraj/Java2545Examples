package week9_extra_gui_examples.ide_jtable.ide_jtable_default;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
    
    IdeTableGUI(HashMap<String, String> languages) {
        setContentPane(containsTable);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Language");
        tableModel.addColumn("IDE");
        
        // add the initial data to the JTable DefaultTableModel
        for (String language: languages.keySet()) {
            tableModel.addRow(new String[]{language, languages.get(language)});
        }
        
        ideTable.setModel(tableModel);
        
        ideTable.setAutoCreateRowSorter(true);
    
        pack();
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = newLanguage.getText();
                String ide = newIde.getText();
                tableModel.addRow(new String[]{language, ide});
            }
        });
        
        reportButton.addActionListener(new ActionListener(){
    
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Object row : tableModel.getDataVector()){
                    Vector rowVector = (Vector) row;
                    String language = (String) rowVector.get(0);
                    String ide = (String) rowVector.get(1);
                    System.out.println("An IDE for " + language + " is " + ide);
                }
            }
        });
    }
}


