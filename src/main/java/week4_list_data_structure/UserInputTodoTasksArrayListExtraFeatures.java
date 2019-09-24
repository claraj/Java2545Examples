package week4_list_data_structure;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.stringInput;

/**
 * Ask user for data, store in ArrayList<String>
 */

public class UserInputTodoTasksArrayListExtraFeatures {
    
    public static void main(String[] args) {

        List<String> todoList = new ArrayList<>();

        while (true) {
            String data = stringInput("Please type a task you need to do, or press Enter to quit");
            if (data.length() == 0) {   // If the user just presses Enter, the length of text is 0.
                break;
            }
            
            // Create a method to check if data is already in the list
            // case doesn't matter - "Water Plants" is the same task as "water plants"
            if (containsIgnoreCase(todoList, data)) {
                System.out.println("You already entered " + data);
            }
            else {
                todoList.add(data);
            }
        }

        System.out.println("Thank you, here are all of your tasks you entered:");

        for (String input : todoList) {
            System.out.println(input);
        }
    
        System.out.println("There are " + todoList.size() + " tasks in your to do list.");
    }
    
    private static boolean containsIgnoreCase(List<String> todoList, String data) {
        for (String task: todoList) {
            if (task.equalsIgnoreCase(data)) {
                // found the item - return true
                return true;
            }
        }
        // If the loop gets to the end of the List without finding the data, it's
        // not there. Return false.
        return false;
    }
}


