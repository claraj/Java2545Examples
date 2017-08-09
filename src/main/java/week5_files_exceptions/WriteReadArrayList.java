package week5_files_exceptions;

import java.io.*;
import java.util.ArrayList;


/**
 * TODO better exception handling
 */
public class WriteReadArrayList {

    public static void main(String args[]) throws IOException {

        String filename = "to_do_list.txt";
        // Storing filenames in variables is useful, you typically need to refer to them more than once,
        // and having the filename in a variable saves typing and makes sure it's always spelled correctly.

        //Create an example to-do list
        ArrayList<String> todo = new ArrayList<String>();
        todo.add("Grading");
        todo.add("Pay water bill");
        todo.add("Grocery shopping");

        //Create BufferedWriter, which wraps a FileWriter
        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));

        //Write the to do list to the file, one item per line
        // Would like to number the to do items, an example line should be
        // To do item 1 is : Grading

        int listNumber = 1;

        for (String item : todo) {
            bufWriter.write("To do item " + listNumber + " is: " + item + "\n");
            listNumber++;    // increase counter. Could also do this in a regular for loop and use the loop counter
        }

        //Close the BufferedWriter. This will also close the FileWriter it wraps
        bufWriter.close();

        System.out.println("Created sample to-do list and wrote to " + filename);

        //Read the file and store all of the items in a list.
        //Create BufferedReader, which wraps a FileReader
        BufferedReader bReader = new BufferedReader(new FileReader(filename));

        ArrayList<String> numberedToDoList = new ArrayList<String>();

        //Read in one line...
        String line = bReader.readLine();

        //And the rest of the file, while there are more lines to read. Add to numberedToDoList
        while (line != null) {
            numberedToDoList.add(line);
            line = bReader.readLine();
        }

        System.out.println("Here is your to do list, read from the file");
        System.out.println(numberedToDoList);

    }
}