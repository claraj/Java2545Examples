package week12_database_and_gui_jtable.bird_default_table.movie_reviews;
import java.sql.*;
import java.util.Vector;

public class MovieDatabase {
    
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:databases/movies.sqlite";
    
    private static final String ID_COLUMN = "id";             //Primary key column. Each movie will have a unique ID.
    private static final String TITLE_COLUMN = "title";
    private static final String YEAR_COLUMN = "year_released";
    private static final String RATING_COLUMN = "rating";
    
    final static int MOVIE_MIN_RATING = 1;
    final static int MOVIE_MAX_RATING = 5;
    
    // SQL statements
    private static final String CREATE_MOVIE_TABLE = "CREATE TABLE IF NOT EXISTS movie_reviews (id INTEGER PRIMARY KEY , title TEXT, year_released INTEGER, rating INTEGER)";
    
    private static final String GET_ALL_MOVIES = "SELECT * FROM movie_reviews";
    private static final String EDIT_MOVIE_RATING = "UPDATE movie_reviews SET rating = ? WHERE ID = ?";
    private static final String DELETE_MOVIE = "DELETE FROM movie_reviews WHERE ID = ?";
    private static final String ADD_MOVIE = "INSERT INTO movie_reviews (title, year_released, rating) VALUES (?, ?, ?) ";
    
    
    MovieDatabase() {
        createTable();
    }
    
    
    private void createTable() {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate(CREATE_MOVIE_TABLE);
            System.out.println("Created movie reviews table");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    Vector getColumnNames() {
        
        Vector colNames = new Vector();
        colNames.add("id");
        colNames.add("Title");
        colNames.add("Year Released");
        colNames.add("Rating");
        
        return colNames;
    }
    
    
    Vector<Vector> getAllMovies() {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
            
            ResultSet rs = statement.executeQuery(GET_ALL_MOVIES);
            
            Vector<Vector> vectors = new Vector<>();
            
            String name;
            int id, year, rating;
            
            while (rs.next()) {
                
                id = rs.getInt(ID_COLUMN);
                name = rs.getString(TITLE_COLUMN);
                year = rs.getInt(YEAR_COLUMN);
                rating = rs.getInt(RATING_COLUMN);
                
                Vector v = new Vector();
                v.add(id); v.add(name); v.add(year); v.add(rating);
                
                vectors.add(v);
            }
            
            return vectors;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
    public void deleteMovie(int movieID) {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE)) {
            
            preparedStatement.setInt(1, movieID);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void addMovie(String title, int year, int rating) {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_MOVIE)) {
            
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, year);
            preparedStatement.setInt(3, rating);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void changeRating(int id, int rating) {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_MOVIE_RATING)) {
            
            preparedStatement.setInt(1, rating);
            preparedStatement.setInt(2, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
}