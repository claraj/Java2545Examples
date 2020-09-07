package week2_loops_arrays;

/**
 * Created by clara on 2019-08-22.
 */
public class OilChanges {
    
    public static void main(String[] args) {
        
        /*
        * You just bought a used car that has 150,000 miles.
        * To take good care of your car, you plan on changing the oil every 3,000 miles.
        * Use a loop to calculate and print the mileages for the next 8 oil changes.
        * The output will start
        
        153000
        156000
        159000
        ...
        *
        */
        
        int miles = 150000;
        int oilChangeInterval = 3000;
        
        for (int oilChange = 0; oilChange < 8; oilChange++) {
            miles = miles + oilChangeInterval;
            System.out.printf("Get oil changed at %d miles\n", miles);
        }
        
    }
}
