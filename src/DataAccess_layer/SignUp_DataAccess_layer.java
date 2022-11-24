
package DataAccess_layer;


import Service_Layer.SignUp_Service;
import Model_Layer.SignUp;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SignUp_DataAccess_layer {
    Connection Con = null;
    Statement St = null,St1=null;
    ResultSet Rs = null,Rs1=null;
    
   SignUp ai=new SignUp();
   
    public void signup(String name,String password)
    {
          try {
                         
                         Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
                    
                    try {
                   PreparedStatement Pst = Con.prepareStatement("insert into customer values(?,?)");
                    Pst.setString(1,name);
                    Pst.setString(2,password);
                    int row= Pst.executeUpdate();
                    Con.close();
                     new Model_Layer.Login_as_Customer().setVisible(true);
                    ai.dispose();
                    } catch (SQLIntegrityConstraintViolationException e) {
    
                    JOptionPane.showMessageDialog(null,"Duplicate Entry");
                                   
                     }} 
                    catch (SQLException ex) {

                                            
                     ex.printStackTrace();
                 }

    }
}
