package week9_intro_to_jdbc_sqlite.movie_database_primary_key;

/**
 * Created by clara on 10/4/19.
 */

public class Movie {
    
    int id;
    String name;
    int stars;
    boolean watched;
    
    Movie(String name) {
        this.name = name;
    }
    
    Movie(int id, String name, int stars, boolean watched) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }
    
    @Override
    public String toString() {
        if (watched) {
            return "Movie id" + id + ". " + name + ". " +
                    "You have watched this movie and rated it " + stars + " stars.";
        }
        else {
            return "Movie id" + id + ". " + name + ". You have not watched this movie.";
        }
    }
}

