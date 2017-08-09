package week1_variables_if_else;

import java.util.Scanner;

public class PasswordCheckBasic {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the password");
        String userPassword = stringScanner.nextLine();

        //Always use the .equals method to check if two Strings have the exact same characters

        if ( userPassword.equals("qwerty") ) {
            System.out.println("Welcome, authorized user");
        }

        stringScanner.close();
        numberScanner.close();
    }
}