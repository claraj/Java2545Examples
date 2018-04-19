package week11_database_and_gui.bird_table;
import java.sql.*;
import java.util.Vector;

public class BirdDatabase {
    
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:databases/birds.sqlite";
    
    private static final String ID_COLUMN = "id";             //Primary key column. Each movie will have a unique ID.
    private static final String NAME_COLUMN = "name";                 // e.g. "Great Horned Owl"
    private static final String DESCRIPTION_COLUMN = "description";   // e.g. "Large brown owl"
    
    // SQL statements
    private static final String CREATE_BIRD_TABLE = "CREATE TABLE birds (id INTEGER PRIMARY KEY , name TEXT, description TEXT)";
    private static final String GET_ALL_MOVIES = "SELECT * FROM birds";
    
    
    BirdDatabase() {
        createTable();
    }
    
    private void createTable() {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate(CREATE_BIRD_TABLE);
    
            statement.executeUpdate("INSERT INTO birds (name, description) VALUES ('Flamingo', 'Pink, stands on one leg')");
            statement.executeUpdate("INSERT INTO birds (name, description) VALUES ('Duck', 'Says Quack')");
            statement.executeUpdate("INSERT INTO birds (name, description) VALUES ('Emu', 'Large Australian bird')");
    
        } catch (SQLException e) {
            
            if (e.getMessage().contains("(table birds already exists)")) {
                //ignore, table already exists.
            } else {
                throw new RuntimeException(e);
            }
        }
    }
    
    
    Vector getColumnNames() {
        
        Vector colNames = new Vector();
    
        colNames.add("ID");
        colNames.add("Name");
        colNames.add("Description");
        
        return colNames;
    }
    
    
    Vector<Vector> getAllBirds() {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
            
            ResultSet rs = statement.executeQuery(GET_ALL_MOVIES);
            
            Vector<Vector> vectors = new Vector<>();
            
            int id;
            String name, description;
            
            while (rs.next()) {
                
                id = rs.getInt(ID_COLUMN);
                name = rs.getString(NAME_COLUMN);
                description = rs.getString(DESCRIPTION_COLUMN);
                
                Vector v = new Vector();
                v.add(id); v.add(name); v.add(description);
                
                vectors.add(v);
            }
            
            return vectors;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
}