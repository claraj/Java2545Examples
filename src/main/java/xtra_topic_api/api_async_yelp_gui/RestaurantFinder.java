package xtra_topic_api.api_async_yelp_gui;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

/**
 * Created by clara on 2019-09-20.
 *
 *
 * Search the Yelp database for restaurants in the $ price range ($ is the lowest out of $, $$, $$$, and $$$$)
 */

public class RestaurantFinder {
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
        
        RestaurantFinderGUI gui = new RestaurantFinderGUI();
    }
}
