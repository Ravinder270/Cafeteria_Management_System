
package Service_Layer;

import DataAccess_layer.Login_as_Customer_DataAccess_Layer;
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


/**
 *
 * @author ravin
 */
public class Login_as_Customer_Service {
    
    Login_as_Customer ai=new Login_as_Customer();
    public void signin(String name,String password)
    {
         if(name.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(ai, "Missing Information!!!");
         
        }
        else 
        {
            Login_as_Customer_DataAccess_Layer da=new Login_as_Customer_DataAccess_Layer();
            da.signin(name, password);
            
        }
    }
}
