package week11_database_and_gui_jlist.elevation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all interaction with the database.
 */

public class PlaceDB {

    private final String DB_CONNECTION_URL;

    private final int SQLITE_DUPLICATE_PRIMARY_KEY_CODE = 19;

    PlaceDB(String connectionURL) {

        DB_CONNECTION_URL = connectionURL;     //Connection string – where's the database?

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = conn.createStatement()) {

            // Create a table in the database if it doesn't exist yet
            String createTableSQL = "CREATE TABLE IF NOT EXISTS places " +
                    "(name TEXT PRIMARY KEY, elevation REAL, UNIQUE (name COLLATE NOCASE) )";   // prevent duplicate place names regardless of case

            statement.executeUpdate(createTableSQL);

        } catch (SQLException sqle) {
            System.err.println("Error creating database at " + connectionURL + " because " + sqle);
        }
    }


    public List<Place> fetchAllRecords() {

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = conn.createStatement()) {

            List<Place> allRecords = new ArrayList<>();

            String selectAllSQL = "SELECT * FROM places";
            ResultSet rsAll = statement.executeQuery(selectAllSQL);

            while (rsAll.next()) {
                String name = rsAll.getString("name");
                double elevation = rsAll.getDouble("elevation");
                Place placeRecord = new Place(name, elevation);
                allRecords.add(placeRecord);
            }

            return allRecords;    //If there's no data, this will be an empty list

        } catch (SQLException sqle) {
            System.err.println("Error fetching all place because " + sqle);
            return null;
        }
    }


    public boolean addRecord(Place place) {

        // Inserts a new place and returns true if successful, false otherwise
        String addPlaceSQL = "INSERT INTO places VALUES ( ? , ? )";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement addPlacePs = conn.prepareStatement(addPlaceSQL)) {

            addPlacePs.setString(1, place.getName());
            addPlacePs.setDouble(2, place.getElevation());
            addPlacePs.execute();
            return true;
            
        } catch (SQLException sqle) {
            // this is a problem that the code can handle - it's a place that's
            // already in the database, so the user can try again.
            if (sqle.getErrorCode() == SQLITE_DUPLICATE_PRIMARY_KEY_CODE) {
                System.out.println("Error adding place, already exists in database");
            } else {
                System.err.println("Error adding place " + place + " because " + sqle);
            }
            return false;
        }
    }
    
    
    public void deleteRecord(Place place) {

        String deleteSQL = "DELETE FROM places WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement deletePS = conn.prepareStatement(deleteSQL)) {

            deletePS.setString(1, place.getName());
            deletePS.execute();

        } catch (SQLException sqle) {
            System.err.println("Error deleting place " + place + " because " + sqle);
        }
    }


    public Double getElevationForPlaceName(String name) {

        String searchSQL = "SELECT elevation FROM places WHERE LOWER(name) = LOWER(?)";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement searchPS = conn.prepareStatement(searchSQL)) {

            searchPS.setString(1, name);
            ResultSet placeRS = searchPS.executeQuery();

            if (placeRS.next()) {
                // A place was found
                double elevation = placeRS.getDouble("elevation");
                return elevation;
            } else {
                // place not found
                return null;  // ensure your return type is uppercase D Double
            }

        } catch (SQLException sqle) {
            System.err.println("Error finding place " + name + " because " + sqle);
            return null;
        }
    }


    public boolean updatePlaceRecord(Place place) {

        String searchSQL = "UPDATE places SET elevation = ? WHERE LOWER(name) = LOWER(?)";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             PreparedStatement updatePS = conn.prepareStatement(searchSQL)) {

            updatePS.setDouble(1, place.getElevation());
            updatePS.setString(2, place.getName());

            int rowsUpdated = updatePS.executeUpdate();

            if (rowsUpdated == 1) {
                // place was found and DB updated
                return true;
            } else {
                // no place with that name found, no rows changed
                return false;
            }

        } catch (SQLException sqle) {
            System.err.println("Error updating place " + place + " because " + sqle);
            return false;
        }
    }

}






