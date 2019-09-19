package xtra_topic_api.api_basic_cat_fact;

import kong.unirest.Unirest;
import org.json.JSONObject;


public class RandomCatFactJSON {

    /*
    *  Use the Unirest Library to get a random cat fact
    *  https://catfact.ninja/
    *
    * Convert the response to a JSON node
    * Extract the fact property as a String
    *
    * */
    
    
    public static void main(String[] args) {
    
        String catFactURL = "https://catfact.ninja/fact";
        JSONObject json = Unirest.get(catFactURL).asJson().getBody().getObject();
        System.out.println(json.getString("fact"));
    }
}
