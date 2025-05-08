package View;

import Controller.controllerLogin;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class loginForm extends javax.swing.JFrame {

    private controllerLogin controlLogin; // khai bao control
    // khai bao control
    public static String username = null;

    public loginForm() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        loginButton.setBackground(new Color(111, 94, 255));
        loginButton.setForeground(Color.WHITE);
        error1.setVisible(false);
        error2.setVisible(false);
        controlLogin = new controllerLogin(this);// khoi tao controlLogin

        // handle seeing pass
        seeingPassbutton.addActionListener(e -> controlLogin.handleSeeingPassButton());

        // handle automaticly fill password
        userField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    controlLogin.automaticlyHandleLoginButton(userField.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // su dung bieu thuc lambda de set su kien cho cac feature
        loginButton.addActionListener(e -> {
            try {
                username = userField.getText();
                controlLogin.handleLoginButton();
            } catch (SQLException ex) {
                Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // add su kien mousecliked cho forgotpass
        forgotPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {  // Đúng chính tả
                controlLogin.handleForgotPass();
            }
        });

        // add su kien mouseClicked cho register
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controlLogin.handleRegisterClicked();
            }
        });

        // add su kien cho radioButton
        staySignedIn.addActionListener(e -> {
            try {
                if (staySignedIn.isSelected()) {
                    controlLogin.handleStaySingedIn();
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        try {
            controlLogin.accountLoadSignUp();
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // get user field
    public static String getUserName() {
        return userField.getText();
    }

    // get pass Field - more secure implementation
    public static String getPassWord() {
        char[] passwordChars = passWordField.getPassword();
        String password = new String(passwordChars);
        // Clear the password array for security
        java.util.Arrays.fill(passwordChars, '0');
        return password;
    }

    public JPasswordField gettextFieldPass() {
        return this.passWordField;
    }

    // call error
    public void callError() {
        error1.setVisible(true);
        error2.setVisible(true);
    }

    public void setUserName(String user) {
        userField.setText(user);
    }

    public void setPass(String pass) {
        passWordField.setText(pass);
    }

    public void setKeepDefaultSignUp() {
        staySignedIn.setSelected(true);
    }

    public JButton getSeeingButton() {
        return this.seeingPassbutton;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        staySignedIn = new javax.swing.JCheckBox();
        seeingPassbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passWordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        forgotPass = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(623, 277));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 2, 24)); // NOI18N
        jLabel1.setText("Welcome Back!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 160, -1));

        staySignedIn.setText("Stay signed in");
        jPanel1.add(staySignedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 100, 20));

        seeingPassbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/icons8-closed-eye-50.png"))); // NOI18N
        jPanel1.add(seeingPassbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 40, 30));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel2.setText("PassWord");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 60, -1));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel3.setText("User");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));
        jPanel1.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 220, 30));

        passWordField.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        passWordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(passWordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 220, 30));

        loginButton.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        loginButton.setText("Login");
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 220, 30));

        forgotPass.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        forgotPass.setText("Forgot password");
        jPanel1.add(forgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        registerLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        registerLabel.setText("Register");
        jPanel1.add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel5.setText("You have no account ? ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/icons8-walmart-app-50.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 50, 50));

        error1.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("User invalid");
        jPanel1.add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        error2.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("password invalid");
        jPanel1.add(error2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/backLogin.jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 400));

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

    private void passWordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passWordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passWordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new loginForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel forgotPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private static javax.swing.JPasswordField passWordField;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JButton seeingPassbutton;
    private javax.swing.JCheckBox staySignedIn;
    private static javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
