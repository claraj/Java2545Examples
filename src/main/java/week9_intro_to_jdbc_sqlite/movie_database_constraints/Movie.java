package week9_intro_to_jdbc_sqlite.movie_database_constraints;

/**
 * Created by clara on 10/4/19.
 */
public class Movie {
    
    String name;
    int stars;
    boolean watched;
    
    Movie(String name) {
        this.name = name;
    }
    
    Movie(String name, int stars, boolean watched) {
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }
    
    @Override
    public String toString() {
        if (watched) {
            return name + ". You have watched this movie and rated it " + stars + " stars.";
        }
        else {
            return name + ". You have not watched this movie.";
        }
    }
}
