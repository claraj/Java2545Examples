package week12_database_and_gui_jtable.bird_default_table.movie_reviews;


public class Main {
    
    
    public static void main(String args[]) {
        
        MovieDatabase db = new MovieDatabase();
        MovieReviewGUI gui = new MovieReviewGUI(db);
        
    }
}
