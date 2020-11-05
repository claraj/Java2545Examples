package week10_and_more_gui_jlist_combobox.todo_delete_button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoList extends JFrame {
    private JTextField newToDoTextField;
    private JList<String> toDoList;

    private DefaultListModel<String> listModel;     // A JList needs a model to provide data

    private JButton addToDoButton;
    private JButton deleteSelectedButton;
    private JPanel rootPanel;

    protected ToDoList() {

        setTitle("To Do List");
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));

        listModel = new DefaultListModel<>();
        // Create a listModel. The list starts empty, so no data to add yet.
        // When you add data to the list, you actually need to add it to the list's * model *.

        //Configure the JList to use this model as its data source.
        toDoList.setModel(listModel);
    
        // Single selection model - user can only select one thing from the list at a time
        toDoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        addListeners();    //Move event listener configuration into separate method, keep things tidier .

        //Configure the submitButton to be the default button that is clicked when the user presses the Enter key
        getRootPane().setDefaultButton(addToDoButton);

        pack();
        setVisible(true);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }





    private void addListeners() {

        //Need to listen for button clicked,
        //Read the text in the text box and add this to the list.

        addToDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newToDo = newToDoTextField.getText();
                newToDo = newToDo.trim(); //remove whitespace
    
                // Was some text entered?
                if (newToDo.isEmpty()) {
                    // If not, show a popup
                    JOptionPane.showMessageDialog(ToDoList.this, "Enter a to do item.");
                } else {
                    listModel.addElement(newToDo);  //Add new item to the JList's MODEL.
                    newToDoTextField.setText("");  //Clear the JTextField
                }
            }
        });

        
        deleteSelectedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
    
                int selectedIndex = toDoList.getSelectedIndex(); //Ask the LIST what is selected
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);  //Remove this item from the MODEL.
                } else {
                    JOptionPane.showMessageDialog(ToDoList.this, "Please select an item to delete");
                }
            }
            
        });
        
    }
    
}
