package week1_variables_if_else;

import static input.InputUtils.doubleInput;
import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;

public class NumberAndStringInput {
    
    public static void main(String[] args) {
        
        String month = stringInput("What is the current month?");

        int day = intInput("What is today's date (as a number)?");

        double high = doubleInput("What is today's forecast high temp?");

        double low = doubleInput("What is today's forecast low temp?");

        double diff = high - low;

        System.out.println("On " + month + " " + day + " the difference between the forecast high and low temperatures is " + diff + " F");
        
    }
}

