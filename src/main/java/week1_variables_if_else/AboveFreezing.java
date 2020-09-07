package week1_variables_if_else;

import static input.InputUtils.doubleInput;

public class AboveFreezing {
    
    public static void main(String[] args) {

        System.out.println("Enter today's temperature in F");
        double temp = doubleInput();

        if (temp > 32) {
            //This will run if the condition is true
            System.out.println("It's above freezing");
        }

        //Indentation in if blocks is optional but strongly suggested
        //It's a standard convention and helps readability
        
    }

}
