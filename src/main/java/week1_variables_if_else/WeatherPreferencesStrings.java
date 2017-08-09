package week1_variables_if_else;

import static input.InputUtils.stringInput;
import static input.InputUtils.yesNoInput;

public class WeatherPreferencesStrings {

    public static void main(String args[]) {

        // Finding out if someone likes any of Minnesota's weather.
        
        String likesSnow = stringInput("Do you like snow? Answer Y for yes");

        String likesStorms = stringInput("Do you like thunderstorms? Answer Y for yes");

        //Use an OR condition - testing if person likes at least one of the things!

        if (likesSnow.equalsIgnoreCase("y") || likesStorms.equalsIgnoreCase("y") ) {
            System.out.println("You like at least some of Minnesota's weather");
        }
        
    }
}
