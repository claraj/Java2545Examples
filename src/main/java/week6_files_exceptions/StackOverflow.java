package week6_files_exceptions;

public class StackOverflow {

    /* This program will crash with a stack overflow error.
     * main calls main which calls main which calls main....
     * all the method calls are stored on the stack, and if the stack
     * runs out of space the program will crash with a StackOverflowError */
    public static void main(String[] args) {
        main(null);
    }
}
