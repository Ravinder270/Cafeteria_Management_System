package DataAccess_layer;


import Model_Layer.Login_as_Customer;
import DataAccess_layer.Selling_DataAccess_layer;
import Service_Layer.Selling_Service;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Login_as_Customer_DataAccess_Layer {
    Connection Con = null;
    Statement St = null,St1=null;
    ResultSet Rs = null,Rs1=null;
   
    Login_as_Customer ai=new Login_as_Customer();
    public void signin(String name,String password)
    {
        try{
                Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
                PreparedStatement Pst = Con.prepareStatement("Select username,password from customer where username=? and password=?");
                Pst.setString(1, name);
                Model_Layer.Login_as_Customer.Uname=name;
             Pst.setString(2, password);
                Rs = Pst.executeQuery();
                if (Rs.next()) {
                    ai.dispose();
                    new Model_Layer.Selling().setVisible(true);
                    ai.dispose();
                    
                } 
                else {
                            JOptionPane.showMessageDialog(ai, "Wrong Username & Password");
                     }
            } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
    }

