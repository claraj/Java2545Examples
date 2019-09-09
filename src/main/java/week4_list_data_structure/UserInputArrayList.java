package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.stringInput;

/**
 * Ask user for data, store in ArrayList<String></String>
 */

public class UserInputArrayList {
    
    public static void main(String[] args) {

        List<String> userData = new ArrayList<>();

        while (true) {
            
            String data = stringInput("Please type in data, or press Enter to quit");

            if (data.length() == 0) {   // If the user just presses Enter, the length of text is 0.
                break;
            }

            userData.add(data);
        }

        System.out.println("Thank you, here is all of the data you entered:");

        for (String input : userData) {
            System.out.println(input);
        }
    }
}


