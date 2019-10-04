package week9_intro_to_jdbc_sqlite.movie_database_constraints;

import kong.unirest.JsonPatchItem;

import java.util.List;

import static input.InputUtils.*;

/**
 * Created by clara on 10/2/19.
 */
public class MovieList {
    
    static final String db = "jdbc:sqlite:databases/movie_watchlist_with_constraints.sqlite";
    
    private static Database database;
    
    public static void main(String[] args) {
        
        database = new Database(db);
        
        addNewMovies();
        
        displayAllMovies();
        
        checkIfWatchedAndRate();
        
        deleteWatchedMovies();
        
    }
    
    
    private static int getValidStars() {
        while (true) {
            int stars = positiveIntInput("Enter number of stars, 0 to 5");
            if (stars >= 0 && stars <= 5) {
                return stars;
            }
        }
    }
    
    private static String getValidName() {
        while (true) {
            String name = stringInput("Enter movie name");
            if (name != null && !name.isEmpty() && !name.isBlank()) {
                // isEmpty checks for length == 0. isBlank checks if a string is only whitespace.
                return name;
            }
        }
    }
    
    private static void addNewMovies() {
    
        System.out.println("\n ** GATHERING NEW MOVIE INFO ** \n");
        
        do {
            String movieName = getValidName();
            Movie movie = new Movie(movieName);
            try {
                database.addNewMovie(movie);
            } catch (Database.MovieException me) {
                System.out.println("Error adding movie because " + me.getMessage());
            }
            
        } while (yesNoInput("Add another movie to the wish list database?"));
    }
    
    
    private static void checkIfWatchedAndRate() {
        
        // Get all unvisited movies
        
        // loop over, and ask user if they have watched that movie or not
        // if so, ask for rating
        
        // Update database
    
        System.out.println("\n ** CHECKING IF WATCHLIST MOVIES ARE WATCHED ** \n");
        
        List<Movie> unwatchedMovies = database.getAllMoviesByWatched(false);
        
        for (Movie movie: unwatchedMovies) {
            boolean hasWatched = yesNoInput("Have you watched " + movie.name + "?");
            if (hasWatched) {
                System.out.println("What is your rating for " + movie.name + " out of 5 stars?");
                int stars = getValidStars();
                movie.watched = true;
                movie.stars = stars;
                try {
                    database.updateMovie(movie);
                } catch (Database.MovieException me) {
                    System.out.println("Error updating movie " + movie + " because " + me.getMessage());
                }
            }
        }
    }
    
    
    private static void displayAllMovies() {
        
        // Show all the movies in the database in name order
    
        System.out.println("\n ** DISPLAYING ALL MOVIES ** \n");
    
        List<Movie> allMovies = database.getAllMovies();
        for (Movie movie: allMovies) {
            System.out.println(movie);
        }
    }
    
    
    private static void deleteWatchedMovies() {
        
        // get all the watched movies
        // loop over, and ask user if movie should be deleted
    
        System.out.println("\n ** CHECKING IF WATCHED MOVIES SHOULD BE DELETED **\n");
        
        List<Movie> watchedMovies = database.getAllMoviesByWatched(true);
        
        for (Movie movie: watchedMovies) {
            boolean delete = yesNoInput("Delete " + movie.name + "?");
            if (delete) {
                try {
                    database.deleteMovie(movie);
                } catch (Database.MovieException me) {
                    System.out.println("Error deleting movie " + movie + " because " + me.getMessage());
                }
            }
        }
    }
    
}
