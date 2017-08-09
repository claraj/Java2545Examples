package week2_loops_arrays;

import java.util.Scanner;

public class ForLoopPassword5Attempts {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        String secretPassword = "kittens";
        int passwordAttempts = 5;
        boolean accessAllowed = false;

        for (int attempt = 0 ; attempt < passwordAttempts ; attempt++) {

            System.out.println("Please enter the password");
            String password = stringScanner.nextLine();

            if (password.equals(secretPassword)) {
                accessAllowed = true;
                break;
            }
        }

        if (accessAllowed) {
            System.out.println("Welcome to the secret program!");
        } else {
            System.out.println("You are not authorized to access the secret program");
        }


        stringScanner.close();
        numberScanner.close();
    }

}
