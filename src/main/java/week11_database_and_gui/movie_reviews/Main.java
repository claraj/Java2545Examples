package week11_database_and_gui.movie_reviews;


public class Main {
    
    
    public static void main(String args[]) {
        
        MovieDatabase db = new MovieDatabase();
        MovieReviewGUI gui = new MovieReviewGUI(db);
        
    }
}
