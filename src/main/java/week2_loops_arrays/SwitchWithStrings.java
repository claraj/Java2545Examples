package week2_loops_arrays;

import java.util.Scanner;

public class SwitchWithStrings {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Please tell me the name of a programming language?");
        String language = stringScanner.nextLine();

        switch (language.toLowerCase()) {

            case "java" :
                System.out.println("Oracle maintains Java");
                break;
            case "c#" :
                System.out.println("Microsoft maintains C#");
                break;
            case "python" :
                System.out.println("The Python Foundation maintains Python");
                break;
            default:
                System.out.println("I don't know about that language");
        }

        stringScanner.close();

    }
}
