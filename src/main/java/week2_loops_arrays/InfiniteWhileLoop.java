package week2_loops_arrays;


public class InfiniteWhileLoop {

    public static void main(String[] args) {

        // This is an infinite while loop - there's no way for the condition
        // to become false, so it will run forever.
        // This is a deliberate infinite while loop, but it's very possible to accidentally
        // write an infinite while loop.

        while (true) {

            System.out.println("This is an infinite while loop!");

        }

        // If you accidentally write an infinite while loop
        // your program will run forever!
        // But no problem - press Control+C to stop it running,
        // or press the red square stop button at the left of the IntelliJ output console.
        // And then look at your code to see what happened.

        // Make sure you have a way for the condition to become false.
        // The condition usually has a variable in it, so somewhere in the loop body,
        // there should be a variable or variables that can change to make the condtion
        // false, and to stop the loop.

        // You can also use a break statement - see other examples.

    }

}
