package xtra_topic_api.api_query_currency;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

import java.util.Map;

/**
 * Created by clara on 2019-09-18.
 */
public class ExchangeRate {
    
    public static void main(String[] args) {
    
//        "https://api.exchangeratesapi.io/latest?base=USD&symbols=EUR"
        String exchangeRateURL = "https://api.exchangeratesapi.io/latest";
    
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
        Map<String, Object> params = Map.of("base", "USD", "symbols", "EUR");
        
        RateData response = Unirest.get(exchangeRateURL)
                .queryString(params)
                .asObject(RateData.class)    // Turn the response into a RateData object
                .getBody();
    
        System.out.println(response.getRates().getEUR());
    }
}


class RateData {
    private Rates rates;
    private String base;
    private String date;
    
    public Rates getRates() {
        return rates;
    }
    
    public void setRates(Rates ratesOb) {
        this.rates = ratesOb;
    }
    
    public String getBase() {
        return base;
    }
    
    public void setBase(String base) {
        this.base = base;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "RateData{" +
                "rates=" + rates+
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

class Rates {
    private String EUR;
    
    public String getEUR() {
        return EUR;
    }
    
    public void setEUR(String EUR) {
        this.EUR = EUR;
    }
    
    @Override
    public String toString() {
        return "rates{" +
                "EUR='" + EUR + '\'' +
                '}';
    }
}