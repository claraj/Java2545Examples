package week11_database_and_gui.elevation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by clara on 4/16/18.
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
    
        //Store a reference to the controller object.
        // Need this to make requests to the controller, which will forward requests to the database.
        this.controller = controller;
        
        //Configure the list model
        allPlacesListModel = new DefaultListModel<>();
        placeList.setModel(allPlacesListModel);
        
        addListeners();   // Configure listeners in separate method
        
        // Regular setup tasks for the window / JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }
    
    
    private void errorDialog(String msg) {
        JOptionPane.showMessageDialog(PlaceGUI.this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void addListeners() {
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Read data, send message to database via controller
                String place = placeNameText.getText();
                
                if (place.isEmpty()) {
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
                
                Place placeRecord = new Place(place, elev);
                String result = controller.addPlaceToDatabase(placeRecord);
                
                if (result.equals(PlaceDB.OK)) {
                    
                    // Clear input JTextFields
                    placeNameText.setText("");
                    elevationText.setText("");
                    
                    // And request all data from DB to update list
                    ArrayList<Place> allData = controller.getAllData();
                    setListData(allData);
                    
                } else {
                    errorDialog(result);
                }
            }
        });
        
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Identify what is selected
                Place place = placeList.getSelectedValue();
                if (place == null) {
                    JOptionPane.showMessageDialog(PlaceGUI.this, "Please select a place to delete");
                } else {
                    controller.deletePlace(place);
                    ArrayList<Place> places = controller.getAllData();
                    setListData(places);
                }
            }
        });
    }
    
    
    void setListData(ArrayList<Place> data) {
        // Convenience method to update list.
        // Clear list model, and display all place data in JList
        allPlacesListModel.clear();
        
        if (data != null) {
            for (Place place : data) {
                allPlacesListModel.addElement(place);
            }
        }
    }
}


