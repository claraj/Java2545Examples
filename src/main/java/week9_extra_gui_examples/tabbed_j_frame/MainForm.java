package week9_extra_gui_examples.tabbed_j_frame;

import javax.swing.*;

/**
 * Created by admin on 5/6/15.
 */
public class MainForm extends JFrame {

    private JPanel rootPanel;

    //Not created in GUI designer
    private JTabbedPane tabbedPane;


    //Note that this fails with a NullPointer if the default layoutmanager (GridLayoutManager) for this form is used
    //Since all it does is hold the JTabbedPane, set the layout manager to something (probably anything) else).

    public MainForm() {
        setContentPane(rootPanel);

        //Create a a JTabbedPanel, add to JPanel, add tabs to JTabbedPane.
        tabbedPane = new JTabbedPane();
        rootPanel.add(tabbedPane);
        tabbedPane.add("Tab 1", new Tab1().getPanel());
        tabbedPane.add("Tab 2", new Tab2().getPanel());

        setVisible(true);
        pack();


    }


}
