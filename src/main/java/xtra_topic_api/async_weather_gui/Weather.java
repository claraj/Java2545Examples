package xtra_topic_api.async_weather_gui;

/**
 * Created by clara on 2019-09-19.
 */
public class Weather {

    Minutely minutely;
    
    @Override
    public String toString() {
        return "Forecast{" +
                "minutely=" + minutely +
                '}';
    }
}

class Minutely {
    String summary;
    
    @Override
    public String toString() {
        return "Minutely{" +
                "summary='" + summary + '\'' +
                '}';
    }
}