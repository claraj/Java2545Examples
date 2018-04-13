package week10_intro_to_jdbc_sqlite.hellodb;

import java.sql.*;


public class HelloDB {
    
    public static void main(String[] args) throws SQLException {
        
        String url =  "jdbc:sqlite:databases/hello.sqlite";
        
        Connection connection = DriverManager.getConnection(url);
        
        String createTableSql = "CREATE TABLE cats (name TEXT, age INTEGER)";
        
        Statement statement = connection.createStatement();
        
        statement.execute(createTableSql);
        
        String insertDataSql = "INSERT INTO cats VALUES ('Maru', 10)";
        
        statement.execute(insertDataSql);
        
        insertDataSql = "INSERT INTO cats VALUES ('Hello Kitty', 45)";
        
        statement.execute(insertDataSql);
        
        String getAllCatsSql = "SELECT * FROM cats";
        
        ResultSet allCats = statement.executeQuery(getAllCatsSql);
        
        while (allCats.next()) {
            
            String catName = allCats.getString("name");
            int catAge = allCats.getInt("age");
            System.out.printf("%s is %d years old\n", catName, catAge);
            
        }
        
        allCats.close();
        statement.close();
        connection.close();
        
    }
}
