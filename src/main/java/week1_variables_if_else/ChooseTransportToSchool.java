package week1_variables_if_else;

import static input.InputUtils.doubleInput;
import static input.InputUtils.yesNoInput;

/**
 * Cycle to school, or ride the bus?
 *
 * If it's raining or snowing or the temperature is less than 35F, then ride the bus
 * Else, cycle to school.
 *
 * Otherwise,
 *
 */
public class ChooseTransportToSchool {
    
    public static void main(String[] args) {
        
        // Go to school by bus, or by bicycle?
        // If it's raining or snowing or the temperature is less than 35F, then ride the bus
        
        // Ask the user questions to check the weather
        boolean isRaining = yesNoInput("Is it raining?");
        boolean isSnowing = yesNoInput("Is it snowing?");
        double temp = doubleInput("What is the temperature");
        
        // Use OR to check all of the conditions.
        if (isRaining || isSnowing || temp < 35)  {
            System.out.println("Using OR operators, ride the bus to school.");
        } else {
            System.out.println("Using OR operators, cycle to school.");
        }
        
        // You could also write the condition using AND operators
        // If its NOT raining and it's NOT snowing and the temp is 35 or greater
        if (!isRaining && !isSnowing && temp >= 35)  {
            System.out.println("Using AND operators, cycle to school.");
        } else {
            System.out.println("Using AND operators, ride the bus to school.");
        }
        
    }
    
}
