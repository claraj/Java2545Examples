package week1_variables_if_else;

import static input.InputUtils.positiveIntInput;
import static input.InputUtils.yesNoInput;

/**
 * Created by clara on 2019-08-12.
 * Checking the requirements for becoming President of the United States
 * As required by the US Constitution, a president must be
 *
 *  - A natural born citizen of the United States
 *  - 35 years old or more
 *  - Have lived in the United States for 14 years or more
 *
 * https://www.loc.gov/teachers/classroommaterials/presentationsandactivities/presentations/elections/requirements-for-president.html
 *
 */
public class CanYouBePresident {
    
    public static void main(String[] args) {
    
        System.out.println("Are you eligible to become President of the United States?");
        System.out.println("Please answer these three questions.");
        
        boolean naturalBornCitizen = yesNoInput("Were you born in the United States?");
        int age = positiveIntInput("What is your age, in years?");
        int yearsLivedInUSA = positiveIntInput("How many years have you lived in the United States?");
        
        if (naturalBornCitizen && age >= 35 && yearsLivedInUSA >= 14) {
            System.out.println("You meet the eligibility requirements to become president. Good luck!");
        } else {
            System.out.println("Sorry, you do not meet the requirements.");
        }
        
    }
    
}
