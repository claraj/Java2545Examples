package week9_and_more_gui_jlist_combobox.todo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoList extends JFrame {
    private JTextField newToDoTextField;
    private JList<String> toDoList;

    private DefaultListModel<String> listModel;     // A JList needs a model to provide data

    private JButton addToDoButton;
    private JPanel rootPanel;

    protected ToDoList() {
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));

        listModel = new DefaultListModel<String>();
        // Create a listModel. The list starts empty, so no data to add yet.
        // When you add data to the list, you actually need to add it to the list's * model *.

        //Configure the JList to use this model as its data source.
        toDoList.setModel(listModel);

        addListeners();    //Move event listener configuration into separate method, keep things tidier .

        //Configure the submitButton to be the default button that is clicked when the user presses the Enter key
        getRootPane().setDefaultButton(addToDoButton);

        pack();
        setVisible(true);
    }





    private void addListeners() {

        //Need to listen for button clicked,
        //Read the text in the text box and add this to the list.

        addToDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newToDo = newToDoTextField.getText();
                newToDo = newToDo.trim(); //remove whitespace

                //Check to see if the JTextField is empty - if so, ignore.
                if (newToDo.length() == 0) {
                    return;
                }

                listModel.addElement(newToDo);  //Add new item to the JList's MODEL.
                newToDoTextField.setText("");  //Clear the JTextField
            }
        });

        //And, listen for the list being clicked on, which should remove the selected item.

        toDoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //What was selected?
                int selectedIndex = toDoList.getSelectedIndex(); //Ask the LIST what is selected
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);  //Remove this item from the MODEL.
                }
            }
        });
    }


}
