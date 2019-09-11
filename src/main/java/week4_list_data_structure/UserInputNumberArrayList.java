package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;

/**
 * Ask user for data, store in ArrayList<String>
 */

public class UserInputNumberArrayList {
    
    public static void main(String[] args) {

        List<Integer> attendanceInClass = new ArrayList<>();

        while (true) {
            int attendance = intInput("Please type the number of students who attended, or type 0 to quit");
            if (attendance == 0) {
                break;
            }
            attendanceInClass.add(attendance);
        }

        System.out.println("Thank you, here are all of the attendance records you entered:");

        for (int attendance : attendanceInClass) {
            System.out.println(attendance);
        }
    }
}


