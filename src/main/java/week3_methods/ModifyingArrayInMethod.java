package week3_methods;

import java.util.Arrays;

import static input.InputUtils.stringInput;

/**
 * Created by clara on 2019-08-23.
 */
public class ModifyingArrayInMethod {
    
    public static void main(String[] args) {
        
        // Create an empty array
        String[] topThreeMovies = new String[3];
        getThreeFavoriteMovies(topThreeMovies);  // pass the empty array to getThreeFavoriteMovies method
        
        // main never modifies the topThreeMovies array.
        // Because getThreeFavoriteMovies modifies the array, this prints the names the user entered
        System.out.println("Your top three favorite movies are " + Arrays.toString(topThreeMovies)); //
    }
    
    
    private static void getThreeFavoriteMovies(String[] movies) {
    
        /* Notice that this method doesn't return anything. The array movies is the same
        array as topThreeMovies in main. So when this method modifies movies, then because
        topThreeMovies the same array, the main method can access the movie data in it.   * */
    
        for (int x = 0 ; x < 3; x++) {
            String favoriteMovie = stringInput("Please enter one of your favorite movies");
            movies[x] = favoriteMovie;
        }
    }
}
