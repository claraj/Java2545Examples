package week4_data_structures;

import week2_loops_arrays.InfiniteWhileLoop;

import java.util.HashMap;

/**
 * Hello HashMap with Generic types
 */
public class HashMapSnowGeneric {

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

        // When getting data, it will be an int so no need to cast.
        // Generic types are very helpful.

        int febSnowfall = (int) snowfall.get("February");

        // Need data as int to do math
        int total = janSnowfall + febSnowfall;
        System.out.println("Total snow = " + total);



        for (String month : snowfall.keySet()) {
            System.out.println("Month: " + month);    // month is a key
            System.out.println("Snowfall inches: " + snowfall.get(month));  // get(month) is the value for that key
        }

    }

}
