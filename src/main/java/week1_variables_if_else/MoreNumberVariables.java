package week1_variables_if_else;


public class MoreNumberVariables {

    public static void main(String args[]) {

        //create some variables

        int zebras = 4;
        System.out.println("There are " + zebras + " zebras.");

        int cats = 6;
        System.out.println("There are " + cats + " cats.");

        //Some math with these ints

        int animals = cats + zebras;
        System.out.println("There are " + animals + " animals altogether.");

        //Print an empty line
        System.out.println();

        //Create some double variables, and some more int variables

        double widgetPrice = 4.57;
        int widgetsNeeded = 56;
        double shippingPrice = 22.33;

        double allWidgetCost = widgetPrice * widgetsNeeded;
        System.out.println("Total widget cost is $" + allWidgetCost);

        double widgetsPlusShipping = allWidgetCost + shippingPrice;
        System.out.printf("Total with shipping is $" + widgetsPlusShipping);


    }
}
