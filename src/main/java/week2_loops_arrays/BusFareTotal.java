package week2_loops_arrays;

import static input.InputUtils.doubleInput;

/**
 * Created by clara on 2019-08-22.
 */

public class BusFareTotal {
    
    public static void main(String[] args) {
        
        double total = 0;   // Will add each day's expenses to this variable to calculate the week's total
        
        for (int day = 0; day < 7; day++) {  // Loop 7 times, once for each day of the week
            double dayExpense = doubleInput("On day " + (day+1) + " of the week, what did you spend on bus fares?");
            total = total + dayExpense;  // add the day's expense to the total
        }
    
        System.out.println("For the week, you spent $" + total + " for bus fares.");
    }
}


