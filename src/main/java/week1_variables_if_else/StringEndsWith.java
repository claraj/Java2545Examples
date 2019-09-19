package week1_variables_if_else;

/**
 * Created by clara on 2019-09-19.
 * Using the endsWith method on Strings
 */
public class StringEndsWith {
    
    public static void main(String[] args) {
        
        String minneapolisCollegeWebsite = "https://minneapolis.edu";
        String facebookWebsite = "https://facebook.com";
        
        if (minneapolisCollegeWebsite.endsWith(".edu")) {
            System.out.println(minneapolisCollegeWebsite + " is an educational website") ;
        } else {
            System.out.printf(minneapolisCollegeWebsite + " is not an educational website");
        }
        
        if (facebookWebsite.endsWith(".edu")) {
            System.out.println(facebookWebsite + " is an educational website");
        } else {
            System.out.println(facebookWebsite + " is not an educational website");
        }
        
        
    }
}
