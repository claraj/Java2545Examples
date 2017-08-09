package week9_and_more_gui_jlist_combobox.race;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by clara on 11/1/2016.
 *
 * GUI version of the Week 3 program - calculate a training schedule for a
 * runner who wants to increase the distance they can run over a period of weeks.
 */


public class RaceGUI extends JFrame {
    private JPanel root;
    private JButton calculateButton;
    private JList<String> distanceList;
    private JTextField percentIncreaseTextField;
    private JTextField targetDistanceTextField;
    private JTextField startDistanceTextField;
    private DefaultListModel<String> distanceListModel;

    RaceGUI () {

        setContentPane(root);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        distanceListModel = new DefaultListModel<>();
        distanceList.setModel(distanceListModel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Fetch data from 3 JTextFields, and validate
                String errorMessage = null;
                double startDistance = 0 , targetDistance = 0 , percentIncrease = 0;
                try {
                    startDistance = Double.parseDouble(startDistanceTextField.getText());
                    targetDistance = Double.parseDouble(targetDistanceTextField.getText());
                    percentIncrease = Double.parseDouble(percentIncreaseTextField.getText());

                    if (startDistance < 0) {
                        errorMessage = "Please enter a positive start distance";
                    }

                    else if (targetDistance < 0 || targetDistance <= startDistance) {
                        errorMessage = "Target distance must be greater than start distance";
                    }

                    else if (percentIncrease < 0 || percentIncrease > 100) {
                        errorMessage = "Please enter a positive percent value, between 0 and 100";
                    }



                } catch (NumberFormatException nfe) {
                    errorMessage = "Please enter numerical values for all three inputs";
                }

                //Show error dialog if errorMessage has been set
                if (errorMessage != null) {
                    JOptionPane.showMessageDialog(RaceGUI.this, errorMessage);
                }

                //Otherwise, data was validated successfully. Calculate the schedule and display.

                else {

                    //Clear any data in the JList's model, which will also clear the GUI
                    distanceListModel.clear();

                    //Calculate the schedule, based on the data entered
                    ArrayList<String> schedule = raceSchedule(startDistance, targetDistance, percentIncrease);

                    //And add to the list model
                    for (String s : schedule) {
                        distanceListModel.addElement(s);
                    }
                }
            }
        });

        pack();
        setVisible(true);

    }



    private ArrayList<String> raceSchedule(double startDistance, double targetDistance, double percentIncrease) {

        ArrayList<String> results = new ArrayList<String>();

        double increase = 1 + (percentIncrease / 100);

        int weekCounter = 1;

        results.add("In the first week, you run " + startDistance +  " mile(s)");

        while (startDistance < targetDistance) {
            startDistance = startDistance * increase;
            weekCounter++;
            results.add(String.format("For week %d you need to run %.2f miles", weekCounter, startDistance));
        }

        return results;
    }

}
