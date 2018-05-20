/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.patient;
import sun.security.rsa.RSACore;

/**
 *
 * @author GABRIEL
 */
public class upLoadingDatabase {

    Database db;
    Connection Con;
    PreparedStatement pst;
    ResultSet ty;

    // creating the table from the database in mysql
    public void fillpatientTable(JTable table, String valueToSearch) {
        try {
            db = new Database();
            Con = db.getconnection();
            pst = Con.prepareStatement("SELECT * FROM `patientregistration` WHERE CONCAT(`ID`, `patientID`, `patientName`, `patientNumber`, `TimeStamp`)LIKE ?");
            pst.setString(1, "%" + valueToSearch + "%");

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[5];

                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);

                model.addRow(row);

            }
        } catch (SQLException er) {
            System.out.println(er.getMessage());

        }
    }

    public ResultSet searchpatient(String textfield) {

        try {
            db = new Database();
           

            Con = db.getconnection();

            pst = Con.prepareStatement("SELECT `ID`, `username` FROM `user` WHERE `ID`=? and `username`=?");

            ty = pst.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return ty;
    }

}
