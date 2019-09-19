package xtra_topic_api.api_metro_transit_array;

import com.google.gson.Gson;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

/**
 * Created by clara on 2019-09-18.
 */
public class MetroTransitJSON {
    
    /*
    *  Use the Metro Transit API to get the next bus departures for the stop outside
    * Minneapolis College.
    *
    * The response is a JSON array of objects, so when deserializing, the data,
    * it is converted into an array of BusStatus objects.
    *
    * */
    
    public static void main(String[] args) {
    
        String metroTransitURL = "http://svc.metrotransit.org/NexTrip/17940?format=json";
    
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
    
        BusStatus[] busStatuses = Unirest.get(metroTransitURL).asObject(BusStatus[].class).getBody();
        for (BusStatus s: busStatuses) {
            System.out.println(s.getDepartureText());
        }
    }
}

class BusStatus {
    private String VehicleLongitude;
    private String DepartureText;
    private String DepartureTime;
    private String RouteDirection;
    private String Description;
    private String VehicleLatitude;
    private String Actual;
    private String Gate;
    private String BlockNumber;
    private String Terminal;
    private String Route;
    private String VehicleHeading;
    public String getVehicleLongitude () {
        return VehicleLongitude;
    }
    
    public void setVehicleLongitude (String VehicleLongitude) {
        this.VehicleLongitude = VehicleLongitude;
    }
    
    public String getDepartureText () {
        return DepartureText;
    }
    
    public void setDepartureText (String DepartureText) {
        this.DepartureText = DepartureText;
    }
    
    public String getDepartureTime () {
        return DepartureTime;
    }
    
    public void setDepartureTime (String DepartureTime) {
        this.DepartureTime = DepartureTime;
    }
    
    public String getRouteDirection () {
        return RouteDirection;
    }
    
    public void setRouteDirection (String RouteDirection) {
        this.RouteDirection = RouteDirection;
    }
    
    public String getDescription () {
        return Description;
    }
    
    public void setDescription (String Description) {
        this.Description = Description;
    }
    
    public String getVehicleLatitude () {
        return VehicleLatitude;
    }
    
    public void setVehicleLatitude (String VehicleLatitude) {
        this.VehicleLatitude = VehicleLatitude;
    }
    
    public String getActual () {
        return Actual;
    }
    
    public void setActual (String Actual) {
        this.Actual = Actual;
    }
    
    public String getGate () {
        return Gate;
    }
    
    public void setGate (String Gate) {
        this.Gate = Gate;
    }
    
    public String getBlockNumber () {
        return BlockNumber;
    }
    
    public void setBlockNumber (String BlockNumber) {
        this.BlockNumber = BlockNumber;
    }
    
    public String getTerminal () {
        return Terminal;
    }
    
    public void setTerminal (String Terminal) {
        this.Terminal = Terminal;
    }
    
    public String getRoute () {
        return Route;
    }
    
    public void setRoute (String Route) {
        this.Route = Route;
    }
    
    public String getVehicleHeading () {
        return VehicleHeading;
    }
    
    public void setVehicleHeading (String VehicleHeading) {
        this.VehicleHeading = VehicleHeading;
    }
    
    @Override
    public String toString()
    {
        return "BusStatus [VehicleLongitude = "+VehicleLongitude+", DepartureText = "+DepartureText+", DepartureTime = "+DepartureTime+", RouteDirection = "+RouteDirection+", Description = "+Description+", VehicleLatitude = "+VehicleLatitude+", Actual = "+Actual+", Gate = "+Gate+", BlockNumber = "+BlockNumber+", Terminal = "+Terminal+", Route = "+Route+", VehicleHeading = "+VehicleHeading+"]";
    }
}