package week10_extra_gui_examples.progress_bar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by clara on 12/4/17.
 */
public class PeriodicUpdates extends JFrame {
    private JProgressBar progressBar;
    private JPanel rootPanel;
    private JButton pressToStartButton;
    private JLabel outputLabel;
    
    PeriodicUpdates() {
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        eventHandlers();
        
        progressBar.setStringPainted(true);
    }
    
    private void eventHandlers() {
        
        pressToStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Worker worker = new Worker();
                worker.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        
                        if (evt.getNewValue().equals(SwingWorker.StateValue.STARTED)) {
                            outputLabel.setText("Processing....");
                        }
                        
                        if (evt.getPropertyName().equals("progress")) {
                            progressBar.setValue((Integer) evt.getNewValue() );
                         }
    
                        if (evt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
                            outputLabel.setText("All done");
                        }
                    }
                });
                
                worker.execute();
            }
            
            
            
        });
        
    }
    
}
