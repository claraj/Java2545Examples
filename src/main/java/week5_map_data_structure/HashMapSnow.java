package week5_map_data_structure;


import java.util.HashMap;
import java.util.Map;

import static input.InputUtils.*;

/**
 * Hello HashMap with Generic types
 */
public class HashMapSnow {

    public static void main(String[] args) {

        //Use generic types in HashMaps too
        //You need to specify the type of the Keys, and the type of the Values
        //Specify in pointy brackets: < TypeOfKey, TypeOfValues>
        //In this example, all the keys must be Strings and all the values must be Doubles (or doubles)
        
        // Create HashMap for String keys, and Double values
        Map<String, Double> snowfall = new HashMap<>();
        
        snowfall.put("January", 3.1);   // Add key = January with value = 31.
        snowfall.put("February", 10.8);   // Add key = February with value = 10.8
    
        System.out.println(snowfall);   // {January=3.1, February=10.8}
        
        snowfall.put("January", 4.6);  // Update January snow
    
        System.out.println(snowfall);   // {January=4.6, February=10.8}   Old value was overwritten

        double janSnowfall = snowfall.get("January");   // Get value for the key "January"

        System.out.println("In January, " + janSnowfall + " inches of snow fell");
        
        String newMonth = stringInput("Enter month: ");
        double newSnow = positiveDoubleInput("Enter snow for " + newMonth);
        
        boolean overwrite = true;
        
        if (snowfall.containsKey(newMonth)) {
            double snow = snowfall.get(newMonth);
            System.out.println( newMonth + " is already in the HashMap");
            System.out.println("Snowfall for " + newMonth + " was " + snow + " inches.");
            overwrite = yesNoInput("Do you want to overwrite the old data?");
        }
        
        if (overwrite) {
            snowfall.put(newMonth, newSnow);
        } else {
            System.out.println("HashMap was not modified.");
        }
        
        
        // Calculate total snow by adding all the values
        double total = 0;
        
        // Loop over all the values in the HashMap
        for (Double snow: snowfall.values()) {
            total += snow;
        }
    
        System.out.println("Total snowfall is " + total + " inches.");
        
        

    }

}
