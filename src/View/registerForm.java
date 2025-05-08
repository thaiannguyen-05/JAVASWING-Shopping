package View;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import Model.Account;
import Controller.controllerRegister;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerForm extends javax.swing.JFrame {

    private SimpleDateFormat formart = new SimpleDateFormat("yyyy-mm-dd");
    private Account account;
    private controllerRegister controllerRegister;

    public registerForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        registerButton.setBackground(new Color(111, 94, 255));
        registerButton.setForeground(Color.WHITE);
        loginLabel.setForeground(new Color(64, 64, 64));

        //khoi tao controller
        controllerRegister = new controllerRegister(this);

        account = new Account();

        // add action cho register button
        registerButton.addActionListener(e -> controllerRegister.handleRegisterButton());

        // add action MouseClicked loginLabel
        loginLabel.addMouseListener(new MouseAdapter(){
              @Override
              public void mouseClicked(MouseEvent e){
                  try {
                      controllerRegister.handleBackLogin();
                  } catch (SQLException ex) {
                      Logger.getLogger(registerForm.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          });

    }

    // getter 
    public String getFullname() {
        return fullNameField.getText();
    }

    public String getPosition() {
        return positionField.getSelectedItem().toString();
    }

    public String getdob() {
        return formart.format(dobField.getDate());
    }

    public String getGender() {
        return genderField.getSelectedItem().toString();
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

    public void setIfromLabel(String inform) {
        infromLabel.setText(inform);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        infromLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        passFIeld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dobField = new com.toedter.calendar.JDateChooser();
        positionField = new javax.swing.JComboBox<>();
        genderField = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        userField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infromLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jPanel1.add(infromLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 280, 20));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, 20));

        loginLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        loginLabel.setText("Login");
        jPanel1.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        passFIeld.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jPanel1.add(passFIeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 170, 30));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel5.setText("Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));
        jPanel1.add(dobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 170, 30));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date defaultDate = sdf.parse("2000-01-02");
            dobField.setDate(defaultDate);
        } catch (Exception e) {
        }

        positionField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "customer", "supplier", "employee" }));
        jPanel1.add(positionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, 30));

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        jPanel1.add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 170, 30));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel6.setText("Position");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel12.setText("Date of Birth");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, 20));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel11.setText("Gender");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, 20));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel8.setText("Username");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        fullNameField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jPanel1.add(fullNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, 30));

        emailField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 170, 30));

        addressField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jPanel1.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 170, 30));

        userField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jPanel1.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 170, 30));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel9.setText("Full Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 20));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel10.setText("Have an account ? ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        registerButton.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        registerButton.setText("Register");
        jPanel1.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/backLogin.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private com.toedter.calendar.JDateChooser dobField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel infromLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField passFIeld;
    private javax.swing.JComboBox<String> positionField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
