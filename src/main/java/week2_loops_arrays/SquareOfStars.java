package week2_loops_arrays;

public class SquareOfStars {

    public static void main(String args[]) {

        // Display a square of *

        //The outer loop prints one row per loop repeat
        for (int x = 0 ; x < 5 ; x++ ) {

            //Inner for loop. For each row, print a star 5 times
            for (int y = 0 ; y < 5; y++) {
                //Notice System.out.print - not println. This doesn't add the newline
                //at the end of the output, so all the stars are on the same line
                System.out.print("*");
            }

            //And then move to the next line
            System.out.println();
        }
    }
}