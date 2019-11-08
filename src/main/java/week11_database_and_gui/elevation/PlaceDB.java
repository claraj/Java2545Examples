package week11_database_and_gui.elevation;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by clara on 4/16/18.
 */
public class PlaceDB {
    
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:databases/places.sqlite";     //Connection string – where's the database?
    
    private static final String TABLE_NAME = "places";
    private static final String NAME_COL = "name";
    private static final String ELEV_COL = "elev";
    
    static final String OK = "Ok";
    static final String DUPLICATE = "Duplicate place name";
    
    final int SQLITE_CONSTRAINT_PRIMARY_KEY_CODE = 19;
    
    
    PlaceDB() {
        createTable();
    }
    
    private void createTable() {
        
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = conn.createStatement()) {
            
            // Create a table in the database, if it does not exist already
            // Can use String formatting to build this type of String from constants coded in your program
            // Don't do this with variables with data from the user!! That's PreparedStatement objects are for,
            // and that's for queries, updates etc. , not creating tables.
            // You shouldn't make database schemas from user input anyway.
            
            String createTableSQL = "CREATE TABLE IF NOT EXISTS places (name TEXT PRIMARY KEY, elev DOUBLE)";
            
            statement.executeUpdate(createTableSQL);
            
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
    ArrayList<Place> fetchAllRecords() {
        
        ArrayList<Place> allRecords = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = conn.createStatement()) {
            
            String selectAllSQL = "SELECT * FROM places";
            ResultSet rsAll = statement.executeQuery(selectAllSQL);
            
            while (rsAll.next()) {
                String name = rsAll.getString(NAME_COL);
                double elevation = rsAll.getDouble(ELEV_COL);
                Place placeRecord = new Place(name, elevation);
                allRecords.add(placeRecord);
            }
            
            rsAll.close();
            
            return allRecords;    //If there's no data, this will be empty
            
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
    
    String addRecord(Place place)  {
        
        String addPlaceSQL = "INSERT INTO places VALUES ( ? , ? )" ;
        
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement addPlacePs = conn.prepareStatement(addPlaceSQL)) {
            
            addPlacePs.setString(1, place.getName());
            addPlacePs.setDouble(2, place.getElevation());
            
            addPlacePs.execute();
            
            return OK;
            
        } catch (SQLException sqle) {
            if (sqle.getErrorCode() == SQLITE_CONSTRAINT_PRIMARY_KEY_CODE){
                return DUPLICATE;
            } else {
                throw new RuntimeException(sqle);
                // Different error - crash program so programmer can fix
            }
        }
        
    }
    
    
    void delete(Place place) {

        String deleteSQL = "DELETE FROM places WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement deletePreparedStatement = conn.prepareStatement(deleteSQL)) {

            deletePreparedStatement.setString(1, place.getName());
            deletePreparedStatement.execute();

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
}





