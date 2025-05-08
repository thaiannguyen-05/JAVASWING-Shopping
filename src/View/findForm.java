package View;

import Controller.controllerFindView;
import Model.Supplier;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class findForm extends javax.swing.JFrame {
    
    private controllerFindView controllerFindView;// khoi tao controller
    private customerView customerView;
    private employee employeeView;
    private supplierView supplierView;
    private stockView stockView;
    
    public findForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public findForm(customerView customerView) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.customerView = customerView;
        controllerFindView = new controllerFindView(this);
        
        // handle find button
        findButton.addActionListener(e->{
            try {
                controllerFindView.setCustomerView(customerView);
                controllerFindView.handleFindButton();
            } catch (SQLException ex) {
                Logger.getLogger(findForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public findForm(employee employee) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.employeeView = employee;
        controllerFindView = new controllerFindView(this);
        
        // handle find button
        findButton.addActionListener(e->{
            try {
                controllerFindView.setEmployeeView(employee);
                controllerFindView.handleFindButtonEmp();
            } catch (SQLException ex) {
                Logger.getLogger(findForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public findForm(supplierView supplierView) throws SQLException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.supplierView = supplierView;
        controllerFindView = new controllerFindView(this);
        
        findButton.addActionListener(e->{
            try {
                controllerFindView.setSupplierView(supplierView);
                controllerFindView.handleFindButtonSupplier();
            } catch (SQLException ex) {
                Logger.getLogger(findForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public findForm(stockView stockView) throws SQLException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.stockView = stockView;
        controllerFindView = new controllerFindView(this);
        
        findButton.addActionListener(e->{
            try {
                controllerFindView.setStockView(stockView);
                controllerFindView.handleFindProduct();
            } catch (SQLException ex) {
                Logger.getLogger(findForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
     public String getNameSearch(){
         return this.nameField.getText();
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jLabel1.setText("Name : ");

        nameField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N

        findButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        findButton.setText("Find");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(findButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(findForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(findForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(findForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(findForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new findForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
