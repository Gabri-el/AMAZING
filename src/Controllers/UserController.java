/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import model.user;
import java.sql.*;


/**
 *
 * @author GABRIEL
 */
public class UserController extends user {
    
    Database db;
    Connection Con;
    PreparedStatement pst;
    
    public UserController ()
    {
        super();
        db = new Database();
        Con = db.getconnection();
    }
    
    public int createAccount (user u){
        int res = 0;
        String sql ="";
        try {
            sql="INSERT INTO `user`(`ID`, `username`, `password`, `confimpass`)VALUES(NULL,?,?,?)";
            pst =Con.prepareStatement(sql);
            
            pst.setString(1, u.getUsername());
            pst.setString(2,u.getPassword());
            pst.setString(3, u.getConfirmpass());
            
            res=pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    public boolean checkLogin ( user u){
        String  sql ="";
        ResultSet rs =null;
        try {
            sql= "SELECT * FROM `user` WHERE `username` = ? and `password` = ?";
            pst = Con.prepareStatement(sql);
            
            pst.setString (1,u.getUsername());
            pst.setString (2,u.getPassword());
            
            rs =pst.executeQuery();
            
            if( rs.next())
            {
                return true;
            }else{
                return false;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return false;
    }
    
}
