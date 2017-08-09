package week9_and_more_gui_jlist_combobox.movie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MovieRatingGUI extends JFrame{
    private JPanel rootPanel;
    private JComboBox<String> movieRatingcomboBox;
    private JTextField movieNameTextField;
    private JButton submitButton;


    protected MovieRatingGUI() {

        this.setContentPane(rootPanel);

        configureRatings();
        configureButton();

        pack();
        setVisible(true);

    }


    // Add ratings 1 to 5 to the JComboBox.
    private void configureRatings() {

        for (int x = 1 ; x <= 5 ; x++ ) {
            if (x == 1) {
                movieRatingcomboBox.addItem(x + " star");
            } else {
                movieRatingcomboBox.addItem(x + " stars");
            }
        }

    }

    private void configureButton() {

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Read name of movie
                String movieName = movieNameTextField.getText();
                //What rating did the user select? Need to cast to expected type
                String rating = (String)movieRatingcomboBox.getSelectedItem();

                String result = "You gave " + movieName + "  " + rating;
                //Show result in dialog box
                JOptionPane.showMessageDialog(MovieRatingGUI.this, result);
            }
        });
    }
}

