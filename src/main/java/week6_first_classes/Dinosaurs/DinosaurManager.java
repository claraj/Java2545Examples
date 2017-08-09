package week6_first_classes.Dinosaurs;


import java.util.HashMap;

/** Example of creating and working with Dinosaur objects
 * As an exercise, how would you write this code without the Dinosaur object?
 * You can do it, but will need many individual variables */

public class DinosaurManager {

    public static void main(String[] args) {

        //Create a Dinosaur object called trex.
        //The type of this object is 'Dinosaur', the same as the class name
        //Same pattern for creating objects as for ArrayList, Hashmap, others
        //TypeOfObject nameOfObject = new TypeOfObject();

        Dinosaur trex = new Dinosaur();
        //Set some of the variables for this object
        trex.name = "Tyrannosaurus Rex";
        trex.oldestFossils = 67;
        trex.mostRecentFossils = 65;
        //Read data from the name variable
        System.out.println("This dinosaur's name is " + trex.name);
        //Call the lifespan method for this dinosaur
        System.out.println("It lived for " + trex.lifespan() +  " million years");
        System.out.println("And it says....");
        //Call the roar method for this Dinosaur
        trex.roar();

        Dinosaur velociraptor = new Dinosaur();
        //Set some of the variables for this velociraptor object. This object is independent of the trex object
        velociraptor.name = "Velociraptor";
        velociraptor.oldestFossils = 75;
        velociraptor.mostRecentFossils = 71;
        //And get data from this Dinosaur
        System.out.println("This dinosaur's name is " + velociraptor.name);
        //And call methods
        System.out.println("It lived for " + velociraptor.lifespan() +  " million years");
        System.out.println("And it says....");
        velociraptor.roar();

        //And another dinosaur, this one is called 'diplo'
        Dinosaur diplo = new Dinosaur();
        //Set data for this object. Again, it's independent of the other Dinosaur objects
        diplo.name = "Diplodocus";
        diplo.oldestFossils = 165;
        diplo.mostRecentFossils = 160;

        // Can put our Dinosaurs in an ArrayList, HashMap, other data structure
        // 'Dinosaur' is the type for the generic parameter

        HashMap<String, Dinosaur> jurassicPark = new HashMap<>();
        jurassicPark.put("Tyrannosaurus Rex", trex);
        jurassicPark.put("Velociraptor", velociraptor);
        jurassicPark.put("Diplodocus", diplo);

        // And work with the Dinosaur objects in the HashMap
        // For example, which dinosaur was around the longest?

        int longestLifespan = 0;
        Dinosaur dinoWithLongestLifespan = null;

        for (String dinoName : jurassicPark.keySet()) {

            // get() returns a Dinosaur
            Dinosaur thisDinosaur = jurassicPark.get(dinoName);
            int thisDinoLifespan = thisDinosaur.lifespan();
            //You can also write the statement above like this - can chain the methods together
            //int thisDinoLifespan = jurassicPark.get(dinoName).lifespan();

            //Which is the longest?
            if (thisDinoLifespan > longestLifespan) {
                longestLifespan = thisDinoLifespan;
                dinoWithLongestLifespan = thisDinosaur;
            }
        }

        if (dinoWithLongestLifespan != null) {
            //Prints Diplodocus, for this data set
            System.out.println("The dinosaur that lived the longest is " + dinoWithLongestLifespan.name);



        } else {
            System.out.println("No data on dinosaurs");
        }

    }

}
