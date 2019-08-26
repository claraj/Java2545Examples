package week3_methods;

import java.util.Arrays;

import static input.InputUtils.stringInput;

/**
 * Created by clara on 2019-08-23.
 */
public class ModifyingArrayInMethod {
    
    /* Compare this to NotModifyingPrimitiveTypes and NotModifyingPrimitiveTypesBUG.
    *
    * Unlike these programs, an array is NOT copied when it is sent to a method.
    *
    * Instead, the location of the array in memory is copied, and that's sent to the method.
    * A location in memory is called a reference. Both main and getThreeFavoriteMovies have
    * a reference to the same array.
    *
    * So when the method works with the array, it looks at the memory address, and works with
    * the array it finds there.
    *
    * There is only one array. Both main and getThreeFavoriteMovies have a reference to this array.
    * So when getThreeFavoriteMovies modifies the array, then main can see these changes.
    *
    * */
    
    public static void main(String[] args) {
        String[] topThreeMovies = new String[3]; // Create an empty array
        getThreeFavoriteMovies(topThreeMovies);  // pass the empty array to getThreeFavoriteMovies method
        // main never modifies the topThreeMovies array.
        // But, because getThreeFavoriteMovies modifies the array, this prints the names the user entered
        System.out.println("Your top three favorite movies are " + Arrays.toString(topThreeMovies)); //
    }
    
    private static void getThreeFavoriteMovies(String[] movies) {
        /* Notice that this method doesn't return anything. The array movies is the same
        array as topThreeMovies in main. So when this method modifies movies, then because
        topThreeMovies the same array, the main method can access the movie data in it.
        
        In this program, the array movies is effectively the same array as topThreeMovies in the main method. */
    
        for (int x = 0 ; x < 3; x++) {
            String favoriteMovie = stringInput("Please enter one of your favorite movies");
            movies[x] = favoriteMovie;
        }
    }
}

