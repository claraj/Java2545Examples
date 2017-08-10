package week1_variables_if_else;

import static input.InputUtils.yesNoInput;

public class WeatherPreferences {

    public static void main(String args[]) {

        // Finding out if someone likes any of Minnesota's weather.
        
        boolean likesSnow = yesNoInput("Do you like snow? Answer Y for yes");

        boolean likesStorms = yesNoInput("Do you like thunderstorms? Answer Y for yes");

        //Use an OR condition - testing if person likes at least one of the things!

        if (likesSnow || likesStorms ) {
            System.out.println("You like at least some of Minnesota's weather");
        }
        
    }
}

