
package Model_Layer;

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


public class Selling extends javax.swing.JFrame
{

   Selling_DataAccess_layer da=new Selling_DataAccess_layer();
    
    public Selling() {
          initComponents();
          da.ShowProducts(MealList);
        Meal_Price.setEditable(false);
       Customer_Name.setText(Login_as_Customer.Uname);
        Meal_Name.setEditable(false);
    }

   
    Connection Con = null;
    Statement St = null,St1=null;
    ResultSet Rs = null,Rs1=null;
    
    
    public static int billcount;
    
    public static int GrdTot = 0;   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Meal_Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Meal_Price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Add_To_Bill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Customer_Name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MealList = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        Meal_Quantity = new javax.swing.JTextField();
        Print_Bill = new javax.swing.JButton();
        Bill_Total = new javax.swing.JLabel();
        Filter_by_Category = new javax.swing.JComboBox<>();
        Refresh_by_Category = new javax.swing.JButton();
        PreviousBills = new javax.swing.JButton();
        Customer_Logout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Place your Order here");

        Meal_Name.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Meal_Name.setForeground(new java.awt.Color(255, 102, 102));
        Meal_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Meal_NameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Name");

        Meal_Price.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Meal_Price.setForeground(new java.awt.Color(255, 102, 102));
        Meal_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Meal_PriceActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Price");

        Add_To_Bill.setBackground(new java.awt.Color(0, 102, 102));
        Add_To_Bill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Add_To_Bill.setForeground(new java.awt.Color(255, 255, 255));
        Add_To_Bill.setText("Add To Bill");
        Add_To_Bill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        Add_To_Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_To_BillActionPerformed(evt);
            }
        });

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Total"
            }
        ));
        BillTable.setRowHeight(29);
        BillTable.setRowMargin(1);
        BillTable.setShowGrid(false);
        BillTable.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(BillTable);

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 204));
        jLabel10.setText("Customer Name");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 204));
        jLabel11.setText("Quantity");

        Customer_Name.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Customer_Name.setForeground(new java.awt.Color(255, 102, 102));
        Customer_Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Customer_NameMouseClicked(evt);
            }
        });
        Customer_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_NameActionPerformed(evt);
            }
        });

        MealList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Price"
            }
        ));
        MealList.setRowHeight(29);
        MealList.setRowMargin(1);
        MealList.setShowGrid(false);
        MealList.setShowHorizontalLines(true);
        MealList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MealListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MealList);

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 204));
        jLabel12.setText("Your Bill");

        Meal_Quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Meal_Quantity.setForeground(new java.awt.Color(255, 102, 102));
        Meal_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Meal_QuantityActionPerformed(evt);
            }
        });

        Print_Bill.setBackground(new java.awt.Color(0, 102, 102));
        Print_Bill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Print_Bill.setForeground(new java.awt.Color(255, 255, 255));
        Print_Bill.setText("Print");
        Print_Bill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        Print_Bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Print_BillMouseClicked(evt);
            }
        });
        Print_Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_BillActionPerformed(evt);
            }
        });

        Bill_Total.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        Bill_Total.setForeground(new java.awt.Color(204, 255, 204));
        Bill_Total.setText("Total");
        Bill_Total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bill_TotalMouseClicked(evt);
            }
        });

        Filter_by_Category.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        Filter_by_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Specials", "Beverage", "Snacks", "Sandwiches", "Wraps", "Ice Creams", " " }));
        Filter_by_Category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Filter_by_CategoryItemStateChanged(evt);
            }
        });
        Filter_by_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_by_CategoryActionPerformed(evt);
            }
        });

        Refresh_by_Category.setBackground(new java.awt.Color(0, 102, 102));
        Refresh_by_Category.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Refresh_by_Category.setForeground(new java.awt.Color(255, 255, 255));
        Refresh_by_Category.setText("Refresh");
        Refresh_by_Category.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        Refresh_by_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_by_CategoryActionPerformed(evt);
            }
        });

        PreviousBills.setBackground(new java.awt.Color(0, 102, 102));
        PreviousBills.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PreviousBills.setForeground(new java.awt.Color(255, 255, 255));
        PreviousBills.setText("View Previous Bills");
        PreviousBills.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        PreviousBills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreviousBillsMouseClicked(evt);
            }
        });
        PreviousBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousBillsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Meal_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Meal_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(Meal_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Add_To_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Customer_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Filter_by_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Refresh_by_Category)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Print_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Bill_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(PreviousBills)
                        .addGap(166, 166, 166))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Meal_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Customer_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Meal_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Meal_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Add_To_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Filter_by_Category))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Refresh_by_Category)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bill_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Print_Bill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PreviousBills)
                        .addGap(18, 18, 18))))
        );

        Customer_Logout.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        Customer_Logout.setForeground(new java.awt.Color(255, 0, 51));
        Customer_Logout.setText("Logout");
        Customer_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Customer_LogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Customer_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Customer_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
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
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Meal_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Meal_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Meal_NameActionPerformed

    private void Meal_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Meal_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Meal_PriceActionPerformed



    private void Add_To_BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_To_BillActionPerformed
  
           Selling_Service service=new Selling_Service();
        service.addtobill(Meal_Name.getText(), Integer.valueOf(Meal_Price.getText()),Integer.valueOf(Meal_Quantity.getText()),Bill_Total,BillTable,Meal_Price.getText(),Meal_Price.getText());
 
    }//GEN-LAST:event_Add_To_BillActionPerformed

    private void Customer_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_NameActionPerformed
        
         
    }//GEN-LAST:event_Customer_NameActionPerformed

    private void Meal_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Meal_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Meal_QuantityActionPerformed

    private void Print_BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_BillActionPerformed
