package week9_and_more_gui_jlist_combobox.dog;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DogGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField dogNameTextField;
    private JTextField dogAgeTextField;
    private JCheckBox puppyCheckBox;
    private JButton addDogToListButton;
    private JList<Dog> dogJList;
    private JButton deleteDogButton;

    private DefaultListModel<Dog> dogListModel;

    DogGUI() {

        setTitle("List of Dogs");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        dogListModel = new DefaultListModel<>();
        dogJList.setModel(dogListModel);
        //Configure JList to only allow user to select one item at a time
        //Default is multiple selections.
        dogJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addDogToListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Read data from JTextFields and JCheckBox
                String dogName = dogNameTextField.getText();
                //Check that user entered a name
                if (dogName.trim().length() == 0) {
                    JOptionPane.showMessageDialog(DogGUI.this, "Please enter a name");
                    return;
                }

                double dogAge;

                // Basic validation - check that age is a positive number
                try {
                    dogAge = Double.parseDouble(dogAgeTextField.getText());
                    if (dogAge < 0) {
                        JOptionPane.showMessageDialog(DogGUI.this, "Enter a positive number for age");
                        return;
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(DogGUI.this, "Enter a number for age");
                    return;
                }
                boolean isPuppy = puppyCheckBox.isSelected();

                // Create Dog and add to JList's model
                Dog newDog = new Dog(dogName, dogAge, isPuppy);
                dogListModel.addElement(newDog);

                //Clear input fields
                dogNameTextField.setText("");
                dogAgeTextField.setText("");
                puppyCheckBox.setSelected(false);
            }
        });

        deleteDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask the JLIST what Dog is selected
                // Notice since we've used generic types, setSelectedValue returns a Dog.
                // Without generic types, it would return an Object, and we'd have to cast it.
                Dog toDelete = dogJList.getSelectedValue();
                // Delete this Dog from the MODEL
                dogListModel.removeElement(toDelete);
            }
        });
    }
}
