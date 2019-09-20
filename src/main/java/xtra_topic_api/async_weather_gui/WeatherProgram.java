package xtra_topic_api.async_weather_gui;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

/**
 * Created by clara on 2019-09-19.
 */
public class WeatherProgram {
    
    public static void main(String[] args) {
    
        Unirest.config().setObjectMapper(new ObjectMapper() {
            private Gson gson = new Gson();
            @Override
            public <T> T readValue(String s, Class<T> aClass) {
                return gson.fromJson(s, aClass);
            }
        
            @Override
            public String writeValue(Object o) {
                return gson.toJson(o);
            }
        });
        
        
        WeatherGUI gui = new WeatherGUI();
    }
    
}
