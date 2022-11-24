package Model_Layer;

import DataAccess_layer.Items_DataAccess_layer;
import Service_Layer.Items_Service;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Items extends javax.swing.JFrame {
    
Items_DataAccess_layer da =new Items_DataAccess_layer();

    public Items() {
        initComponents();
        da.ShowProducts(Item_List);
    }
    
    

    Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;
     int Key=0;
    public int itemcount;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Item_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Item_Price = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Item_categories = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Items_Filter = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Item_Add = new javax.swing.JButton();
        Item_Edit = new javax.swing.JButton();
        Item_Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Item_List = new javax.swing.JTable();
        Item_Category_Refresh = new javax.swing.JButton();
        Admin_Logout = new javax.swing.JLabel();
        View_Bills = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Items Management");

        Item_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Item_name.setForeground(new java.awt.Color(255, 102, 102));
        Item_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_nameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Name");

        Item_Price.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Item_Price.setForeground(new java.awt.Color(255, 102, 102));
        Item_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_PriceActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Category");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Price");

        Item_categories.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        Item_categories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Specials", "Beverage", "Snacks", "Sandwiches", "Wraps", "Ice Creams", " " }));
        Item_categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_categoriesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calisto MT", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Filter");

        Items_Filter.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        Items_Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Specials", "Beverage", "Snacks", "Sandwiches", "Wraps", "Ice Creams", " " }));
        Items_Filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Items_FilterItemStateChanged(evt);
            }
        });
        Items_Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Items_FilterActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 204));
        jLabel9.setText("Items List");

        Item_Add.setBackground(new java.awt.Color(0, 102, 102));
        Item_Add.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Item_Add.setForeground(new java.awt.Color(255, 255, 255));
        Item_Add.setText("Add");
        Item_Add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        Item_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_AddActionPerformed(evt);
            }
        });

        Item_Edit.setBackground(new java.awt.Color(0, 102, 102));
        Item_Edit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Item_Edit.setForeground(new java.awt.Color(255, 255, 255));
        Item_Edit.setText("Edit");
        Item_Edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        Item_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_EditActionPerformed(evt);
            }
        });

        Item_Delete.setBackground(new java.awt.Color(0, 102, 102));
        Item_Delete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Item_Delete.setForeground(new java.awt.Color(255, 255, 255));
        Item_Delete.setText("Delete");
        Item_Delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        Item_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_DeleteActionPerformed(evt);
            }
        });

        Item_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Price"
            }
        ));
        Item_List.setRowHeight(29);
        Item_List.setRowMargin(1);
        Item_List.setShowGrid(false);
        Item_List.setShowHorizontalLines(true);
        Item_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Item_ListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Item_List);

        Item_Category_Refresh.setBackground(new java.awt.Color(0, 102, 102));
        Item_Category_Refresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Item_Category_Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Item_Category_Refresh.setText("Refresh");
        Item_Category_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_Category_RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(Item_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Items_Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Item_Category_Refresh))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Item_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101)
                                .addComponent(Item_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(284, 284, 284))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Item_name, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Item_categories, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Item_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Item_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Item_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Item_categories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Item_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Item_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Item_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Items_Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Item_Category_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Admin_Logout.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        Admin_Logout.setForeground(new java.awt.Color(255, 0, 51));
        Admin_Logout.setText("Logout");
        Admin_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Admin_LogoutMouseClicked(evt);
            }
        });

        View_Bills.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        View_Bills.setForeground(new java.awt.Color(255, 0, 51));
        View_Bills.setText("View Billing");
        View_Bills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                View_BillsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(View_Bills)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Admin_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(View_Bills, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(495, 495, 495)
                        .addComponent(Admin_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(243, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Item_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_nameActionPerformed

    private void Item_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_PriceActionPerformed

    private void Item_categoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_categoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_categoriesActionPerformed

    private void Items_FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Items_FilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Items_FilterActionPerformed

    
    private void Item_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_AddActionPerformed

        Items_Service service=new Items_Service();
        service.add(itemcount,Item_List,Item_name.getText(),Item_categories.getSelectedItem().toString(),Integer.valueOf(Item_Price.getText()));

    
    }//GEN-LAST:event_Item_AddActionPerformed

    private void Item_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_EditActionPerformed
      Items_Service service=new Items_Service();
      
        service.edit(Key,itemcount,Item_List,Item_name.getText(),Item_categories.getSelectedItem().toString(),Integer.valueOf(Item_Price.getText()));
   
             
    }//GEN-LAST:event_Item_EditActionPerformed

    private void Item_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_DeleteActionPerformed
                
       
                      Items_Service service=new Items_Service();
                      
        service.delete(Key,itemcount,Item_List,Item_name.getText(),Item_categories.getSelectedItem().toString(),Integer.valueOf(Item_Price.getText()));
         
                 
    }//GEN-LAST:event_Item_DeleteActionPerformed
 
    private void Item_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Item_ListMouseClicked
       Items_Service service=new Items_Service();
        Key=service.Table(Item_List,Key,Item_name,Item_Price);
    }//GEN-LAST:event_Item_ListMouseClicked

    private void Items_FilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Items_FilterItemStateChanged
      Items_DataAccess_layer da =new Items_DataAccess_layer();
      
        da.FilterProducts(Item_List,Items_Filter);
    }//GEN-LAST:event_Items_FilterItemStateChanged

    private void Item_Category_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_Category_RefreshActionPerformed
       Items_DataAccess_layer da =new Items_DataAccess_layer();
      
        da.ShowProducts(Item_List);
    }//GEN-LAST:event_Item_Category_RefreshActionPerformed

    private void Admin_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Admin_LogoutMouseClicked
        new Login().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Admin_LogoutMouseClicked

    private void View_BillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_View_BillsMouseClicked
         new ViewSells().setVisible(true);
            this.dispose();
    }//GEN-LAST:event_View_BillsMouseClicked

    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Items().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin_Logout;
    private javax.swing.JButton Item_Add;
    private javax.swing.JButton Item_Category_Refresh;
    private javax.swing.JButton Item_Delete;
    private javax.swing.JButton Item_Edit;
    private javax.swing.JTable Item_List;
    private javax.swing.JTextField Item_Price;
    private javax.swing.JComboBox<String> Item_categories;
    private javax.swing.JTextField Item_name;
    private javax.swing.JComboBox<String> Items_Filter;
    private javax.swing.JLabel View_Bills;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