Selling_Service service=new Selling_Service();
   
service.InsertBillTable(billcount,Customer_Name.getText(),BillTable,MealList);
   GrdTot=0;  
    }//GEN-LAST:event_Print_BillActionPerformed

    int Key=0; 
    private void MealListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MealListMouseClicked
        Selling_Service service=new Selling_Service();
        service.Table(MealList,Key,Meal_Name,Meal_Price);
    }//GEN-LAST:event_MealListMouseClicked

    private void Customer_NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_NameMouseClicked
        
    }//GEN-LAST:event_Customer_NameMouseClicked

    private void Customer_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_LogoutMouseClicked
        new Login().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Customer_LogoutMouseClicked

    private void Print_BillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Print_BillMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Print_BillMouseClicked

    private void Filter_by_CategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Filter_by_CategoryItemStateChanged
       Selling_DataAccess_layer da=new Selling_DataAccess_layer();
        da.FilterProducts(MealList,Filter_by_Category) ;
    }//GEN-LAST:event_Filter_by_CategoryItemStateChanged

    private void Filter_by_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_by_CategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_by_CategoryActionPerformed

    private void Refresh_by_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_by_CategoryActionPerformed
 Selling_DataAccess_layer da=new Selling_DataAccess_layer();
        da.ShowProducts(MealList);
    }//GEN-LAST:event_Refresh_by_CategoryActionPerformed

    private void Bill_TotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bill_TotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Bill_TotalMouseClicked

    private void PreviousBillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviousBillsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousBillsMouseClicked

    private void PreviousBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousBillsActionPerformed
      new viewsells_for_customer().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_PreviousBillsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_To_Bill;
    private javax.swing.JTable BillTable;
    private javax.swing.JLabel Bill_Total;
    private javax.swing.JLabel Customer_Logout;
    private javax.swing.JTextField Customer_Name;
    private javax.swing.JComboBox<String> Filter_by_Category;
    private javax.swing.JTable MealList;
    private javax.swing.JTextField Meal_Name;
    private javax.swing.JTextField Meal_Price;
    private javax.swing.JTextField Meal_Quantity;
    private javax.swing.JButton PreviousBills;
    private javax.swing.JButton Print_Bill;
    private javax.swing.JButton Refresh_by_Category;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
