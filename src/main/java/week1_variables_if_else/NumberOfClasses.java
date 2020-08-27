package week1_variables_if_else;

import static input.InputUtils.positiveIntInput;
import static input.InputUtils.stringInput;

/**
 * Created by clara on 1/6/19.
 */
public class NumberOfClasses {
    
    public static void main(String[] args) {
        
        String name = stringInput("Please enter your name");
        System.out.println("Hello " + name);
        
        int numberOfClasses = positiveIntInput("How many classes are you taking this semester?");
        
        String units = "classes";
        
        if (numberOfClasses == 1) {
            units = "class";
        }

        System.out.println("You are taking " + numberOfClasses + " " + units + " this semester.");
    }
}

