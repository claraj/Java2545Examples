package week4_data_structures;

import java.util.HashMap;

/**
 * Hello HashMap with Generic types
 */
public class HashMapSnowGenericUpdateHashMap {

    public static void main(String[] args) {

        //Use generic types in HashMaps too
        //You need to specify the type of the Keys, and the type of the Values
        //Specify in pointy brackets: < TypeOfKey, TypeOfValues>
        //In this example, all the keys must be Strings and all the values must be Integers
        HashMap<String, Integer> snowfall = new HashMap<String, Integer>();

        snowfall.put("January", 3);
        snowfall.put("February", 10);

        int janSnowfall = snowfall.get("January");   // Can use the specific type

        System.out.println("In January, " + janSnowfall + " inches of snow fell");

        snowfall.put("January", 12);   // Overwrites the previous value of 3

        janSnowfall = snowfall.get("January");

        System.out.println("After updates, in January, " + janSnowfall + " inches of snow fell");



        for (String month : snowfall.keySet()) {
            System.out.println("Month: " + month);    // month is a key
            System.out.println("Snowfall inches: " + snowfall.get(month));  // get(month) is the value for that key
        }

    }

}
