package xtra_topic_api.api_query_currency_gui;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

/**
 * Created by clara on 10/29/19.
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Configure Unirest to use GSON to do the JSON -> Java object conversions
        // Only need to do this one time.
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
        
        
        // Start GUI
        
        CurrencyGUI gui = new CurrencyGUI();
        
    }
}
