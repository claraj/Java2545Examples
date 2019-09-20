package xtra_topic_api.api_async_yelp_gui;

import java.util.Arrays;

/**
 * Created by clara on 2019-09-20.
 */
public class YelpResponse {
    Business[] businesses;
    
    @Override
    public String toString() {
        return "YelpResponse{" +
                "businesses=" + Arrays.toString(businesses) +
                '}';
    }
}

class Business {
    double rating;
    String name;
    Location location;
    
    @Override
    public String toString() {
        return "Business{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}

class Location {
    String city;
    String address1;
    
    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", address1='" + address1 + '\'' +
                '}';
    }
}
