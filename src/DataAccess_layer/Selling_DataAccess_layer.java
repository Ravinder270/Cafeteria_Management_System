
package DataAccess_layer;

import Model_Layer.Login_as_Customer;
import Model_Layer.Selling;
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


public class Selling_DataAccess_layer {
     Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;

     private void CountBill(int billcount)
     {
     try{
                  Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");

         St1=Con.createStatement();
         Rs1=St1.executeQuery("Select Max(BNum) from BillTb1");//change if it is not working
         Rs1.next();
         billcount = Rs1.getInt(1)+1;
     }
     catch(Exception e){
     e.printStackTrace();
     }
     }
     
    
    public void ShowProducts(javax.swing.JTable MealList)
    {
        try{
            Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cafedb.producttb1;");
            MealList.setModel(DbUtils.resultSetToTableModel(Rs));
        }
        catch(Exception e)
        {
                    e.printStackTrace();
        }
   }
    
   public void ShowBills(javax.swing.JTable BillList)
    {
       try{
            Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cafedb.billtb1;");
            BillList.setModel(DbUtils.resultSetToTableModel(Rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 
   
   public void CustomerShowBills(javax.swing.JTable Customer_BillList)
    {
       try{
            Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cafedb.billtb1 where Customer_name='"+Login_as_Customer.Uname+"'");
            Customer_BillList.setModel(DbUtils.resultSetToTableModel(Rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public void FilterProducts(javax.swing.JTable MealList,javax.swing.JComboBox<String> Filter_by_Category) {
        try{
            Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cafedb.producttb1 where Category='"+ Filter_by_Category.getSelectedItem().toString()+"'");
            MealList.setModel(DbUtils.resultSetToTableModel(Rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
    }
    
    public void InsertBill(int billcount,int GrdTot,String name,javax.swing.JTable BillTable,javax.swing.JTable MealList)
    {
         
                     try {
                         
                         CountBill(billcount);
                         Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
                    PreparedStatement Pst = Con.prepareStatement("insert into BillTb1 values(?,?,?,?)");
                    Pst.setInt(1,billcount);
                      Pst.setString(2,name);
                    DateTimeFormatter  dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDateTime now= LocalDateTime.now();
                      Pst.setString(3,now.toString().substring(0,10 ));
                    Pst.setInt(4,GrdTot);
                    int row= Pst.executeUpdate();
                    Con.close();

        DefaultTableModel   model= (DefaultTableModel) BillTable.getModel();
        String nextRowId= Integer.toString(model.getRowCount());
        model.addRow(new Object[]{
                 null,
            null,
            null,
            "Grand Total: ",
            GrdTot
        });
                    ShowProducts(MealList);
                     } catch (SQLException ex) {

                       ex.printStackTrace();                    }
                     
                 
    }
    
}
