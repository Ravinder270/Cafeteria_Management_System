
package Service_Layer;
import DataAccess_layer.SignUp_DataAccess_layer;
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

public class SignUp_Service {
    SignUp ai=new SignUp();
    public void signUp(String name,String password)
    {
         if(name.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(ai, "Missing Information!!!");
         
        }
        else 
        {
            SignUp_DataAccess_layer da=new SignUp_DataAccess_layer();
            da.signup(name, password);
            
        }
    }
}
