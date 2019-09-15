package week2_loops_arrays;

/**
 * Created by clara on 2019-08-23.
 */
public class Comments {
    
    
    void badComments() {
     
        /* A section of bad comments. They are repeating what the code already tells you */
        int students = 20;  // create a variable called students
        double totalScoresForQuiz = 1853;  // create a variable called totalScoresForQuiz
        double averageScore = totalScoresForQuiz / students;  // divide
        
        System.out.println(averageScore);  // printing
        
        
        // These comments are wrong - they don't describe what the code is doing
        String[] data = { "cat", "bird", "mouse" }; // A string variable
        for ( int x = 0 ; x < data.length ; x++) {  // make a loop for each letter
            System.out.println(data[x]);  // print each letter
        }
    
    }
    
    
    void betterComments() {
        
        /* The same code, but with more useful comments */
    
        // Calculate the average score for a quiz
        
        int students = 20;  // Number of students who took the quiz
        double totalScoresForQuiz = 1853;  // Total points from all the quizzes, for all of the students
        double averageScore = totalScoresForQuiz / students;  // Calculate average = total divided by number of students
        System.out.println(averageScore);
    
        String[] data = { "cat", "bird", "mouse" }; // A string array with animal names
        // Print each element in the array using a loop
        for ( int x = 0 ; x < data.length ; x++) {  // loop for each element in the array
            data[x] = data[x].toUpperCase();  // Get element x, convert to uppercase, replace original value
            System.out.println(data[x]);  // print the element at index x in the array
        }
    }
}
