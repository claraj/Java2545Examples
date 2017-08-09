package week4_data_structures;

import java.util.ArrayList;

public class AddingToArrayList {

    public static void main(String[] args) {

        ArrayList cities = new ArrayList();
        cities.add("Minneapolis");
        cities.add("St. Paul");
        cities.add("Brooklyn Park");
        cities.add("Bloomington");

        cities.add(2, "Roseville");  //Insert this at position 2, other elements shift up

        System.out.println(cities);
        // Prints [Minneapolis, St. Paul, Roseville, Brooklyn Park, Bloomington]

        cities.add(3, "Richfield");

        System.out.println(cities);

        // Now the list is [Minneapolis, St. Paul, Roseville, Richfield, Brooklyn Park, Bloomington]

        //Add to the start of the list - add in position 0, all other elements shift up
        cities.add(0, "Eagan");

        System.out.println(cities);
        // Now the list is [Eagan, Minneapolis, St. Paul, Roseville, Richfield, Brooklyn Park, Bloomington]

        // Adding to the end is easy - use add(newElement) - by default new items are added to the end of the list
        cities.add("Shakopee");
        System.out.println(cities);
        // Now the list is [Eagan, Minneapolis, St. Paul, Roseville, Richfield, Brooklyn Park, Bloomington, Shakopee]




    }
}

