package week10_and_more_gui_jlist_combobox.running_trainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by clara on 11/1/2016.
 * <p>
 * GUI version of the Week 3 program - calculate a training schedule for a
 * runner who wants to increase the distance they can run over a period of weeks.
 */


public class RunningGUI extends JFrame {
    private JPanel root;
    private JButton calculateButton;
    private JList<String> distanceList;
    private JTextField percentIncreaseTextField;
    private JTextField targetDistanceTextField;
    private JTextField startDistanceTextField;
    private DefaultListModel<String> distanceListModel;

    RunningGUI() {

        setContentPane(root);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        distanceListModel = new DefaultListModel<>();
        distanceList.setModel(distanceListModel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculateButtonClick();
            }
        });

        pack();
        setVisible(true);

    }


    private void handleCalculateButtonClick(){
        //Fetch data from the three JTextFields, and validate
        
        String errorMessage = null;  // If no errors, this will not be changed from null
        
        double startDistance = 0 , targetDistance = 0 , percentIncrease = 0;
        try {
            startDistance = Double.parseDouble(startDistanceTextField.getText());
            targetDistance = Double.parseDouble(targetDistanceTextField.getText());
            percentIncrease = Double.parseDouble(percentIncreaseTextField.getText());
        
            if (startDistance <= 0) {
                errorMessage = "Please enter a positive start distance. It must be greater than 0.";
            }
        
            else if (targetDistance <= 0 || targetDistance <= startDistance) {
                errorMessage = "Target distance must be greater than start distance";
            }
        
            else if (percentIncrease < 1 || percentIncrease > 100) {
                errorMessage = "Please enter a positive percent value, between 1 and 100";
            }
            
        } catch (NumberFormatException nfe) {
            errorMessage = "Please enter numerical values for all three inputs";
        }
    
        //Show error dialog if errorMessage has been set
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(RunningGUI.this, errorMessage);
        }
    
        // Otherwise, data was validated successfully. Calculate the schedule and display.
    
        else {
        
            // Clear any data in the JList's model, which will also clear the JList in the GUI
            distanceListModel.clear();
        
            // Calculate the schedule, based on the data entered
            List<String> schedule = raceSchedule(startDistance, targetDistance, percentIncrease);
        
            // And add to the list model
            for (String s : schedule) {
                distanceListModel.addElement(s);
            }
        }
    
    }
    

    private List<String> raceSchedule(double startDistance, double targetDistance, double percentIncrease) {

        List<String> results = new ArrayList<String>();

        double increase = 1 + (percentIncrease / 100);

        int weekCounter = 1;

        results.add("In the first week, you run " + startDistance +  " miles");

        while (startDistance < targetDistance) {
            startDistance = startDistance * increase;
            weekCounter++;
            results.add(String.format("For week %d you need to run %.2f miles", weekCounter, startDistance));
        }

        return results;
    }

}
