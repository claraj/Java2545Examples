package xtra_topic_api.api_async_kanye;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

import java.util.concurrent.CompletableFuture;

/**
 * Created by clara on 2019-09-19.
 */
public class KanyeQuotes {
    
    public static void main(String[] args) {
        
        /*
        * Kanye West quote API.
        *
        * Warning, some quotes may have language that may offend.
        *
        * */
        
        String kanyeURL = "https://api.kanye.rest/";
    
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
        
        CompletableFuture future = Unirest
                .get(kanyeURL)
                .asObjectAsync(Quote.class, response -> {
                
            Quote quote = response.getBody();
            System.out.println("Kanye says: " + quote.getQuote());
            Unirest.shutDown();
        });
        
        System.out.println("Request made, waiting for quote...");
        
    }
}

class Quote {
    String quote;
    
    public String getQuote() {
        return quote;
    }
    
    public void setQuote(String quote) {
        this.quote = quote;
    }
    
    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                '}';
    }
}
