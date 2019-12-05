package week10_extra_gui_examples.hello_lambda;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by clara on 12/5/19.
 * Lambda expressions version of event handlers
 */

public class ReviewGUI extends JFrame {
    private JCheckBox watchAgainCheckBox;
    private JTextField nameTextField;
    private JSlider ratingSlider;
    private JPanel mainPanel;
    private JLabel ratingLabel;
    private JLabel reviewSummaryTextField;
    
    ReviewGUI() {
        this.setContentPane(mainPanel);
        setPreferredSize(new Dimension(400, 250));
        
        configureSlider();
        
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        addListeners();
    }
    
    private void configureSlider() {
        ratingSlider.setMinimum(0);
        ratingSlider.setMaximum(5);
        ratingSlider.setValue(0);
        ratingLabel.setText("0 stars");
    }
    
    private void addListeners() {
        watchAgainCheckBox.addItemListener( l -> updateRating() );
        ratingSlider.addChangeListener( l -> sliderChanged() );
        
        // Can't do a lambda expression since there's three required methods
        nameTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateRating();
            }
    
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateRating();
            }
    
            @Override
            public void changedUpdate(DocumentEvent e) { }
        });
    }
    
    
    private void sliderChanged() {
        ratingLabel.setText(String.format("%s stars", ratingSlider.getValue()));
        updateRating();
    }
    
    
    private void updateRating() {
        String name = nameTextField.getText();
        int rating = ratingSlider.getValue();
        boolean watchAgain = watchAgainCheckBox.isSelected();
        
        if (name.isBlank()) {
            reviewSummaryTextField.setText("Enter a movie name");
        } else {
            String review = String.format("%s is reviewed %d stars. You %s watch again.",
                    name, rating, watchAgain ? "would" : "would not");
            reviewSummaryTextField.setText(review);
        }
    }
    
    /* TODO GUI needs to be fixed so components don't exend past the right side with a longer movie name.  */
    
}
