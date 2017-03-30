package week3_methods;

/**
 * Created by clara on 1/25/17.
 */
public class FormattingMonths {

    public static void main(String[] args) {

        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

        //Some example data - your program will create this from user input.
        double[] bills = { 199.06, 201.24, 150.76, 100.45, 70.23, 40.12, 43.12, 42.21, 60.89, 100.34, 167.64, 200.12};

        System.out.println("A table with columns aligned to the left\n");

        // Can specify the minimum number of characters to be displayed. In this case,
        // format the String using a minimum of 15 characters
        // The - sign means left-align.
        System.out.println(String.format("%-15s %-15s", "Month", "Bill"));

        System.out.println("_________________________");

        for (int month = 0 ; month < months.length ; month++) {
            // Format String in minimum of 15 characters and align left. Note use of - sign.
            // format double in a minimum of 15 characters with 2 decimal places, alight left. Note use of -
            System.out.println(String.format("%-15s %-15.2f", months[month], bills[month]));
        }


        System.out.println("\nThe same table with columns aligned to the right\n");


        // Can specify the minimum number of characters to be displayed. In this case,
        // format the String using a minimum of 15 characters
        // No - sign means right-align.
        System.out.println(String.format("%15s %15s", "Month", "Bill"));

        System.out.println("_________________________________");

        for (int month = 0 ; month < months.length ; month++) {

            // Format String in minimum of 15 characters and align right.
            // format double in a minimum of 15 characters with 2 decimal places, alight right.
            System.out.println(String.format("%15s %15.2f", months[month], bills[month]));
        }




    }
}
