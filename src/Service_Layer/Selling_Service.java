
package Service_Layer;

import DataAccess_layer.Selling_DataAccess_layer;
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


public class Selling_Service {
    Selling da=new Selling();
    
   private int addbill; 
   
   public void addtobill(String name,int price,int quantity,javax.swing.JLabel Bill_Total,javax.swing.JTable BillTable,String Meal_Price,String Meal_Quantity)
   {
        if(name.isEmpty() )
        {
            JOptionPane.showMessageDialog(da,"Missing Information!!!");
        }
        else
        {
            int Total = price*quantity;
          Selling.GrdTot = Selling.GrdTot + Total;
       Bill_Total.setText("Rs "+Selling.GrdTot);
        DefaultTableModel   model= (DefaultTableModel) BillTable.getModel();
        String nextRowId= Integer.toString(model.getRowCount());
        model.addRow(new Object[]{
            Integer.valueOf(nextRowId)+1,
            name,
            Meal_Price,
            quantity,
                 Total
        });
        //addbill=Integer.toString(model.getRowCount());;
        }
        
  
   }
   
   private int insertbill;
   
   public void InsertBillTable(int billcount,String name,javax.swing.JTable BillTable,javax.swing.JTable MealList)
   {  
       try{ 
           Selling_DataAccess_layer db=new Selling_DataAccess_layer();
           db.InsertBill(billcount,Selling.GrdTot,name,BillTable,MealList);
            BillTable.print();     
        }
        catch(Exception e)
        {
          e.printStackTrace();
          // insertbill=InsertBill(billcount,Selling.GrdTot,name,BillTable,MealList);
        }
   }

   public void Table(javax.swing.JTable MealList,int Key,javax.swing.JTextField Meal_Name,javax.swing.JTextField Meal_Price)
   {
        DefaultTableModel model = (DefaultTableModel) MealList.getModel();
        int MyIndex= MealList.getSelectedRow();
        Key= Integer.valueOf(model.getValueAt(MyIndex,0).toString());
        Meal_Name.setText(model.getValueAt(MyIndex,1).toString());
        Meal_Price.setText(model.getValueAt(MyIndex,3).toString());
        // insertbill=InsertBill(billcount,Selling.GrdTot,name,BillTable,MealList);;
   }
 

}
