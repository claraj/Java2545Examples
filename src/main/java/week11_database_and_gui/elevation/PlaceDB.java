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
            
            String createTableSQLTemplate = "CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY, %s DOUBLE)";
            String createTableSQL = String.format(createTableSQLTemplate, TABLE_NAME, NAME_COL, ELEV_COL);
            
            statement.executeUpdate(createTableSQL);
            System.out.println("Info: created places table");
            
            
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
    
    String addRecord(Place place)  {
        
        String addPlaceSQL = "INSERT INTO " + TABLE_NAME + " VALUES ( ? , ? ) " ;
        final int SQLITE_CONSTRAINT_PRIMARYKEY = 19;
        
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement addPlacePs = conn.prepareStatement(addPlaceSQL)) {
            
            addPlacePs.setString(1, place.getName());
            addPlacePs.setDouble(2, place.getElevation());
            
            addPlacePs.execute();
            
            return OK;
            
        } catch (SQLException sqle) {
    
            if (sqle.getErrorCode() == SQLITE_CONSTRAINT_PRIMARYKEY){
                return "Duplicate place name.";
                
            } else {
                throw new RuntimeException(sqle);
            }
        }
        
    }
    
    
    ArrayList<Place> fetchAllRecords() {
        
        ArrayList<Place> allRecords = new ArrayList<Place>();
        
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = conn.createStatement()) {
            
            String selectAllSQL = "SELECT * FROM " + TABLE_NAME;
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
    
    
    void delete(Place place) {
        
        String deleteSQL = "DELETE FROM " + TABLE_NAME+ " WHERE "+ NAME_COL+" = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement deletePreparedStatement = conn.prepareStatement(deleteSQL)) {
            
            deletePreparedStatement.setString(1, place.getName());
            deletePreparedStatement.execute();
            
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
}