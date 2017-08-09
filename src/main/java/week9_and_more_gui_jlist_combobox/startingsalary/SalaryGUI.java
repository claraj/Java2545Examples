package week9_and_more_gui_jlist_combobox.startingsalary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class SalaryGUI extends JFrame {
    private JComboBox<String> subCategoryComboBox;
    private JComboBox<String> categoryComboBox;
    private JLabel resultLabel;
    private JPanel rootPane;


    //These hashmaps will hold data displayed by the JComboBoxes, and the resultLabel
    private HashMap<String, String[]> categories = new HashMap<String, String[]>();
    private HashMap<String, Integer> salaries = new HashMap<String, Integer>();

    protected SalaryGUI() {

        setContentPane(rootPane);

        //Set size of window, to make sure all components will fit
        setPreferredSize(new Dimension(500, 150));

        //Custom setup for our application
        addSalaryData();
        configureComboBoxes();
        addEventListeners();

        pack();
        setVisible(true);

    }


    private void configureComboBoxes() {

        //Add the keys in the categories HashMap to the first JComboBox, categoryComboBox.

        for (String cat : categories.keySet()) {
            categoryComboBox.addItem(cat);
        }

        //For the currently selected category, add its sub categories to the subCategoryComboBox

        // What is currently selected?
        String selectedCategory = categoryComboBox.getSelectedItem().toString();

        // Get the subcategories for this selection
        String[] subCategories = categories.get(selectedCategory);

        for (String subCat : subCategories) {
            subCategoryComboBox.addItem(subCat);
        }

    }


    private void addEventListeners() {

        // Selection made from first JComboBox for job category
        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Clear the subCategoryCombobox
                // Update with new subcategories, based on the selected category

                subCategoryComboBox.removeAllItems();

                String selectedCategory = categoryComboBox.getSelectedItem().toString();

                String[] subCategories = categories.get(selectedCategory);

                for (String subCat : subCategories) {
                    subCategoryComboBox.addItem(subCat);
                }

            }
        });



        subCategoryComboBox.addActionListener(new ActionListener() {

            //Selection made from the second JComboBox, for the subcategory
            @Override
            public void actionPerformed(ActionEvent e) {
                //Retrieve and display salary data for this subcategory. If nothing is selected, this returns null
                String subCat = (String)subCategoryComboBox.getSelectedItem();

                //Must check to see if something was selected, or get NullPointerException.
                if (subCat != null) {
                    int salary = salaries.get(subCat);
                    String result = "A typical starting salary for a " + subCat + " is about $" + salary;
                    resultLabel.setText(result);
                }

                //Another way to check is to use the getSelectedIndex() method. This returns -1 if nothing is selected
                //This is perhaps less useful here because we need to know what was selected, not where it is in the list.
                //Example code...
                /*
                if (subCategoryComboBox.getSelectedIndex() != -1) {
                    String subCat = subCategoryComboBox.getSelectedItem().toString();
                    int salary = salaries.get(subCat);
                    String result = "A typical starting salary for a " + subCat + " is about $" + salary;
                    resultLabel.setText(result);
                }
                */

            }
        });
    }


    private void addSalaryData() {

        categories.put("Software Developer", new String[] { "C# Developer", "Java Developer", "Python Developer" } );
        categories.put("Network Administrator", new String[] { "Linux Admin", "Windows Admin" } );

        salaries.put("C# Developer", 50000);
        salaries.put("Java Developer", 50000);
        salaries.put("Python Developer", 47000);
        salaries.put("Linux Admin", 45000);
        salaries.put("Windows Admin", 45000);



    }
}
