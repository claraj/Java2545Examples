package xtra_topic_api.api_query_currency_gui;

/**
 * Created by clara on 2019-09-18.
 */

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
                "rates=" + rates +
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