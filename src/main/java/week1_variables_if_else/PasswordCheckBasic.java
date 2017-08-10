package week1_variables_if_else;

import java.util.Scanner;

import static input.InputUtils.stringInput;

public class PasswordCheckBasic {
    
    public static void main(String[] args) {
        
        String userPassword = stringInput("Enter the password");
        
        //Always use the .equals method to check if two Strings have the exact same characters
        
        if ( userPassword.equals("qwerty") ) {
            System.out.println("Welcome, authorized user");
        }
        
    }

}