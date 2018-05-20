/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Database.Database;
import java.sql.*;
import model.patient;


/**
 *
 * @author GABRIEL
 */
public class patientController extends patient {

        Database db;
    Connection Con;
    PreparedStatement pst;
    
    public patientController ()
    {
        super();
        db = new Database();
        Con = db.getconnection();
    }
     public int patientCreateAccounts (patient p)
    {
        int res=0;
        String sql="";
        try {
            sql="INSERT INTO `patientregistration`(`ID`, `patientID`, `patientName`, `patientNumber`, `timeStamp`) VALUES (NULL,?,?,?, NOW())";
            pst=Con.prepareStatement(sql);
            
            pst.setString(1, p.getPatientID());
            pst.setString(2, p.getPatientName());
            pst.setString(3, p.getPatientNumber());
            //java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
           //s pst.setTimestamp(4, date);
            
            res=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
