package View;

import Controller.controllerHomeAdmin;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class homeAdminForm extends javax.swing.JFrame {
    
    private controllerHomeAdmin controllerHomeAdmin;// khoi tao controller
    public static String whichChoose = "";
    
    
    public homeAdminForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        controllerHomeAdmin = new controllerHomeAdmin(this);// khoi tao controller
        
        // Customer button - Hồng pastel
        customerButton.setBackground(new Color(255, 192, 203));
        customerButton.setForeground(Color.BLACK);

        // Supplier button - Xanh dương nhạt
        supplierButotn.setBackground(new Color(173, 216, 230));
        supplierButotn.setForeground(Color.BLACK);

        // Employee button - Xanh lá nhạt
        empButton.setBackground(new Color(152, 251, 152));
        empButton.setForeground(Color.BLACK);

        // Stock button - Vàng nhạt
        stockButton.setBackground(new Color(255, 255, 224));
        stockButton.setForeground(Color.BLACK);

        // Report button - Tím nhạt
        reportButton.setBackground(new Color(230, 230, 250));
        reportButton.setForeground(Color.BLACK);

        
        
        // add event logout
        logOut.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){

                try {
                    controllerHomeAdmin.handleLogout();
                } catch (SQLException ex) {
                    Logger.getLogger(homeAdminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // add event check Profile
        checkProfile.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    controllerHomeAdmin.handleCheckProfile();
                } catch (SQLException ex) {
                    Logger.getLogger(homeAdminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // add event buttonCustomer
        customerButton.addActionListener(e -> {
            try {
                whichChoose = "1";
                controllerHomeAdmin.handleCustomerButton();
            } catch (SQLException ex) {
                Logger.getLogger(homeAdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // add event employee
        empButton.addActionListener(e->{
            whichChoose = "2";
            controllerHomeAdmin.handleEmployeeButton();
        });
                
        // add event supplier
        supplierButotn.addActionListener(e->{
            whichChoose = "3";
            controllerHomeAdmin.handleSupplierButton();
        });
        
        // add event stock
        stockButton.addActionListener(e->{
            whichChoose = "4";
            controllerHomeAdmin.handleStockButton();        
        });
        
        // add event report
        reportButton.addActionListener(e->{
            try {
                controllerHomeAdmin.handleReportButton();
            } catch (SQLException ex) {
                Logger.getLogger(homeAdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
    }
    
    // get totalPanel
    public JPanel getTotalPanel(){
        return this.panelTotal;
    }
    
    public String getWhichChoose(){
        return this.whichChoose;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        customerButton = new javax.swing.JToggleButton();
        supplierButotn = new javax.swing.JToggleButton();
        empButton = new javax.swing.JToggleButton();
        stockButton = new javax.swing.JToggleButton();
        reportButton = new javax.swing.JToggleButton();
        logOut = new javax.swing.JLabel();
        checkProfile = new javax.swing.JLabel();
        panelTotal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(customerButton);
        customerButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        customerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/customer.png"))); // NOI18N
        customerButton.setText("Customer");
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(customerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 110, 40));

        buttonGroup1.add(supplierButotn);
        supplierButotn.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        supplierButotn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/supplier.png"))); // NOI18N
        supplierButotn.setText("Supplier");
        jPanel1.add(supplierButotn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 110, 40));

        buttonGroup1.add(empButton);
        empButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        empButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/emp.png"))); // NOI18N
        empButton.setText("Employee");
        jPanel1.add(empButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 110, 40));

        buttonGroup1.add(stockButton);
        stockButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        stockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/product.png"))); // NOI18N
        stockButton.setText("Stock");
        jPanel1.add(stockButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 110, 40));

        buttonGroup1.add(reportButton);
        reportButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        reportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/reports.png"))); // NOI18N
        reportButton.setText("Report");
        jPanel1.add(reportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 110, 40));

        logOut.setText("Logout");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        logOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                logOutKeyPressed(evt);
            }
        });
        jPanel1.add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, 28));

        checkProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/iconFrofile.png"))); // NOI18N
        checkProfile.setText("Your Profile");
        checkProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkProfileMouseClicked(evt);
            }
        });
        jPanel1.add(checkProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, 28));

        panelTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 2, 36)); // NOI18N
        jLabel4.setText("DASH BROAD MANAGER");

        jLabel6.setFont(new java.awt.Font("Javanese Text", 2, 12)); // NOI18N
        jLabel6.setText("Welcome!");

        javax.swing.GroupLayout panelTotalLayout = new javax.swing.GroupLayout(panelTotal);
        panelTotal.setLayout(panelTotalLayout);
        panelTotalLayout.setHorizontalGroup(
            panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalLayout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(panelTotalLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTotalLayout.setVerticalGroup(
            panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jPanel1.add(panelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 820, 420));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/back.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked

    }//GEN-LAST:event_logOutMouseClicked

    private void logOutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logOutKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutKeyPressed

    private void checkProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkProfileMouseClicked

    }//GEN-LAST:event_checkProfileMouseClicked

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(homeAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeAdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel checkProfile;
    private javax.swing.JToggleButton customerButton;
    private javax.swing.JToggleButton empButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logOut;
    private javax.swing.JPanel panelTotal;
    private javax.swing.JToggleButton reportButton;
    private javax.swing.JToggleButton stockButton;
    private javax.swing.JToggleButton supplierButotn;
    // End of variables declaration//GEN-END:variables
}
