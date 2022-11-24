
package Service_Layer;

import DataAccess_layer.Items_DataAccess_layer;
import Model_Layer.Items;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Items_Service {

    private int addingitems;
    
     Items da=new Items();
    public void add(int itemcount,javax.swing.JTable Item_List,String name,String category,int price)
    {
         if (name.isEmpty()  ||category.isEmpty() ) {

            JOptionPane.showMessageDialog(da, "Missing Information!!!");
        } else {
                //Items_DataAccess_layer db=new Items_DataAccess_layer();

                    Items_DataAccess_layer.db.add(itemcount,Item_List,name,category,price);
                  //  addingitems=Items_DataAccess_layer.db.additemshere(itemcount,Item_List,name,category,price);

    }
    }
    
    private int deleteitems;
    
    public void delete(int Key,int itemcount,javax.swing.JTable Item_List,String name,String category,int price)
    {
        
     if(name.isEmpty()  || category.isEmpty())
                 {
                     
                     JOptionPane.showMessageDialog(da, "Missing Information!!!");
                 }
                 else
                 {
                     
                     Items_DataAccess_layer.db.delete(Key,itemcount,Item_List);
                                       //  deleteitems=Items_DataAccess_layer.db.additemshere(itemcount,Item_List,name,category,price);

                   }

    }
    
     private int edititems;
    
    public void edit(int Key,int itemcount,javax.swing.JTable Item_List,String name,String category,int price)
    {
          if(name.isEmpty()  || category.isEmpty())
                 {
                     
                     JOptionPane.showMessageDialog(da, "Missing Information!!!");
                 }
                 else
                 {
                                         
                    // Items_DataAccess_layer db=new Items_DataAccess_layer();
                    Items_DataAccess_layer.db.edit(Key,itemcount,Item_List,name,category,price);
                 //  edititems=Items_DataAccess_layer.db.additemshere(itemcount,Item_List,name,category,price);

                 }
    }
    
    public int Table(javax.swing.JTable Item_List,int Key,javax.swing.JTextField Item_name,javax.swing.JTextField Item_Price)
    {
         DefaultTableModel model = (DefaultTableModel) Item_List.getModel();
        int MyIndex= Item_List.getSelectedRow();
        Key= Integer.valueOf(model.getValueAt(MyIndex,0).toString());
        
        Item_name.setText(model.getValueAt(MyIndex,1).toString());
        Item_Price.setText(model.getValueAt(MyIndex,3).toString());
        
        return Key;
    }
}