package week10_and_more_gui_jlist_combobox.vehicles;

import javax.swing.*;
import java.awt.*;

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
    private JList vehicleList;
    
    VehicleGUI() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}




