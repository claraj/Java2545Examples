package week11_database_and_gui.elevation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all user interface tasks
 */

public class PlaceGUI extends JFrame {
    
    private JTextField placeNameText;
    private JTextField elevationText;
    private JList<Place> placeList;
    private JButton addButton;
    private JPanel mainPanel;
    private JButton deleteButton;

    private Controller controller;
    
    private DefaultListModel<Place> allPlacesListModel;
    
    PlaceGUI(Controller controller) {

        // Store a reference to the controller object.
        // Use to make requests to the controller, which will forward requests to DB
        this.controller = controller;

        // Configure the list model
        allPlacesListModel = new DefaultListModel<>();
        placeList.setModel(allPlacesListModel);

        placeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add button is clicked when user presses Enter/Return key
        getRootPane().setDefaultButton(addButton);

        addListeners();   // Configure listeners in separate method

        // Regular setup tasks for the window / JFrame
        setTitle("Place Elevation GUI");
        setPreferredSize(new Dimension(350, 400));
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        List<Place> allPlaces = controller.getAllData();
        setListData(allPlaces);
    }
    
    
    private void errorDialog(String msg) {
        JOptionPane.showMessageDialog(PlaceGUI.this, msg, "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void addListeners() {

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = placeNameText.getText();

                if (name.isBlank()) {
                    errorDialog("Enter a place name");
                    return;
                }
            
                double elev;
            
                try {
                    elev = Double.parseDouble(elevationText.getText());
                } catch (NumberFormatException nfe) {
                    errorDialog("Enter a number for elevation");
                    return;
                }

                Place placeRecord = new Place(name, elev);
                boolean added = controller.addPlaceToDatabase(placeRecord);

                if (added) {
                    placeNameText.setText("");
                    elevationText.setText("");

                    // And request all data from DB to update list
                    List<Place> allData = controller.getAllData();
                    setListData(allData);

                } else {
                    errorDialog("Unable to add this place.");
                }
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Identify which places are selected
                List<Place> placesToDelete = placeList.getSelectedValuesList();
                if (placesToDelete == null || placesToDelete.isEmpty()) {
                    JOptionPane.showMessageDialog(PlaceGUI.this, "Please select at least one place to delete");
                } else {
                    for (Place place : placesToDelete) {
                        controller.deletePlace(place);
                    }

                    // Get the updated list of places and display in JList
                    List<Place> places = controller.getAllData();
                    setListData(places);
                }
            }
        });

    }

    void setListData(List<Place> places) {
        // Convenience method to update list.
        // Clear list model, and display all place data in JList
        allPlacesListModel.clear();

        if (places != null) {
            allPlacesListModel.addAll(places);
        }
    }
}




