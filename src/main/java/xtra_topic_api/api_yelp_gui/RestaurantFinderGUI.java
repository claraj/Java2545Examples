package xtra_topic_api.api_yelp_gui;

import kong.unirest.Unirest;

import javax.swing.*;
import java.awt.*;

/**
 * Created by clara on 2019-09-20.
 */


public class RestaurantFinderGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JList<String> restaurantList;
    
    private DefaultListModel<String> listModel;
    
    final static String YELP_URL = "https://api.yelp.com/v3/businesses/search";
    final static String YELP_API_KEY = System.getenv("YELP_API_KEY");  // make sure this is set
    
    
    RestaurantFinderGUI() {
        super("Search for cheap restaurants in Minneapolis");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        listModel = new DefaultListModel<>();
        restaurantList.setModel(listModel);
        
        // Put the API Key in the request header as "Authorization: Bearer <YOUR API KEY>".
        
        searchButton.addActionListener( e -> {
            
            // Read search text
            String searchQuery = searchTextField.getText();
            
            // Disable button, display "Searching..." message
            searchButton.setEnabled(false);
            searchButton.setText("Searching...");
            
            // Clear list of previous results
            listModel.clear();
            
            // Make Yelp API call in the background
            YelpWorker worker = new YelpWorker(searchQuery, this);
            worker.execute();
            
        });
        
    }
    
    public void updateRestaurants(YelpResponse restaurants) {
        System.out.println("Response " + restaurants);
    
        for ( Business b : restaurants.businesses ) {
            String displayText = String.format("%s (rating %.1f) at %s, %s", b.name, b.rating, b.location.address1, b.location.city);
            System.out.println(displayText);
            listModel.addElement(displayText);
        }
    
        searchButton.setText("Search!");
        searchButton.setEnabled(true);
    
        Unirest.shutDown();
    }
}

class YelpWorker extends SwingWorker<YelpResponse, Void> {

    private String query;
    private RestaurantFinderGUI gui;
    
    YelpWorker(String query, RestaurantFinderGUI gui) {
        this.query = query;
        this.gui = gui;
    }
    
    @Override
    protected YelpResponse doInBackground() throws Exception {
    
        return Unirest.get(RestaurantFinderGUI.YELP_URL)
                .header("Authorization", "Bearer " + RestaurantFinderGUI.YELP_API_KEY)
                .queryString("term", query)
                .queryString("categories", "restaurants")
                .queryString("location", "Minneapolis,MN")
                .queryString("radius", 10000)    // 10000 meters = 10 kilometers = ~ 6 miles
                .queryString("price", 1)    // Lowest price bracket
                .queryString("limit", 50)   // max number API permits in one call
                .asObject(YelpResponse.class)
                .getBody();
    }
    
    @Override
    protected void done() {
        try {
            gui.updateRestaurants(get());
        } catch (Exception e) {
            System.out.println("Error because " + e);
        }
    }
}
