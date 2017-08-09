package week9_and_more_gui_jlist_combobox.lake_run_gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/**
 * Read data from file, add lakeVector data to Vector (like an ArrayList) and then to
 * various GUI components - a JList, JComboBox, and JTable
 * User can add new lakeVector, can view run times for all Lakes, and add new times to existing lakeVector
 * Data will be saved to a file when user quits program.
 */

public class RunningGUI extends JFrame {
    private JTextField textFieldLakeName;
    private JComboBox<Lake> comboBoxExistingLakeNames;
    private JTable tableBestTimes;
    private JTextField textFieldTime;
    private JList<Double> listAllTimesForOneLake;
    private JPanel rootPanel;
    private JButton saveAndQuitButton;
    private JButton addNewLakeButton;
    private JButton addNewTimeButton;
    private JLabel timesForLakeLabel;
    private JLabel instructions;

    Vector<Lake> lakeVector;      // All the Lake data here. A Vector is very similar to an ArrayList, but you can initialize a JList model with a Vector.

    //Models for the JList, JComboBox and JTable.
    BestTimesTableModel bestTimesTableModel;
    DefaultComboBoxModel<Lake> lakeNamesComboModel;
    DefaultListModel<Double> allTimesForOneLakeListModel;


    public RunningGUI() {

        super("Running Times");

        lakeVector = FileIO.getLakes();    // Read all data from a file

        setContentPane(rootPanel);
        pack();
        setVisible(true);

        // Create model for best times JTable
        bestTimesTableModel = new BestTimesTableModel(lakeVector);   //Provide Vector of Lakes
        // Model for lake names JComboBox
        lakeNamesComboModel = new DefaultComboBoxModel<>(lakeVector);  //Provide Vector of Lakes

        // And model for JList of all times for one lake
        allTimesForOneLakeListModel = new DefaultListModel<>();  // Will add the JList's data soon.

        //Configure each component to use its model
        tableBestTimes.setModel(bestTimesTableModel);
        comboBoxExistingLakeNames.setModel(lakeNamesComboModel);
        listAllTimesForOneLake.setModel(allTimesForOneLakeListModel);

        //Which lake is selected from the JComboBox?
        Lake selectedLake = (Lake)comboBoxExistingLakeNames.getModel().getSelectedItem();

        // Fill the JList with the selected Lake's times. This will be the first item in the JComboBox, if there is data.
        // If there's no data yet, no Lakes in the Vector, getSelectedItem returns null, don't need to do anything.
        if (selectedLake != null) {
            fillListWithLakesTimes(selectedLake);
        }


        //Add listeners here

        /** Create a new Lake, and add to the Vector of Lakes */
        addNewLakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lakeName = textFieldLakeName.getText();

                // Validation. Make sure user has entered a name.
                if (lakeName == null || lakeName.length() == 0) {
                    JOptionPane.showMessageDialog(RunningGUI.this, "Please enter a name");
                    return;
                }

                // More validation: check to see if this list already exists, display error message if so.
                // Search the lakesVector for this name - must ignore case - "Como" is the same lake as as "como".
                for (Lake l : lakeVector) {
                    if (l.getName().equalsIgnoreCase(lakeName)) {
                        JOptionPane.showMessageDialog(RunningGUI.this, "This lake already exists");
                        return;
                    }
                }

                //If validation passes, then create new Lake object
                Lake newLake = new Lake(lakeName);

                //Add new Lake to the Lake name combobox model. This will add the Lake to the Vector that the ComboBox model is created with.
                // Conveniently, since the JTable Model also uses the same vector, this causes the JTable's data model to be updated too.
                // And, the Vector lakeVector is also updated - all of these have a reference to the same Vector.
                lakeNamesComboModel.addElement(newLake);

                bestTimesTableModel.fireTableDataChanged();  //Although we have to tell the JTable's model that it's data has changed, which causes the JTable to redraw with the new data.

            }
        });

        /** Add a new time to the Lake selected in the JComboBox.
         * Do some validation - make sure time is a double, and positive. */
        addNewTimeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Which lake is selected?
                Lake selectedLake = (Lake) comboBoxExistingLakeNames.getSelectedItem();  //TODO  CAST

                try {
                    double timeEntered = Double.parseDouble(textFieldTime.getText());
                    if (timeEntered <= 0) {
                        JOptionPane.showMessageDialog(RunningGUI.this, "Please enter a positive number");
                        return;
                    }

                    //Add new time to this Lake.
                    selectedLake.addTime(timeEntered);
                    //Refresh the JComboBox
                    fillListWithLakesTimes(selectedLake);
                    //And refresh the JTable
                    bestTimesTableModel.fireTableDataChanged();
                    //And then clear the JTextBox to prevent accidental duplicate entries
                    textFieldTime.setText(null);


                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(RunningGUI.this, "Please enter a number");
                }


            }
        });


        /** Listener for selection made from JComboBox.
         * When a selection is made, update the JList to show the best times for this lake. */
        comboBoxExistingLakeNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Set the label...
                String prefix = "Times for ";
                timesForLakeLabel.setText(prefix + comboBoxExistingLakeNames.getSelectedItem().toString());

                //And fill the JList with times for this lake

                RunningGUI.this.fillListWithLakesTimes((Lake) comboBoxExistingLakeNames.getSelectedItem());

            }
        });



        /** Listener for Quit button. Save all data, then exit */
        saveAndQuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Check that the user wants to quit using a JOptionPane dialog

                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(RunningGUI.this, "Are you sure you want to save and exit?", "Exit?", JOptionPane.OK_CANCEL_OPTION)) {
                    //Save all of the data...
                    FileIO.saveLakes(lakeVector);
                    //And quit.
                    System.exit(0);
                }
            }
        });


    }

    /** Convenience method to clear JList, and fill with all times for one lake. */

    private void fillListWithLakesTimes(Lake lake) {

        allTimesForOneLakeListModel.removeAllElements();
        //Get array of times for this lake. The Lake object sorts them in order, fastest first.
        double[] times = lake.getTimes();
        //Loop over array, and add each time to the JList model, which will then be shown in the JList.
            for (double t : times){
                allTimesForOneLakeListModel.addElement(t);
            }

        }
    }


