/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author GABRIEL
 */
public class Database {
    
    private Connection con;
    private String url;
    private String username;
    private String password;
 
    public Database()
    {
        //connecting to the database
        url="jdbc:mysql://localhost:3306/package?";
        username = "admin";
        password ="admin";
    }
    
    public Connection getconnection (){
        //loading the driver and getting a connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con =DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
           // System.out.println(e.getMessage());
            String pane = e.getMessage();
            JOptionPane.showMessageDialog(null, pane);
        }
        return con;
    }
    
    
}
