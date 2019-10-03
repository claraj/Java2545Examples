package week10_extra_gui_examples.menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Clara on 3/29/17.
 *
 * To add a menu bar, you'll have to create in code.
 *
 * In the IntellJ designer, add an empty JPanel where you want your menu to be, and give it a name.
 * menuPanel in this code.  In the designer, change the LayoutManager to BorderLayout. You can use
 * anything other than the IntelliJ GridLayoutManager - it's a bug in IntelliJ, and you'll get a NullPointerException
 * when you run your code if you don't change the layout manager.
 *
 * Create a JMenuBar, as many JMenus as you need, and JMenuItems. Add JMenuItems to the JMenu that
 * they should be part of, and add your JMenus to your JMenuBar.
 *
 * And, to make something happen when you select a JMenuItem, add an ActionListener to each.
 */
public class MenuGUI extends JFrame {
    private JPanel menuPanel;
    private JLabel whatSelected;
    private JPanel mainPanel;


    // You'll need to add these, not part of the GUI designer palette.
    private JMenuBar menuBar;
    private JMenu optionsMenu;
    private JMenu selectionsMenu;

    private JMenuItem goOption;
    private JMenuItem noOption;
    private JMenuItem yesSelection;
    private JMenuItem messSelection;


    MenuGUI() {

        setContentPane(mainPanel);

        configureMenus();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    private void configureMenus() {

        // Initialize the menu bar, menus, menu items.

        menuBar = new JMenuBar();
        optionsMenu = new JMenu("Options");   // Argument is the menu name, displayed in the menu bar.
        selectionsMenu = new JMenu("Selections");

        goOption = new JMenuItem("Go!");
        noOption = new JMenuItem("No!");

        yesSelection = new JMenuItem("Yes");
        messSelection = new JMenuItem("I guess.");

        // Add listeners

        goOption.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                go();
           }
       });

        noOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                no();
            }
        });

        yesSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yes();
            }
        });

        messSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guess();
            }
        });


        // Add JMenuItem to JMenu objects, in the order you want them to be displayed.
        optionsMenu.add(goOption);
        optionsMenu.add(noOption);

        selectionsMenu.add(yesSelection);
        selectionsMenu.add(messSelection);

        // Add JMenu objects to menuBar. They'll display in the order you add them.
        menuBar.add(optionsMenu);
        menuBar.add(selectionsMenu);

        // And then add the menuBar to the menuPanel.
        // menuPanel uses the BorderLayout layout manager, which requires you to
        // to specify where in the panel the new component will be added - WEST, NORTH, EAST, SOUTH, or CENTER

        // TODO make sure you change the LayoutManager for menuPanel JPanel to BorderLayout in the GUI designer
        menuPanel.add(menuBar, BorderLayout.WEST);

        // Read the JavaDoc for more ways of configuring menus, for example, disabling options, key shortcuts, separators, sub-menus...


    }


    // You could definitely replace these with more exciting things.

    private void go() {
        whatSelected.setText("Go!");
    }


    private void no() {
        whatSelected.setText("No.");
    }


    private void yes() {
        whatSelected.setText("Yes!");
    }

    private void guess() {
        whatSelected.setText("Well, I guess.");
    }

}
