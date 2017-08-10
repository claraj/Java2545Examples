package week2_loops_arrays;

import static input.InputUtils.stringInput;

public class ForLoopPassword5Attempts {

    public static void main(String[] args) {

        String secretPassword = "kittens";
        int passwordAttempts = 5;
        boolean accessAllowed = false;

        for (int attempt = 0 ; attempt < passwordAttempts ; attempt++) {

            String password = stringInput("Please enter the password");

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

    }

}
