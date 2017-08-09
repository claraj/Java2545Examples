package week9_extra_gui_examples.card_layout_switch_views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CardLayout enables creating several Cards, each containing a GUI layout,
 * and switching between them in code.
 * Look at the GUI designer - there are 3 JPanel created inside the rootPanel.
 * Each one is a card and can be designed individually.
 */
public class DataEntry extends JFrame{
    private JPanel rootPanel;
    private JPanel question1panel;
    private JPanel question2panel;
    private JPanel summaryPanel;
    private JLabel summaryLabel;
    private JButton continueFromColorButton;
    private JTextField colorTextField;
    private JButton continueFromNameButton;
    private JButton startOverButton;
    private JTextField nameTextField;

    private static String NAME_QUESTION = "name question panel";
    private static String COLOR_QUESTION = "color question panel";
    private static String SUMMARY = "summary of answers panel";


    private String userName;
    private String userFavColor;

    DataEntry() {

        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Add the cards to the root JPanel. Each card is a JPanel containing other components
        //The first card added is the first one shown when the GUI starts.
        //Each card needs a String label to identify it, recommended to use constants.


        //The order that you add the cards in is important
        //When you ask CardLayout to show the next card, it will use the order that you added them
        //to decide what the next card is.
        rootPanel.add(question1panel, NAME_QUESTION);
        rootPanel.add(question2panel, COLOR_QUESTION);
        rootPanel.add(summaryPanel, SUMMARY);


        continueFromNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Save data entered and move to next card.
                CardLayout cl = (CardLayout) rootPanel.getLayout();
                userName = nameTextField.getText();
                cl.show(rootPanel, COLOR_QUESTION);

                //you can also say cl.next(rootPanel) to move to the next card
                //and if you wanted to go backwards, then cl.prev(rootPanel);

                //This is the summary label in the last card, keep it updated
                summaryLabel.setText("Your name is " + userName + " and your favorite color is " + userFavColor);

            }
        });


        continueFromColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Save data entered and move to next card.
                CardLayout cl = (CardLayout) rootPanel.getLayout();
                userFavColor = colorTextField.getText();

                //This is the summary label in the last card - keep it updated
                summaryLabel.setText("Your name is " + userName + " and your favorite color is " + userFavColor);


                cl.show(rootPanel, SUMMARY);


            }
        });

        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) rootPanel.getLayout();

                //By default, the user's data will persist through card changes.
                //Here, I want to clear everything and start over, so clear the data.
                //If you have a lot of text fields to clear, store a reference to them in
                //an ArrayList, loop over that and set the text of each to "".
                nameTextField.setText("");
                colorTextField.setText("");
                userFavColor = "";
                userName = "";

                //Return to the first card
                cl.first(rootPanel);
            }
        });


    }



}
