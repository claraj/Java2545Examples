package xtra_topic_api.async_weather_gui;

import kong.unirest.Unirest;

import javax.swing.*;
import java.awt.*;

/**
 * Created by clara on 2019-09-19.
 */
public class WeatherGUI extends JFrame {
    private JButton getWeatherButton;
    private JPanel mainPanel;
    private JLabel currentConditions;
    
    private static final String DARK_SKY_KEY = System.getenv("DARK_SKY_KEY");   // Make sure this is set
    private static final String DARK_SKY_URL = "https://api.darksky.net/forecast/{api_key}/{lat},{lng}";
    
    WeatherGUI() {
        super("Minneapolis Weather");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(250, 150));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        getWeatherButton.addActionListener(ev -> {
            double lat = 45;
            double lng = -91.3;
            
            currentConditions.setText("Fetching...");
            getWeatherButton.setEnabled(false);
            
            Unirest.get(DARK_SKY_URL)
                    .routeParam("api_key", DARK_SKY_KEY)
                    .routeParam("lat", Double.toString(lat))
                    .routeParam("lng", Double.toString(lng))
                    .asObjectAsync(Weather.class, response -> {
                        Weather forecast = response.getBody();
                        currentConditions.setText(forecast.minutely.summary);
                        getWeatherButton.setEnabled(true);
                        Unirest.shutDown();
                    });
        });
    }
}
