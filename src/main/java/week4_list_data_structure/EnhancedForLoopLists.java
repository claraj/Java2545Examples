package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clara on 2019-09-10.
 */
public class EnhancedForLoopLists {
    
    public static void main(String[] args) {
        
        List<String> cities = new ArrayList<>();
        cities.add("Minneapolis");
        cities.add("Saint Paul");
        cities.add("Bloomington");
        cities.add("Brooklyn Park");
        cities.add("Golden Valley");
        
        for (String city: cities) {
            System.out.println(city + ", Minnesota");
        }
        
        
    }
}
