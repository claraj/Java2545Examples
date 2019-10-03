package week9_intro_to_jdbc_sqlite.vet;

import java.sql.*;

import static input.InputUtils.*;


public class Vet {
    
    /* TODO before running this program, create a SQLite database called vet.sqlite
       TODO create the dogs table with this SQL:
       
       create table dogs (name text, age integer, weight real, vax boolean);
       
     */
    
    private static final String url = "jdbc:sqlite:databases/vet.sqlite";     // Where's the database?
    
    public static void main(String[] args) {
    
        int choice;
        
        do {
            
            choice = intInput("\nPlease enter \n1 to add a dog, \n2 to search for a dog, \n3 to update vaccinated, \n4 to delete a dog, \n5 to quit:");
            
            if (choice == 1) {
                addDog();
            } else if (choice == 2) {
                searchDog();
            } else if (choice == 3) {
                updateVax();
            } else if (choice == 4) {
                deleteDog();
            } else if (choice == 5) {
                System.out.println("Good bye!");
            } else {
                System.out.println("Please enter 1, 2, 3, 4 or 5");
            }
        } while (choice != 5);
    
    }
    
    
    
    private static void searchDog() {
        
        final String searchSql = "select * from dogs where upper(name) like upper(?)";
        
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement searchStatement = connection.prepareStatement(searchSql)) {
    
            String searchName = stringInput("Enter name to search for");
            
            searchStatement.setString(1, "%" + searchName + "%");
            ResultSet dogsRs = searchStatement.executeQuery();
            
            if (!dogsRs.isBeforeFirst()) {   // This returns false if there are no results
                System.out.println("Sorry, no dogs found.");
            } else {
                while (dogsRs.next()) {
                    String name = dogsRs.getString("name");
                    int age = dogsRs.getInt("age");
                    double weight = dogsRs.getDouble("weight");
                    boolean vax = dogsRs.getBoolean("vax");
                    System.out.printf("Name %s, age %d, weight %.2f, vaccinated %s\n", name, age, weight, vax);
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Error searching for dog.");
            System.out.println(e);
        }
    }
    
    
    private static void addDog() {
        
        final String addSql = "insert into dogs values (?, ?, ?, ?)";
    
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement ps = connection.prepareStatement(addSql)) {
        
            String name = stringInput("Enter dog name: ");
            int age = intInput("Enter dog's age: ");
            double weight = doubleInput("Enter dog's weight");
            boolean vax = yesNoInput("Is dog vaccinated? ");
            
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, weight);
            ps.setBoolean(4, vax);
    
            ps.executeUpdate();
            
        } catch (SQLException e) {
        
            System.out.println("Error adding new dog.");
            System.out.println(e);
            
        }
    }
    
    
    private static void updateVax() {
        
        final String updateVaxSql = "update dogs set vax = ? where name like ? ";
    
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement ps = connection.prepareStatement(updateVaxSql)) {
        
            String name = stringInput("Enter dog's name: ");
            boolean vax = yesNoInput("Is this dog vaccinated? ");
    
            ps.setBoolean(1, vax);
            ps.setString(2, name);
            
            int rowsUpdated = ps.executeUpdate();
            
            if (rowsUpdated == 0) {
                System.out.println("Sorry, that dog was not found");
            } else {
                System.out.println("Database updated.");
            }
        
        } catch (SQLException e) {
            System.out.println("Error updating dog.");
            System.out.println(e);
        }
    }
    
    
    private static void deleteDog() {
        
        final String deleteSql = "delete from dogs where name like ? ";
    
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement ps = connection.prepareStatement(deleteSql)) {
        
            String name = stringInput("Enter dog's name: ");
        
            ps.setString(1, name);
        
            int rowsUpdated = ps.executeUpdate();
        
            if (rowsUpdated == 0) {
                System.out.println("Sorry, that dog was not found");
            } else {
                System.out.println("Dog deleted.");
            }
        
        } catch (SQLException e) {
            System.out.println("Error deleting dog.");
            System.out.println(e);
        }
    }
    
}
