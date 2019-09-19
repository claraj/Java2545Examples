package xtra_topic_api.api_query_bored_data;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

import java.util.Map;

/**
 * Created by clara on 2019-09-18.
 */
public class BoredData {
    
    public static void main(String[] args) {

        /*
        * https://www.boredapi.com/documentation#endpoints-type
        *
        */
        
        
        String exchangeRateURL = "http://www.boredapi.com/api/activity";
        
        // Configure Unirest to use Gson to do the JSON -> Java object conversions
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
        
        // Create a map of query parameter names and value
        // Here, want to search for free, recreational activities
        
        Map<String, Object> params = Map.of("price", 0.0, "type", "recreational");
        
        Activity response = Unirest.get(exchangeRateURL)
                .queryString(params)
                .asObject(Activity.class)    // Turn the response into a RateData object
                .getBody();
        
        System.out.println(response);
    }
}


class Activity {
     String activity;
     String accessibility;
     String type;
     String participants;
     float price;
    
//    public String getActivity() {
//        return activity;
//    }
//
//    public void setActivity(String activity) {
//        this.activity = activity;
//    }
//
//    public String getAccessibility() {
//        return accessibility;
//    }
//
//    public void setAccessibility(String accessibility) {
//        this.accessibility = accessibility;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getParticipants() {
//        return participants;
//    }
//
//    public void setParticipants(String participants) {
//        this.participants = participants;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
    
    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                ", accessibility='" + accessibility + '\'' +
                ", type='" + type + '\'' +
                ", participants='" + participants + '\'' +
                ", price=" + price +
                '}';
    }
}