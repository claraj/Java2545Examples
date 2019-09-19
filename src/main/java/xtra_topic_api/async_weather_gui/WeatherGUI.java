package xtra_topic_api.async_weather_gui;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

/**
 * Created by clara on 2019-09-19.
 */
public class WeatherGUI extends JFrame {
    private JButton weatherPleaseButton;
    private JPanel mainPanel;
    private JLabel currentConditions;
    
//
private static final String DARK_SKY_KEY = System.getenv("DARK_SKY_KEY");
    //
    private static final String DARK_SKY_URL = "https://api.darksky.net/forecast/{api_key}/{lat},{lng}";
    
    WeatherGUI() {
    
        this.setSize(300, 300);
        setVisible(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        weatherPleaseButton.addActionListener( ev -> {
            double lat = 45;
            double lng = -91.3;
    
            System.out.println("Get weather");
//
//            Forecast fc = Unirest.get(DARK_SKY_URL)
//                    .routeParam("api_key", DARK_SKY_KEY)
//                    .routeParam("lat", Double.toString(lat))
//                    .routeParam("lng", Double.toString(lng))
//                    .asObject(Forecast.class)
//                    .getBody();
//
//            System.out.println(fc);
            
            currentConditions.setText("Fetching...");
            weatherPleaseButton.setEnabled(false);
            
            CompletableFuture cfFc = Unirest.get(DARK_SKY_URL)
                    .routeParam("api_key", DARK_SKY_KEY)
                    .routeParam("lat", Double.toString(lat))
                    .routeParam("lng", Double.toString(lng))
                    .asObjectAsync(Forecast.class, response -> {
                            //update GUI
                        System.out.println("done" + response.getBody().minutely.summary);
                        Forecast fc = response.getBody();
                        
                        currentConditions.setText(fc.minutely.summary);
                        weatherPleaseButton.setEnabled(true);
                    });
          
        });
        
        
        
        
    
        System.out.println("weather");
    }
}
