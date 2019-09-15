package week5_map_data_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static input.InputUtils.positiveIntInput;

/**
 * Created by clara on 2019-09-12.
 */
public class RoadTripMakeList {
    
    public static void main(String[] args) {
        
        Map<String, Integer> distanceFromMinneapolis = new HashMap<>();
    
        distanceFromMinneapolis.put("Duluth", 154);
        distanceFromMinneapolis.put("Brainerd", 127);
        distanceFromMinneapolis.put("Stillwater", 26);
        distanceFromMinneapolis.put("Ely", 245);
        distanceFromMinneapolis.put("Red Wing", 54);
    
        int maxDrivingDistance = positiveIntInput("Enter the maximum distance you want to drive on your road trip");
        
        List<String> citiesInRange = new ArrayList<>();
        
        for (Map.Entry<String, Integer> cityData : distanceFromMinneapolis.entrySet()) {
            String city = cityData.getKey();
            int drivingDistance = cityData.getValue();
            if (drivingDistance <= maxDrivingDistance) {
                citiesInRange.add(city);
            }
        }
        
        if (citiesInRange.isEmpty()) {
            System.out.println("Sorry, no Minnesota cities are within your driving range");
        } else {
            System.out.println("Here are the cities you can visit");
            for (String city: citiesInRange) {
                System.out.println(city);
            }
        }
    
    }
}
