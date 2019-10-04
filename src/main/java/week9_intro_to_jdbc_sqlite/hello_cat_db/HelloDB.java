package week9_intro_to_jdbc_sqlite.hello_cat_db;

import java.sql.*;


public class HelloDB {
    
    public static void main(String[] args) throws SQLException {
        
        String url =  "jdbc:sqlite:databases/hello_cats.sqlite";     // Where's the database?
        
        Connection connection = DriverManager.getConnection(url);   // Connect
        
        Statement statement = connection.createStatement();   // Statements are used to issue queries
    
        String createTableSql = "CREATE TABLE IF NOT EXISTS cats (name TEXT, age INTEGER)";  // SQL to create table
        statement.execute(createTableSql);    // Execute this SQL
        
        String insertDataSql = "INSERT INTO cats VALUES ('Maru', 10)";   // More SQL to insert a row of data
        statement.execute(insertDataSql);    // And execute statement to insert data
        
        insertDataSql = "INSERT INTO cats VALUES ('Hello Kitty', 45)";   // More SQL! Insert more data
        statement.execute(insertDataSql);    // Execute this to insert the data
        
        String getAllCatsSql = "SELECT * FROM cats";   // Query to fetch data
        ResultSet allCats = statement.executeQuery(getAllCatsSql);   // Use executeQuery. It returns a ResultSet
        
        while (allCats.next()) {                            // Have to loop over the ResultSet to read it. Loop reads one row at a time
            String catName = allCats.getString("name");     // Can get data from each column, by column name
            int catAge = allCats.getInt("age");
            System.out.printf("%s is %d years old\n", catName, catAge);
        }
    
        allCats.close();      // Close result set when done using it
    
        String dropTableSql = "DROP TABLE cats";    // Delete - drop - the cats table
        //  statement.execute(dropTableSql);    // Execute drop table statement - uncomment to drop (delete) table
        
        statement.close();      // Close statement
        connection.close();     // And finally close connection
        
    }
}


// If the table might exist already and that's ok, use this instead.
//String createTableSql = "CREATE TABLE IF NOT EXISTS cats (name TEXT, age INTEGER)";
