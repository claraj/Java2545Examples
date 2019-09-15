package week1_variables_if_else;

import static input.InputUtils.yesNoInput;

/**
 * Created by clara on 2019-08-12.
 */
public class WeldingFixed {
    
    public static void main(String[] args) {
        
        // Taking Welding classes at MCTC, you must dress safely.
        // You should wear cotton or wool clothes. And, you should wear closed-toe shoes.
        
        // Check if a student is dressed safely for welding
        
        boolean cottonClothes = yesNoInput("Are you wearing cotton clothes?");
        boolean woolClothes = yesNoInput("Are you wearing wool clothes?");
        boolean closedToeShoes = yesNoInput("Are you wearing closed-toe shoes");
        
        // Fix - use parenthesis to evaluate all of (cottonClothes || woolClothes) before checking
        // if the user also has closed to shoes
        
        if ( (cottonClothes || woolClothes) && closedToeShoes) {
            System.out.println("You are dressed safely for welding.");
        } else {
            System.out.println("You must wear wool or cotton clothes, and closed-toe shoes");
        }
        
        
    }
    
}
