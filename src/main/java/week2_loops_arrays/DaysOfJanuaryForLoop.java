package week2_loops_arrays;


public class DaysOfJanuaryForLoop {

    public static void main(String[] args) {

        // A for loop that counts from 1 to 31

        System.out.println("Here are all the days in January");

        //Prints "The 1 of January"
        //       "The 2 of January"
        // etc.

        for (int day = 1 ; day <= 31 ; day++) {
            System.out.println("The " + day + " of January ");
        }

    }

}
