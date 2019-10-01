package week5_map_data_structure;

import java.util.HashMap;
import java.util.Map;

import static input.InputUtils.positiveIntInput;

/**
 * Created by clara on 2019-09-12.
 */
public class RoadTrip {
    
    public static void main(String[] args) {
        
        Map<String, Integer> distanceFromMinneapolis = new HashMap<>();
    
        distanceFromMinneapolis.put("Duluth", 154);
        distanceFromMinneapolis.put("Brainerd", 127);
        distanceFromMinneapolis.put("Stillwater", 26);
        distanceFromMinneapolis.put("Ely", 245);
        distanceFromMinneapolis.put("Red Wing", 54);
    
        int maxDrivingDistance = positiveIntInput("Enter the maximum distance you want to drive on your road trip");
        
        for (Map.Entry<String, Integer> cityData : distanceFromMinneapolis.entrySet()) {
            String city = cityData.getKey();
            int drivingDistance = cityData.getValue();
            if (drivingDistance <= maxDrivingDistance) {
                System.out.println(city);
            }
        }
        
        
        // Alternative version, looping over keys
        for (String city: distanceFromMinneapolis.keySet()) {
            int drivingDistance = distanceFromMinneapolis.get(city);
            if (drivingDistance <= maxDrivingDistance) {
                System.out.println(city);
            }
        }
    
    }
}
