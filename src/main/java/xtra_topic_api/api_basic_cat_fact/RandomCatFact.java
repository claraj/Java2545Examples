package xtra_topic_api.api_basic_cat_fact;

import kong.unirest.Unirest;

public class RandomCatFact {

    /*
    *  Use the Unirest Library to get a random cat fact
    *
    *  https://catfact.ninja/
    *
    *  Display the entire response as a String
    *
    * */
    
    
    public static void main(String[] args) {
        
        String catFactURL = "https://catfact.ninja/fact";
        String response = Unirest.get(catFactURL).asString().getBody();
        System.out.println(response);
        
    }
    
}

