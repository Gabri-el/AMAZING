/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import AppPackage.Disease;
import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GABRIEL
 */
public class Symptoms_and_Diseases {
   
    Connection con;
    PreparedStatement prepare;
    Database db;
    Connection Con;
    PreparedStatement pst;

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Integer Diseases()
    {
           db = new Database();
            Con = db.getconnection();
            ArrayList<String> DiseasesArrayList = new ArrayList<String>();
            Boolean isSick = false;
            int diseaseId = 0;
        try {
            pst = Con.prepareStatement("SELECT * FROM `symptoms`");
            ResultSet rs ;
            
            rs =pst.executeQuery();
            
            ArrayList<String> patientSym = new ArrayList<String>(5);
            
            patientSym.add("stomach ach");
            patientSym.add("vomitting");
            patientSym.add("drowsiness");
            patientSym.add("shivering");
            ArrayList<ArrayList<String>> row = new ArrayList<ArrayList<String>>();
//            String row[]  = new String[columnCount];
            while(rs.next())
            {
             
//                int columnCount =rs.getMetaData().getColumnCount();
                ArrayList<String> selectedRow = new ArrayList<String>();
                for (int i = 1; i <= 7; i++){
                    selectedRow.add(rs.getString(i));
//                    if(rs.getString(i).equalsIgnoreCase(patientSym.get(i-2))){
//                        isSick = true;
//                    } else{
//                        isSick = false;
//                    }
                }
                row.add(selectedRow);
                
//                if(isSick){
//                    diseaseId = rs.getInt(1);
//                    break;
//                }
                   
               
            }
            
            for (int i = 0; i < row.size() ; i++){
                for (int j = 0; j < row.get(i).size(); j++){
                    System.out.println(row.get(i).get(j));
                }
                System.out.println("");
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
           
        }
       
      return diseaseId;
 }

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void Symptoms()
    {
        db= new Database();
        Con = db.getconnection();
        try {
            pst=Con.prepareStatement("");
            ResultSet Rs = pst.executeQuery();
        } catch (Exception e) {
        }
    }
    
}
