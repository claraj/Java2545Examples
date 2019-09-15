package week1_variables_if_else;

import static input.InputUtils.yesNoInput;

/**
 * Created by clara on 2019-08-12.
 */
public class WeldingError {
    
    public static void main(String[] args) {
        
        // ** This program has a bug in it! ** //
        
        // Taking Welding classes at MCTC, you must dress safely.
        // You should wear cotton or wool clothes. And, you should wear closed-toe shoes.
        
        // Check if a student is dressed safely for welding
        
        boolean cottonClothes = yesNoInput("Are you wearing cotton clothes?");
        boolean woolClothes = yesNoInput("Are you wearing wool clothes?");
        boolean closedToeShoes = yesNoInput("Are you wearing closed-toe shoes");
        
        // Does this work if the student doesn't have closed-toe shoes?
        
        /* Thing about the situation where
           cottonClothes = true
           woolClothes = true (or false, doesn't matter in this example)
           closedToeShoes = false
           
           This is not safe, because of the shoes.
           
           However, when Java evaluates this condition, it checks from left to right.
           It also knows that in an OR condition, if the first thing is true, the whole statement must be true
           So Java can save time. If cottonClothes = true, Java doesn't bother to check the rest of the statement and
           if cottonClothes = true or woolClothes = true, the whole condition is true,
           regardless of whether closedToeShoes is true or false
            */
        
        if (cottonClothes || woolClothes && closedToeShoes) {
            System.out.println("You are dressed safely for welding.");
        } else {
            System.out.println("You must wear wool or cotton clothes, and closed-toe shoes");
        }
        
        
    }
    
}
