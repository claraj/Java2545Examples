package week1_variables_if_else;

import static input.InputUtils.doubleInput;
import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;

public class ProductTotalPrice {
    
    public static void main(String[] args) {
        
        System.out.println("What is the name of the product?");
        String productName = stringInput();

        System.out.println("What does one " + productName + " cost?");
        double price = doubleInput();

        System.out.println("How many " + productName + " to sell?");
        double quantity = intInput();

        //Math - the total price is quantity * price. Save in a double variable
        double totalPrice = quantity * price;

        //Display the total price
        System.out.println("The total price is $" + totalPrice);

        //Or we could be more verbose...
        System.out.println(quantity + " " + productName + " at $" + price + " each will cost a total of $" + totalPrice);

        
        
        
    }
}
