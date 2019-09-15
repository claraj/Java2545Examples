package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clara on 2019-09-09.
 */
public class AddToArrayList {
    
    public static void main(String[] args) {
    
        List<String> vehicles = new ArrayList<>();
        
        vehicles.add("Bus");  // Adds to end of list  [Bus]
        vehicles.add("Car");  // Adds to end of list  [Bus, Car]
        
        // Add to start of list
        vehicles.add(0, "Train");  // [Train, Bus, Car]
        vehicles.add(0, "Boat");  // [Boat, Train, Bus, Car]
        
        // Add to list at position 2. The elements starting at position 2 move up one.
        vehicles.add(2, "Airplane");  // [Boat, Train, Airplane, Bus, Car]
    
        // Add to list at position 4. Elements starting at position 4 move up one.
        vehicles.add(4, "Truck");   // [Boat, Train, Airplane, Bus, Truck, Car]
    
        // Question: what does this do?
        // vehicles.add(20, "Van");    // Does this work?
        
        System.out.println(vehicles);
        
        // Question: is ArrayList the best List for adding to the start?
        
    }
}
