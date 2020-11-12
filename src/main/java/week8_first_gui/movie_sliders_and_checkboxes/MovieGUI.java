package week8_first_gui.movie_sliders_and_checkboxes;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MovieGUI extends JFrame {
    private JSlider ratingSlider;
    private JCheckBox wouldSeeAgainCheckBox;
    private JLabel sliderValueLabel;
    private JLabel movieOpinionLabel;
    private JTextField movieTitleTextField;
    private JPanel mainPanel;
    private JButton quitButton;
    
    MovieGUI() {
        setTitle("Movies");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 300));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configureEventHandlers();
    }
    
    private void configureEventHandlers() {
    
        // Moving the ratingSlider updates the sliderValueLabel and updates the opinion String
        ratingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String valueLabelText = ratingSlider.getValue() + " stars";
                sliderValueLabel.setText(valueLabelText);
                updateOpinion();
            }
        });
    
    
        // Checkbox change listener - updates the opinion String
        wouldSeeAgainCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateOpinion();
            }
        });
    
        // Typing in the text box - a little trickier. Add a listener to the JTextBox's Document
        // Update the opinion String as the user types or deletes text.
    
        movieTitleTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Called when user types or adds text
                updateOpinion();
            }
        
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Called when user deletes text
                updateOpinion();
            }
        
            @Override
            public void changedUpdate(DocumentEvent e) { }  // Need this method, but it doesn't need any code.
        });
    
        
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (JOptionPane.showConfirmDialog(MovieGUI.this, "Are you sure you want to quit?",
                        "Quit", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    dispose();
                }
            }
        });

    }
    
    
    private void updateOpinion() {
        
        String title = movieTitleTextField.getText();
        
        // If the movie is blank, or just whitespace, clear opinion text
        if (title.trim().length() == 0) {
            movieOpinionLabel.setText("Enter a movie title");
        }
        
        else {
            int rating = ratingSlider.getValue();
            
            boolean seeAgain = wouldSeeAgainCheckBox.isSelected();
    
            String template = "You rated '%s' %d stars. You %s see again.";
    
            String seeAgainStr = seeAgain ? "would" : "would not";
            
            String opinion = String.format(template, title, rating, seeAgainStr);
    
            movieOpinionLabel.setText(opinion);
        }
    }
    
}



