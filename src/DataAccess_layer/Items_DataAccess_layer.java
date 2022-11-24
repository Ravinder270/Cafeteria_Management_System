
package DataAccess_layer;
import Service_Layer.Items_Service;
import Model_Layer.Items;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Items_DataAccess_layer {
    Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;
    public static Items_DataAccess_layer db=new Items_DataAccess_layer();
    
     public void CountProd(int itemcount) {
        try {
               Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
             St1 = Con.createStatement();
             Rs1 = St1.executeQuery("Select Max(PNum) from ProductTb1");
              Rs1.next();
             itemcount = Rs1.getInt(1) + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    
     
    
    public void ShowProducts(javax.swing.JTable Item_List) {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb", "root", "iamravinder@2701");

            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cafedb.producttb1;");
            
            Item_List.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
                    e.printStackTrace();
        }
    }
    public void FilterProducts(javax.swing.JTable Item_List,javax.swing.JComboBox<String> Items_Filter) {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb", "root", "iamravinder@2701");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM cafedb.producttb1 where Category='" + Items_Filter.getSelectedItem().toString() + "'");
            Item_List.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    public void add(int itemcount,javax.swing.JTable Item_List,String name,String category,int price)
       {
    Items da =new Items();
            try {
                CountProd(itemcount);
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb", "root", "iamravinder@2701");
                PreparedStatement Pst = Con.prepareStatement("insert into ProductTb1 values(?,?,?,?)");
                Pst.setInt(1, itemcount);
                Pst.setString(2, name);
                Pst.setString(3, category);
                Pst.setInt(4, price);
                int row = Pst.executeUpdate();
                JOptionPane.showMessageDialog(da, "Item Added!!!");
                Con.close();
                ShowProducts(Item_List);
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(da, ex);
            }

}
    public void delete(int Key,int itemcount,javax.swing.JTable Item_List)
{
    Items da =new Items();
    try {
        
                         CountProd(itemcount);
                         Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
                            Statement statement = Con.createStatement();  
                                    statement.executeUpdate("DELETE FROM ProductTb1 WHERE PNum=" + Key + "");  
                                    JOptionPane.showMessageDialog(da, "Item Deleted!!!");  
                                    statement.close();  
                                    Con.close();  
                   ShowProducts(Item_List);
                     } catch (SQLException ex) {

                       JOptionPane.showMessageDialog(da, ex);                     
                    }
}
   
     public int additemshere(int itemcount,javax.swing.JTable Item_List,String name, String category,int price)
     {
         Item_List.setModel(DbUtils.resultSetToTableModel(Rs));
         int b=0;
         return b;
     }
     
    public void edit(int Key,int itemcount,javax.swing.JTable Item_List,String name,String category,int price)
    {
        Items da =new Items();
        try {
                         CountProd(itemcount);
                         Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","iamravinder@2701");
                    PreparedStatement Pst = Con.prepareStatement("update ProductTb1 set PName=?,Category=?,Price=? where PNum=?");
                    Pst.setInt(4,Key);
                    Pst.setString(1,name);
                    Pst.setString(2,category);
                    Pst.setInt(3,price);
                    int row= Pst.executeUpdate();
                    JOptionPane.showMessageDialog(da, "Item Updated!!!");
                    Con.close();
                    ShowProducts(Item_List);
                     } catch (SQLException ex) {

                       JOptionPane.showMessageDialog(da, ex); 
    }
    
}
}
