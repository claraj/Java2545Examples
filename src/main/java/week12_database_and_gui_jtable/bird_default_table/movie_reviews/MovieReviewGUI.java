package week12_database_and_gui_jtable.bird_default_table.movie_reviews;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Calendar;
import java.util.Vector;


public class MovieReviewGUI extends JFrame {
    
    private JTable movieDataTable;
    private JPanel rootPanel;
    private JTextField titleTextField;
    private JTextField yearTextField;
    private JButton addNewMovieButton;
    private JButton quitButton;
    private JButton deleteMovieButton;
    private JSpinner ratingSpinner;
    
    private MovieDatabase db;
    
    private DefaultTableModel tableModel;
    private Vector columnNames;
    
    MovieReviewGUI(MovieDatabase db) {
    
        this.db = db;
        
        setContentPane(rootPanel);
        pack();
        setTitle("Movie Database Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        configureTable();
        
        //Set up the rating spinner. SpinnerNumberModel constructor arguments: spinner's initial value, min, max, step.
        ratingSpinner.setModel(new SpinnerNumberModel(1, MovieDatabase.MOVIE_MIN_RATING, MovieDatabase.MOVIE_MAX_RATING, 1));
        
        
        setVisible(true);
        
        //Event handlers for add, delete and quit buttons
        addNewMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMovie();
            }
        });
        
        deleteMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedMovie();
            }
        });
    
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieReviewGUI.this.dispose();  // Closes this JFrame, which ends the program.
            }
        });
    
    }
    
    
    private void addMovie() {
        //Get Movie title, make sure it's not blank
        String titleData = titleTextField.getText();
        
        if (titleData == null || titleData.trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a title for the new movie");
            return;
        }
        
        //Get movie year. Check it's a number between 1900 and present year
        int yearData;
        
        try {
            yearData = Integer.parseInt(yearTextField.getText());
            if (yearData < 1900 || yearData > Calendar.getInstance().get(Calendar.YEAR)){
                //Calendar.getInstance() returns a Calendar object representing right now.
                //calenderObject.get(Calendar.MONTH) gets current month, calenderObject.get(Calendar.SECOND) gets current second
                //Can get and set other time/date fields- check Java documentation for others
                //http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
                throw new NumberFormatException("Year needs to be between 1900 and present year");
            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(rootPane,
                    "Year needs to be a number between 1900 and now");
            return;
        }
        
        // Assuming we've configured the spinner correctly, the only choices are valid ones.
        // So no validation needed.
        int ratingData = (int) ratingSpinner.getValue();
        
        db.addMovie(titleData, yearData, ratingData);
        
        // Clear input JTextAreas for user to enter another movie
        titleTextField.setText("");
        yearTextField.setText("");
        
        updateTable();
        
    }
    
    
    private void deleteSelectedMovie() {
        
        int currentRow = movieDataTable.getSelectedRow();
    
        if (currentRow == -1) {      // -1 means no row is selected. Display error message.
            JOptionPane.showMessageDialog(rootPane, "Please choose a movie to delete");
        }

        else {
            // Get the ID of the selected movie
            int id = (Integer) tableModel.getValueAt(currentRow, 0);
            db.deleteMovie(id);
            updateTable();
        }
    }
    
    
    private void configureTable() {
    
        // Show a black grid - default is white and not visible on the white background
        movieDataTable.setGridColor(Color.BLACK);
        
        // Enable sorting
        movieDataTable.setAutoCreateRowSorter(true);
    
        columnNames = db.getColumnNames();
        Vector<Vector> data = db.getAllMovies();
    
        // Custom methods for DefaultTableModel
        // Want to customize which cells are editable - the isCellEditable method
        // And, what happens when an editable cell is edited - the setValueAt method
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return (col == 3);  // Rating column only.
            }
        
            @Override
            public void setValueAt(Object val, int row, int col) {
            
                // Get row and send new value to DB for update
                int id = (int) getValueAt(row, 0);
            
                try {
                    int newRating = Integer.parseInt(val.toString());
                    if (newRating < MovieDatabase.MOVIE_MIN_RATING || newRating > MovieDatabase.MOVIE_MAX_RATING) {
                        throw new NumberFormatException();
                    }
                    db.changeRating(id, newRating);
                    updateTable();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(MovieReviewGUI.this, "Enter a number between 1 and 5 for the rating");
                }
            }
        };
    
        movieDataTable.setModel(tableModel);
    }
    
    
    private void updateTable() {
        Vector<Vector> data = db.getAllMovies();
        tableModel.setDataVector(data, columnNames);
    }
    
}