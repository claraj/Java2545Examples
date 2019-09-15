package week2_loops_arrays;

import java.util.Arrays;

/**
 * Created by clara on 2019-08-23.
 */
public class ArrayToUpperCase {
    
    public static void main(String[] args) {
        
        String[] companyNames = { "Ikea", "at&t", "cvs", "3m"};
        
        for (int x = 0 ; x < companyNames.length ; x++) {
            companyNames[x] = companyNames[x].toUpperCase();
        }
    
        System.out.println(Arrays.toString(companyNames));
        
    }
}
