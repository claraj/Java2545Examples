package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clara on 2019-09-09.
 */
public class GetFromArrayList {
    
    public static void main(String[] args) {
    
        List<String> vehicles = new ArrayList<>();
        
        vehicles.add("Bus");
        vehicles.add("Car");
        vehicles.add("Train");
        vehicles.add("Boat");
        
        System.out.println(vehicles);
        
        // Get by index, first element. List is NOT modified
        String firstVehicle = vehicles.get(0);
        System.out.println(firstVehicle);    // "Bus"
        System.out.println(vehicles);   // [Bus, Car, Train, Boat]
        
        // Get by index - any index in the list
        String truck = vehicles.get(2);
        System.out.println(truck);  // "Train"
        
        // What will this do?
        String error = vehicles.get(4);
        
    }
}
