package week9_intro_to_jdbc_sqlite.movie_database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clara on 10/2/19.
 */

public class Database {
    
    private String databasePath;
    
    Database(String databasePath) {
        this.databasePath = databasePath;
    
        try (Connection connection = DriverManager.getConnection(databasePath);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS movies (name TEXT, stars INTEGER, watched BOOLEAN)");
        } catch (SQLException sqle) {
            System.err.println("Error creating movie DB table because " + sqle);
        }
    }
    
    public void addNewMovie(Movie movie) {
        
        try (Connection connection = DriverManager.getConnection(databasePath);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movies values (?, ?, ?)")) {
            
            preparedStatement.setString(1, movie.name);
            preparedStatement.setInt(2, movie.stars);
            preparedStatement.setBoolean(3, movie.watched);
            preparedStatement.executeUpdate();
            
        } catch (SQLException sqle) {
            System.err.println("Error adding movie because " + sqle);
        }
    }
    
    
    public List<Movie> getAllMovies() {

        try (Connection connection = DriverManager.getConnection(databasePath);
             Statement statement = connection.createStatement()  ) {

            ResultSet movieResults = statement.executeQuery("SELECT * FROM movies ORDER BY name");

            List<Movie> movies = new ArrayList<>();

            while (movieResults.next()) {
                String name = movieResults.getString("name");
                int stars = movieResults.getInt("stars");
                boolean watched = movieResults.getBoolean("watched");

                Movie movie = new Movie(name, stars, watched);
                movies.add(movie);
            }

            return movies;

        } catch (SQLException sqle) {
            System.err.println("Error querying movie DB table because " + sqle);
            return null;
        }
    }
    
    public List<Movie> getAllMoviesByWatched(boolean watchedStatus) {
        try (Connection connection = DriverManager.getConnection(databasePath);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies WHERE watched = ?")  ) {

            preparedStatement.setBoolean(1, watchedStatus);
            ResultSet movieResults = preparedStatement.executeQuery();

            List<Movie> movies = new ArrayList<>();

            while (movieResults.next()) {
                String name = movieResults.getString("name");
                int stars = movieResults.getInt("stars");
                boolean watched = movieResults.getBoolean("watched");
                Movie movie = new Movie(name, stars, watched);
                movies.add(movie);
            }

            return movies;

        } catch (SQLException sqle) {
            System.err.println("Error querying movie DB table for movies by watched status because " + sqle );
            return null;
        }
    }
    
    
    public void updateMovie(Movie movie) {

        String sql = "UPDATE movies SET stars = ?, watched = ? WHERE name = ?";
        
        try (Connection connection = DriverManager.getConnection(databasePath);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, movie.stars);
            preparedStatement.setBoolean(2, movie.watched);
            preparedStatement.setString(3, movie.name);

            preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println("Error updating movie DB table for movie " + movie + " because " + sqle);
        }

    }
    
    
    public void deleteMovie(Movie movie) {

        try (Connection connection = DriverManager.getConnection(databasePath);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM movies WHERE name = ?")) {

            preparedStatement.setString(1, movie.name);
            preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println("Error deleting movie from table for movie " + movie + " because " + sqle);
        }

    }
    
    public List<Movie> search(String searchTerm) {
        
        String sql = "SELECT * FROM movies WHERE UPPER(name) LIKE UPPER(?)";
        
        try (Connection connection = DriverManager.getConnection(databasePath);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
            preparedStatement.setString(1, "%" + searchTerm + "%");
            ResultSet movieResults = preparedStatement.executeQuery();
        
            List<Movie> movies = new ArrayList<>();
        
            while (movieResults.next()) {
                String name = movieResults.getString("name");
                int stars = movieResults.getInt("stars");
                boolean watched = movieResults.getBoolean("watched");
                Movie movie = new Movie(name, stars, watched);
                movies.add(movie);
            }
        
            return movies;
        
        } catch (SQLException sqle) {
            System.err.println("Error querying movie DB table for movies by watched status because " + sqle );
            return null;
        }
    }
}


