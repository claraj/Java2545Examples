package week6_files_exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO better exception handling
 */
public class WriteReadArrayList {

    public static void main(String args[]) throws IOException {

        // Storing filenames in variables is useful, you often need to refer to them more than once,
        // and having the filename in a variable saves typing and makes sure it's always spelled correctly.
        String filename = "to_do_list.txt";

        // Create an example to-do list
        List<String> todo = new ArrayList<>();
        todo.add("Water plants");
        todo.add("Pay electricity bill");
        todo.add("Grocery shopping");

        //Create BufferedWriter, which wraps a FileWriter
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));

        // Write the to do list to the file, one item per line, with numbers. An example line is
        // To do item 1 is : Grading

        int listNumber = 1;

        for (String item : todo) {
            bufWriter.write("To do item " + listNumber + " is: " + item + "\n");
            listNumber++;    // increase counter. Could also do this in a regular for loop and use the loop counter
        }

        bufWriter.close();     // Close the BufferedWriter. This will also close the FileWriter it wraps

        System.out.println("Created sample to-do list and wrote to " + filename);

        //Read the file and store all of the items in a list.
        //Create BufferedReader, which wraps a FileReader
        BufferedReader bReader = new BufferedReader(new FileReader(filename));

        List<String> numberedToDoList = new ArrayList<>();

        String line = bReader.readLine();   //Read in one line...

        //And the rest of the file, while there are more lines to read. Add to numberedToDoList
        while (line != null) {    // was the last line read equal to null?
            numberedToDoList.add(line);  // Add the last line read to the ArrayList
            line = bReader.readLine();   // And read the next line
        }

        System.out.println("Here is your to do list, read from the file");
        System.out.println(numberedToDoList);
    }
}