package week1_variables_if_else;

/**
 * Watch out for integer math rounding - potential bug here!
 */
public class IntMathFix {

    public static void main(String args[]) {

        //Setting one of the variables to a double ensures that the calculation will include the floating point value of the answer.
        double numberOfRides = 30;
        int daysOfStateFair = 12;

        // A state fair fan is planning to go every day, and
        // wants to go on all of the rides. How many rides per day?

        double ridesPerDay = numberOfRides / daysOfStateFair;

        // Now this displays the correct answer.

        System.out.println("To go on all of the rides, you need to go on " + ridesPerDay + " rides every day");


    }
}
