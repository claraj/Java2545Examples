package xtra_topic_api.api_basic_cat_fact;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;


public class RandomCatFactJSONObjectMapper {

    /*
    *  Use the Unirest Library to get a random cat fact
    *  https://catfact.ninja/
    *
    * Convert the response to a CatFact object,
    * which has a fact attribute
    *
    * Use Gson to convert the JSON response to a Java object.
    * Note the CatFact class
    *
    * */
    
    
    public static void main(String[] args) {
    
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
        
        // Make request, convert response to CatFact object
        String catFactURL = "https://catfact.ninja/fact";
        CatFact catFact = Unirest.get(catFactURL).asObject(CatFact.class).getBody();
        System.out.println(catFact.getFact());
    }
}
    
class CatFact {
        private String fact;
        private int length;
        
        public CatFact(String fact, int length) {
            this.fact = fact;
            this.length = length;
        }
        
        public String getFact() {
            return fact;
        }
        
        public void setFact(String fact) {
            this.fact = fact;
        }
        
        public int getLength() {
            return length;
        }
        
        public void setLength(int length) {
            this.length = length;
        }
    }

