package week1_variables_if_else;

/**
 * Watch out for integer math rounding - potential bug here!
 */
public class IntMathError {

    public static void main(String args[]) {

        int numberOfRides = 30;
        int daysOfStateFair = 12;

        // A state fair fan is planning to go every day, and
        // wants to go on all of the rides. How many rides per day?

        double ridesPerDay = numberOfRides / daysOfStateFair;

        // ERROR here! ridesPerDay has a value of 2.0, even though the right answer is 2.5
        System.out.println("To go on all of the rides, you need to go on " + ridesPerDay + " rides every day");


    }
}
