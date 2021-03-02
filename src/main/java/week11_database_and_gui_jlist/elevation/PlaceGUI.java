package week11_database_and_gui_jlist.elevation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton searchButton;
    private JTextField searchText;
    private JButton changeElevationForPlaceButton;
    private JTextField changeElevationForPlaceText;
    private JTextField newElevationText;

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
        setPreferredSize(new Dimension(350, 600));
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        List<Place> allPlaces = controller.getAllData();
        setListData(allPlaces);
    }


    private void showErrorDialog(String msg) {
        JOptionPane.showMessageDialog(PlaceGUI.this, msg, "Error",
                JOptionPane.ERROR_MESSAGE);
    }


    private void selectPlaceInList(String name) {
        for (int x = 0; x < allPlacesListModel.size(); x++) {
            Place place = allPlacesListModel.get(x);
            if (place.getName().equalsIgnoreCase(name)) {
                placeList.setSelectedIndex(x);
                break;
            }
        }
    }


    void setListData(List<Place> places) {
        // Convenience method to update list.
        // Clear list model, and display all place data in JList
        allPlacesListModel.clear();

        if (places != null) {
            allPlacesListModel.addAll(places);
        }
    }


    private void addListeners() {

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = placeNameText.getText();

                if (name.isBlank()) {
                    showErrorDialog("Enter a place name");
                    return;
                }
            
                double elev;
            
                try {
                    elev = Double.parseDouble(elevationText.getText());
                } catch (NumberFormatException nfe) {
                    showErrorDialog("Enter a number for elevation");
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
                    showErrorDialog("Unable to add this place.");
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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = searchText.getText();
                if (search.isBlank()) {
                    showErrorDialog("Enter a place name to search for");
                    placeList.clearSelection();
                } else {
                    Double elevation = controller.getElevationForPlace(search);
                    if (elevation == null) {
                        showErrorDialog("Place not found");
                        placeList.clearSelection();
                    } else {
                        // select the place in the JList
                        selectPlaceInList(search);

                        JOptionPane.showMessageDialog(PlaceGUI.this,
                                "The elevation of " + search + " is " + elevation + " meters");
                    }
                }
            }
        });

        changeElevationForPlaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = changeElevationForPlaceText.getText();
                if (name.isBlank()) {
                    showErrorDialog("Enter a place name to change elevation for");
                    return;
                }

                double newElevation;
                try {
                    newElevation = Double.parseDouble(newElevationText.getText());
                } catch (NumberFormatException ex) {
                    showErrorDialog("Enter a number for elevation");
                    return;
                }

                Place updatedPlace = new Place(name, newElevation);
                boolean success = controller.updatePlace(updatedPlace);
                if (success) {
                    List<Place> places = controller.getAllData();
                    setListData(places);
                    // select place that was updated in the list
                    selectPlaceInList(name);
                } else {
                    showErrorDialog("Can't update place, check the place name is correct?");
                    placeList.clearSelection();
                }
            }
        });
    }


}




