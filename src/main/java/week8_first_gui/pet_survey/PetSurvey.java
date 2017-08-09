package week8_first_gui.pet_survey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class PetSurvey extends JFrame {
    private JPanel rootPane;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JCheckBox dogCheckBox;
    private JLabel resultsLabel;
    private JButton quitButton;

    private boolean dog;
    private boolean cat;
    private boolean fish;


    protected PetSurvey() {

        setContentPane(rootPane);      //Set the contents of the Window to be the rootPane JPanel
        pack();                         // Add the components to the window
        setSize(new Dimension(350, 200));    //Set size - user will be able to resize
        setTitle("Pet Survey");               // Set the text in the title bar
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Close the program when you close this window.
        setVisible(true);              // What it sounds like


        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });


        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });

        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?",
                        "Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults(){
        String hasDog = dog ? "one dog" : "no dogs";
        String hasCat = cat ? "one cat" : "no cats";
        String hasFish = fish ? "one fish" : "no fish";

        String results = "you have " + hasDog + " and " + hasCat + " and " + hasFish ;
        resultsLabel.setText(results);
    }
}
