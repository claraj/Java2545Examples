package week3_methods;

/**
 * Created by clara on 1/25/17.
 */
public class FormattingMonths {

    public static void main(String[] args) {

        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

        double[] bills = { 199.06, 201.24, 150.76, 100.45, 70.23, 40.12, 43.12, 42.21, 60.89, 100.34, 167.64, 200.12};

        System.out.println(String.format("%-15s %-15s", "Month", "Bill"));
        System.out.println("_________________________");

        for (int month = 0 ; month < months.length ; month++) {

            System.out.println(String.format("%-15s %-15.2f", months[month], bills[month]));
        }
    }
}
