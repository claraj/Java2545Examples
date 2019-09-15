package week1_variables_if_else;

import static input.InputUtils.yesNoInput;

/**
 * Created by clara on 2019-08-12.
 * Check if a student has completed the pre-requisites for taking the Microcomputer Maintenance class
 * The pre-requisites required are to complete all of 1100 IT Concepts, 1110 IT Skills and 1250 Windows classes.
 */
public class CanYouTakeMicrocomputerMaintenance {
    
    public static void main(String[] args) {
    
        System.out.println("This program will check if you meet the pre-requisites for taking ITEC 1310 Microcomputer Systems Maintenance.");
        System.out.println("Please answer the following three questions.");
    
        boolean hasTakenITConcepts = yesNoInput("Have you taken ITEC 1100 Info Tech Concepts?");
        boolean hasTakenITSkills = yesNoInput("Have you taken ITEC 1110 Info Tech Skills?");
        boolean hasTakenWindows = yesNoInput("Have you taken ITEC 1250 Windows Operating Systems?");
        
        // Use an AND operator in the condition to check if all of the pre-requisites are met
        if (hasTakenITConcepts && hasTakenITSkills && hasTakenWindows) {
            System.out.println("You meet the pre-requisites. You may take ITEC 1310 Microcomputer Systems Maintenance.");
        } else {
            System.out.println("You do not meet the pre-requisites yet. You need to complete all three pre-requisite classes.");
        }
        
    }
    
}
