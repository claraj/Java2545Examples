package week1_variables_if_else;

import static input.InputUtils.doubleInput;

public class WhyUseCurlyBraces {

    public static void main(String[] args) {

        // Java if statements still work when there is only
        // have one line of conditional code, and you omit the curly braces {}

        double temperature = doubleInput("Enter the temperature in Fahrenheit ");

        if (temperature > 32)
            System.out.println("It is above freezing");
        else
            System.out.println("It is below freezing");

        // It also works if you don't indent the conditional code, regardless of curly braces
        // but, that's harder to read
        if (temperature > 32)
            System.out.println("It is above freezing");
        else
            System.out.println("It is below freezing");

        // or put the conditional code on the same line,
        if (temperature > 32) System.out.println("It is above freezing");
        else System.out.println("It is below freezing");

        // But, all of these variations are prone to bugs.
        // If there are no {} then only the first line after the if statement is treated as conditional code.
        // So, if we wanted to print two messages in the else block,

        if (temperature > 32)
            System.out.println("It is above freezing");
        else
            System.out.println("It is below freezing");
        System.out.println("Watch out for ice on the roads");    // this is NOT conditional code

        // This statement always runs - we always see a message about ice even if the temperature is above 32
        //     System.out.println("Watch out for ice on the roads");    // this is NOT conditional code

        // So what can happen, is a programmer might write code and at first, only need one line of
        // conditional code.
        // Then, as the program is developed, or more features are added, an if statement may
        // need more lines of conditional code.
        // if those lines are added and the if-statement does not use curly braces, the program
        // will not work as intended.

        // Adding a line between if and else doesn't work - why?
//        if (temperature > 32)
//            System.out.println("It is above freezing");
//            System.out.println("There should not be any ice");
//        else  // this line has an error - why?
//            System.out.println("It is below freezing");
//            System.out.println("Watch out for ice on the roads");    // this is NOT conditional code

        // Maybe you are thinking,
        // "I'll never make that mistake! I'll remember to add curly braces if I need to add another line"
        // Professional developers have made this exact mistake many times, and chances are, you might too.
        // Programming is complicated, and everyone - literally everyone - makes mistakes.
        // A famous bug that left almost all Apple devices vulnerable to hacking
        // https://embeddedgurus.com/barr-code/2014/03/apples-gotofail-ssl-security-bug-was-easily-preventable/


        // So, best practice is to always add curly braces, even if you only have one line of conditional
        // code in an if or else statement.
        // Then you don't have to worry about this type of bug.

        // Here's the correct version, one line of conditional code,

        if (temperature > 32) {
            System.out.println("It is above freezing");
        } else {
            System.out.println("It is below freezing");
        }


        // More than one line of conditional code,

        if (temperature > 32) {
            System.out.println("It is above freezing");
            System.out.println("There should not be any ice");
        } else {
            System.out.println("It is below freezing");
            System.out.println("Watch out for ice on the roads");
        }

    }
}

