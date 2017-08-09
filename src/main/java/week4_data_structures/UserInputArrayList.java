package week4_data_structures;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ask user for data, store in ArrayList<String></String>
 */
public class UserInputArrayList {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> userData = new ArrayList<String>();

        while (true) {

            System.out.println("Please type in data, or press Enter to quit");

            String data = stringScanner.nextLine();

            if (data.length() == 0) {   // If the user just presses Enter, the length of text is 0.
                break;
            }

            userData.add(data);
        }

        System.out.println("Thank you, here is all of the data you entered:");

        for (String input : userData) {
            System.out.println(input);
        }

    stringScanner.close();

    }
}
