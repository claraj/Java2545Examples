package week4_data_structures;

import java.util.HashMap;

/**
 * Hello HashMap. Create and add key-value paits
 */
public class HashMapSnow {

    public static void main(String[] args) {

        HashMap snowfall = new HashMap();

        snowfall.put("January", 3);
        snowfall.put("February", 10);

        Object janSnowfall = snowfall.get("January");

        System.out.println("In January, " + janSnowfall + " inches of snow fell");

        // If we need the January snowfall as an int or Integer, must cast
        // Or (often better) use generic types when creating the HashMap

        int intJanSnowfall = (int) snowfall.get("January");
        int intFebSnowfall = (int) snowfall.get("February");

        // Need data as int to do math
        int total = intJanSnowfall + intFebSnowfall;
        System.out.println("Total snow = " + total);

        // Print all of the data

        for (Object ob : snowfall.keySet()) {
            System.out.println("Month: " + ob);    // ob is a key
            System.out.println("Snowfall inches: " + snowfall.get(ob));  // get(ob) is the value for that key
        }

    }

}
