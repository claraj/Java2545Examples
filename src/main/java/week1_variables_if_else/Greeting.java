package week1_variables_if_else;


import static input.InputUtils.stringInput;

public class Greeting {

   
    public static void main(String[] args) {

        // Write your code between here...


        System.out.println("What is your name?");
        String username = stringInput();

        //This causes the program to pause, and wait for the user to type something, and press Enter.
        //Whatever the user types will be saved in the variable called username, and the program continues
      
        //Display a greeting to the user

        System.out.println("Hello, " + username);

        
    }
}
