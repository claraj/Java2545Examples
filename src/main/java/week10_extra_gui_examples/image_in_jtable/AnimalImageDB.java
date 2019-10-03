package week10_extra_gui_examples.image_in_jtable;

import java.sql.*;
import java.util.Vector;

/**
 * Created by clara on 6/5/19.
 */
public class AnimalImageDB {

    private static final String DB_URL = "jdbc:sqlite:databases/animals.sqlite";
    
    public static Vector<Animal> fetchAll() {
        
        try (Connection con = DriverManager.getConnection(DB_URL); Statement statement = con.createStatement()) {
            
            String fetchAll = "SELECT * FROM animals";
            ResultSet results = statement.executeQuery(fetchAll);
            
            Vector<Animal> vector = new Vector<>();
            while (results.next()) {
                Animal a = new Animal(results.getString("name"), results.getString("imagefile"));
                vector.add(a);
            }
            
            return vector;
            
        } catch (SQLException e) {
            System.err.println("Error reading DB because " + e);
            throw new RuntimeException(e);
        }
        
    }


}
