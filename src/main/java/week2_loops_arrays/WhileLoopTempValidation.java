package week2_loops_arrays;

import static input.InputUtils.doubleInput;

public class WhileLoopTempValidation {

    public static void main(String[] args) {


        /* Ask for the current temperature in Minneapolis
         * In Minneapolis, the lowest temp recorded was -34F the highest was 108F
         * So make sure input is between -50F and 125F before saving data */

        double temp = doubleInput("Enter the current temperature");

        /* these three while loops all do the same thing - diffe*/

        // One way to validate
        while (temp < -50 || temp > 125) {  // repeat while input is invalid
            System.out.println("Error - enter temp greater than -50F");
            temp = doubleInput("Enter the current temperature");
        }

        // another way to validate
        while (true) {  // repeat forever
            if (temp < -50 || temp > 125) {
                System.out.println("Error - enter temp greater than -50F");
                temp = doubleInput("Enter the current temperature");
            } else {
                break;   // but if data is ok, break out of the loop
            }
        }

        // and another way to validate!
        while (true) {  // repeat forever
            if (temp >= -50 && temp <= 125) {
                break;   // if data is ok, stop loop
            } else {
                System.out.println("Error - enter temp greater than -50F");
                temp = doubleInput("Enter the current temperature");
            }
        }

        System.out.println("Thank you, the temp is " + temp);
        // todo - send this to the national weather service
    }
}
