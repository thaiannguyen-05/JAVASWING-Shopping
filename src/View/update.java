package View;

import Controller.controllerCustomerView;
import Controller.controllerEmployeeView;
import Controller.controllerSupplier;
import Controller.controllerUpdateButton;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class update extends javax.swing.JFrame {

    private final SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd");
    private controllerUpdateButton controllerUpdateButton;
    private Controller.controllerCustomerView controllerCustomerView;
    private Controller.controllerEmployeeView controllerEmployeeView;
    private Controller.controllerSupplier controllerSupplier;
    private final homeAdminForm homeAdmin;
    private customerView customerView;
    private employee employeeView;
    private supplierView supplierView;
    
    public update() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        controllerUpdateButton = new controllerUpdateButton(this);// khoi tao controller
        customerView = new customerView();
        employeeView = new employee();
        supplierView = new supplierView();
        homeAdmin = new homeAdminForm();

        String choose = homeAdmin.getWhichChoose();

        switch (choose) {
            case "1":
                //add action updateButton
                updateButton.addActionListener(e -> {
                    try {
                        int row = controllerCustomerView.selectRow;
                        controllerUpdateButton.handleUpdateButton("customer", customerView.getTable(), row, "cID");
                    } catch (SQLException ex) {
                        Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                break;
            case "2":
                updateButton.addActionListener(e -> {
                    try {
                        int row = controllerEmployeeView.selectRowEmp;
                        controllerUpdateButton.handleUpdateButton("employee", employeeView.getTable(), row, "eID");
                    } catch (SQLException ex) {
                        Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                break;
            case "3":
                updateButton.addActionListener(e -> {
                    try {
                        int row = controllerSupplier.selectSup;
                        controllerUpdateButton.handleUpdateButton("supplier", supplierView.getTable(), row, "sID");
                    } catch (SQLException ex) {
                        Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                break;
        }

    }

    // thiet lap controllerCustomerView
    public void setControllerCustomerView(controllerCustomerView controllerCustomerView) {
        controllerUpdateButton.setControllerCustomerView(controllerCustomerView);
    }

    public void setControllerEmployeeView(controllerEmployeeView controllerEmployeeView) {
        controllerUpdateButton.setControllerEmployeeView(controllerEmployeeView);
    }

    public void setControllerSupplier(controllerSupplier controllerSupplier) {
        controllerUpdateButton.setControllerSupplier(controllerSupplier);
    }

    // get information
    public String getFullName() {
        return fullNameField.getText();
    }

    public String getDob() {
        return formart.format(dobField.getDate());
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getUser() {
        return userField.getText();
    }

    public String getPass() {
        return passFIeld.getText();
    }

    public String getGender() {
        return genderField.getSelectedItem().toString();
    }

    //inform
    public void inform(String x) {
        informLabel.setText(x);
    }

    public void setAddressField(String addressField) {
        this.addressField.setText(addressField);
    }

    public void setDob(String Dob) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date defaultDate = sdf.parse(Dob);
            dobField.setDate(defaultDate);  // Bỏ comment dòng này
        } catch (ParseException e) {
            e.printStackTrace();  // Nên thêm printStackTrace để debug nếu có lỗi
        }
    }

    public void setEmailField(String emailField) {
        this.emailField.setText(emailField);
    }

    public void setFullNameField(String fullNameField) {
        this.fullNameField.setText(fullNameField);
    }

    public void setGenderField(String genderField) {
        this.genderField.setSelectedItem(genderField);
    }

    public void setPassFIeld(String passFIeld) {
        this.passFIeld.setText(passFIeld);
    }

    public void setUserField(String userField) {
        this.userField.setText(userField);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        genderField = new javax.swing.JComboBox<>();
        passFIeld = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dobField = new com.toedter.calendar.JDateChooser();
        userField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        informLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        updateButton.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        updateButton.setText("update");

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

        passFIeld.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel15.setText("Password");

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel16.setText("Gender");

        userField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel17.setText("Username");

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel18.setText("Date of Birth");

        addressField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel19.setText("Address");

        emailField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel20.setText("Email");

        fullNameField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        fullNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameFieldActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel21.setText("Full Name");

        informLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel20))
                    .addComponent(jLabel16)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(passFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(informLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(informLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date defaultDate = sdf.parse("2000-01-02");
            dobField.setDate(defaultDate);
        } catch (Exception e) {
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fullNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameFieldActionPerformed

    }//GEN-LAST:event_fullNameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new update().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private com.toedter.calendar.JDateChooser dobField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel informLabel;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField passFIeld;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
