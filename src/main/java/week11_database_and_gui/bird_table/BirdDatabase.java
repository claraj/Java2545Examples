package week11_database_and_gui.bird_table;
import java.sql.*;
import java.util.Vector;

public class BirdDatabase {
    
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:databases/birds.sqlite";

    // SQL statements
    private static final String CREATE_BIRD_TABLE = "CREATE TABLE birds (id INTEGER PRIMARY KEY , name TEXT, description TEXT)";
    private static final String GET_ALL_BIRDS = "SELECT * FROM birds";
    
    
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
        
        Vector<String> colNames = new Vector<String>();
    
        colNames.add("ID");
        colNames.add("Name");
        colNames.add("Description");
        
        return colNames;
    }
    
    
    Vector<Vector> getAllBirds() {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
            
            ResultSet rs = statement.executeQuery(GET_ALL_BIRDS);
            
            Vector<Vector> vectors = new Vector<>();
            
            int id;
            String name, description;
            
            while (rs.next()) {
                
                id = rs.getInt("id");
                name = rs.getString("name");
                description = rs.getString("description");
                
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