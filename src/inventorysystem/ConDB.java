/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author J-Michael
 */
public class ConDB {
     public static Connection getConnection() throws Exception{
           String dbRoot = "jdbc:mysql://";
        String hostName = "localhost:3306/";
        String dbName = "inventorydb";
        String dbURL = dbRoot + hostName + dbName;
        
        String hostUsername = "root";
        String hostPassword = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(dbURL, hostUsername, hostPassword);
            System.out.println("Connection successful!");
            return myConn;
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Database connection established.");
                // Close the connection after use
                conn.close();
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

