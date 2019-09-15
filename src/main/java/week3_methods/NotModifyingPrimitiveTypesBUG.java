package week3_methods;

import static input.InputUtils.positiveIntInput;

/**
 * Created by clara on 2019-08-26.
 */
public class NotModifyingPrimitiveTypesBUG {
    
    /* Compare this program to ModifyingArrayInMethod
    Unlike that program, this one does not work. The variable
    s is a primitive type, it is passed by value
    A COPY of the number in starsOutOfTen is sent to getStarsOutOfTen method
    
    Now there are two, separate variables. If one changes, the other one is not changed.
    
    So even if starsOutOfTen changes stars, the main method's starsOutOfTen is not changed
    
    So this program doesn't work - it always prints 8/10
    */
    
    public static void main(String[] args) {
        int starsOutOfTen = 8;  // I rated a movie 8/10
        getStarsOutOfTen(starsOutOfTen); // Let's see what the user rates it
        System.out.printf("You rated the movie %d/10. \n", starsOutOfTen);  // BUG! Always prints 8/10
    }
    
    public static void getStarsOutOfTen(int stars) {
        System.out.printf("The movie has been rated %d/10. What do you think?\n", stars);
        stars = positiveIntInput("Please rate the movie. How many stars out of ten?");
    }
    
}


