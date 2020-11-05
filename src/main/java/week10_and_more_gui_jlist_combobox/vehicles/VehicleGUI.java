package week10_and_more_gui_jlist_combobox.vehicles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by clara on 10/21/19.
 */

public class VehicleGUI extends JFrame {
    private JPanel mainPanel;
    private JCheckBox electricCheckBox;
    private JTextField nameTextField;
    private JTextField makeTextField;
    private JTextField modelTextField;
    private JButton addButton;
    private JList<Vehicle> vehicleList;
    private JButton deleteButton;
    
    private DefaultListModel<Vehicle> vehicleListModel;
    
    VehicleGUI() {
        setTitle("Vehicle List");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        vehicleListModel = new DefaultListModel<>();
        vehicleList.setModel(vehicleListModel);
        
        vehicleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String make = makeTextField.getText();
                String model = modelTextField.getText();
                boolean isElectric = electricCheckBox.isSelected();
                
                // Verify all text fields are filled in
                if (name.isBlank() || make.isBlank() || model.isBlank()) {
                    JOptionPane.showMessageDialog(VehicleGUI.this, "Fill in all fields");
                    return;
                }
                
                Vehicle vehicle = new Vehicle(name, make, model, isElectric);
                vehicleListModel.addElement(vehicle);
                
                // Clear the input components
                nameTextField.setText("");
                makeTextField.setText("");
                modelTextField.setText("");
                electricCheckBox.setSelected(false);
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // What Vehicle is selected?
                Vehicle selectedVehicle = vehicleList.getSelectedValue();
                
                if (selectedVehicle == null) {
                    return;
                }
                
                if (JOptionPane.showConfirmDialog(VehicleGUI.this,
                        "Delete " + selectedVehicle.getName() + "?",
                        "Delete Vehicle",
                        JOptionPane.OK_CANCEL_OPTION ) == JOptionPane.OK_OPTION) {
                    
                    // Only if user selects OK, remove this Vehicle from list model
                    vehicleListModel.removeElement(selectedVehicle);
                }
            }
        });
        
    }
    
}




