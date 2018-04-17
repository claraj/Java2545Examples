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
        this.controller = controller;  //Store a reference to the controller object.
        // Need this to make requests to the database.
        
        
        //Configure the list model
        
        allPlacesListModel = new DefaultListModel<Place>();
        placeList.setModel(allPlacesListModel);
        
        //and listeners - only one in this program, but put in method to keep tidy.
        addListeners();
        
        //Regular setup stuff for the window / JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        
    }
    
    private void addListeners() {
        
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
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Read data, send message to database via controller
                
                String place = placeNameText.getText();
                
                if (place.isEmpty()) {
                    JOptionPane.showMessageDialog(PlaceGUI.this, "Enter a place name", "Error adding new place", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double elev;
                
                try {
                    elev = Double.parseDouble(elevationText.getText());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(PlaceGUI.this, "Enter a number for elevation", "Error adding new place", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(PlaceGUI.this, result, "Error adding new place", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    
    
    void setListData(ArrayList<Place> data) {
        
        //Display data in allDataTextArea
        allPlacesListModel.clear();
        
        if (data != null) {
            for (Place place : data) {
                allPlacesListModel.addElement(place);
            }
        }
    }
    
}

