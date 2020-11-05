package week10_and_more_gui_jlist_combobox.todo_right_click_delete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ToDoList extends JFrame {
    private JTextField newToDoTextField;
    private JList<String> toDoList;

    private DefaultListModel<String> listModel;     // A JList needs a model to provide data

    private JButton addToDoButton;
    private JPanel rootPanel;

    protected ToDoList() {

        setTitle("To Do List");
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(550, 500));

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
    
        configureRightClickMenu();
        
        pack();
        setVisible(true);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    private void configureRightClickMenu() {
        
        // Create a menu and a listener for the menu item
        JPopupMenu rightClickMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Delete");
        rightClickMenu.add(deleteMenuItem);
        
        deleteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete
                deleteSelected();
            }
        });
        
        // Associate the popup menu with the JList
        toDoList.setComponentPopupMenu(rightClickMenu);
        
        // Add a mouse listener to select item in list when user right-clicks.
        // The list items are only selected with left clicks. So without this,
        // the popup will be associated with the correct item, but that item won't
        // automatically be selected when the user right-clicks on it - whatever was
        // last selected would still be selected, which would be confusing.
        
        toDoList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selection = toDoList.locationToIndex(e.getPoint());
                toDoList.setSelectedIndex(selection);
            }
    
            // Even though we don't need these events to do anything, still
            // required to provide the methods.
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        
    }
    
    private void deleteSelected() {
    
        int selectedIndex = toDoList.getSelectedIndex(); //Ask the LIST what is selected

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select an item to delete");
        } else {
            String deleteItem = toDoList.getSelectedValue();
            if (JOptionPane.showConfirmDialog(this, "Delete " + deleteItem + "?", "Delete",
                    JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {

                listModel.remove(selectedIndex);  //Remove this item from the MODEL.

            }
        }
        
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
                if (newToDo.isEmpty()) {
                    // show a popup
                    JOptionPane.showMessageDialog(ToDoList.this, "Enter a to do item.");
                }
    
                listModel.addElement(newToDo);  //Add new item to the JList's MODEL.
                newToDoTextField.setText("");  //Clear the JTextField
            }
        });
        
    }
    
}
