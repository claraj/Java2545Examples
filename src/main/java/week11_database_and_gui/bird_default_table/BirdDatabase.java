package week11_database_and_gui.bird_default_table;
import java.sql.*;
import java.util.Vector;

public class BirdDatabase {
    
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:birds:sqlite";
    
    BirdDatabase() {
        
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS birds " +
                    "(id INTEGER PRIMARY KEY , name TEXT, description TEXT)");
    
            statement.executeUpdate("INSERT INTO birds (name, description) VALUES ('Flamingo', 'Pink, stands on one leg')");
            statement.executeUpdate("INSERT INTO birds (name, description) VALUES ('Duck', 'Says Quack')");
            statement.executeUpdate("INSERT INTO birds (name, description) VALUES ('Emu', 'Large Australian bird')");
    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    Vector getColumnNames() {

        Vector<String> colNames = new Vector<>();

        colNames.add("ID");
        colNames.add("Name");
        colNames.add("Description");

        return colNames;
    }


    Vector<Vector> getAllBirds() {
    
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = connection.createStatement()) {
        
            ResultSet rs = statement.executeQuery("SELECT * FROM birds");
        
            Vector<Vector> vectors = new Vector<>();
        
            while (rs.next()) {
            
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
            
                Vector v = new Vector();
                v.add(id);
                v.add(name);
                v.add(description);
            
                vectors.add(v);
            }
        
            return vectors;
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
//    }
//
//}