package week9_intro_to_jdbc_sqlite.movie_database;

import java.util.List;

import static input.InputUtils.*;

/**
 * Created by clara on 10/2/19.
 */

public class MovieList {
    static final String db = "jdbc:sqlite:databases/movie_watchlist.sqlite";
    
    private static Database database;
    
    public static void main(String[] args) {
        database = new Database(db);
        addNewMovies();
        displayAllMovies();
        checkIfWatchedAndRate();
        deleteWatchedMovies();
        searchForMovie();
    
    }
    
    private static void addNewMovies() {
        do {
            String movieName = stringInput("Enter the movie name");
            Movie movie = new Movie(movieName);
            database.addNewMovie(movie);
        } while (yesNoInput("Add a movie to the wish list database?"));
    }
    
    private static void displayAllMovies() {
        List<Movie> allMovies = database.getAllMovies();
        for (Movie movie: allMovies) {
            System.out.println(movie);
        }
    }
    
    private static void checkIfWatchedAndRate() {
        /* Get all unwatched movies. loop over, and ask user if they have watched that movie or not
         if so, ask for rating, and update database  */

        List<Movie> unwatchedMovies = database.getAllMoviesByWatched(false);

        for (Movie movie: unwatchedMovies) {
            boolean hasWatched = yesNoInput("Have you watched " + movie.name + "?");
            if (hasWatched) {
                int stars = intInput("What is your rating for " + movie.name + " out of 5 stars?");
                movie.watched = true;
                movie.stars = stars;
                database.updateMovie(movie);
            }
        }
    }
    
    private static void deleteWatchedMovies() {

        // get all the watched movies
        // loop over, and ask user if movie should be deleted

        System.out.println("Here are the movies you have watched.");

        List<Movie> watchedMovies = database.getAllMoviesByWatched(true);

        for (Movie movie: watchedMovies) {
            boolean delete = yesNoInput("Delete " + movie.name + "?");
            if (delete) {
                database.deleteMovie(movie);
            }
        }
    }
    
    
    private static void searchForMovie() {
        String movieName = stringInput("Enter the movie name");
        List<Movie> matches = database.search(movieName);
        
        if (matches.isEmpty())  {
            System.out.println("No matches");
        } else {
            System.out.println("Here are the matching movies:");
            for (Movie movie : matches) {
                System.out.println(movie);
            }
        }
    }
    
    
}
