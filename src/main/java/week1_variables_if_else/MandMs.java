package week1_variables_if_else;

import java.util.Scanner;

import static input.InputUtils.doubleInput;
import static input.InputUtils.intInput;

public class MandMs {
    
    public static void main(String[] args) {
        
        System.out.println("Let's share some M&Ms!");
        
        double mms = doubleInput("How many M&Ms in a packet?");   //The number is probably an int, but what if there's a half M&M in the packet?

        int people = intInput("How many people want to share the M&Ms?");
        
        //Assume each person gets an equal amount of M&Ms. So divide number of M&Ms by number of people.

        double mmsEach = mms / people;

        //display result

        System.out.println("Each person will get " + mmsEach + " M&Ms each.");
        
    }
}
