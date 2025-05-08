package View;

import Controller.controllerHomeEmployee;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class homeEmployee extends javax.swing.JFrame {

    private controllerHomeEmployee controllerHomeEmployee;
    public static int countShift = 0;
    public homeEmployee() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);

        // Set background color for main panel
        jPanel1.setBackground(new java.awt.Color(240, 248, 255)); // Light blue

        // Set border for main panel
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
            "Employee Home", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 1, 16),
            new java.awt.Color(70, 130, 180)));

        // Set background and border for totalPanel
        totalPanel.setBackground(new java.awt.Color(245, 255, 250)); // Very light green
        totalPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2));

        // Set background and foreground for registerButton
        registerButton.setBackground(new java.awt.Color(65, 105, 225)); // Royal Blue
        registerButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        // Set font and color for labels
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32));
        jLabel4.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel6.setForeground(new java.awt.Color(70, 130, 180)); // Steel Blue

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel5.setForeground(new java.awt.Color(70, 130, 180));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel2.setForeground(new java.awt.Color(70, 130, 180));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel3.setForeground(new java.awt.Color(70, 130, 180));

        totalShift.setForeground(new java.awt.Color(0, 0, 128)); // Navy
        totalSalary.setForeground(new java.awt.Color(220, 20, 60)); // Crimson

        registerButton.setBackground(new Color(173, 216, 230));
        registerButton.setForeground(Color.BLACK);
        totalShift.setText(String.valueOf(countShift));
        employeeUser.setText(loginForm.username);
        
        controllerHomeEmployee = new controllerHomeEmployee(this);

        registerButton.addActionListener(e -> {
            try {
                controllerHomeEmployee.handleRegister();
            } catch (SQLException ex) {
                Logger.getLogger(homeEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public JPanel getTotalPanel() {
        return this.totalPanel;
    }
    
    public void setTextTotalShift(String x){
        this.totalShift.setText(x);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        employeeUser = new javax.swing.JLabel();
        nameUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalShift = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        totalPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalSalary = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Employee :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        employeeUser.setText(" ");
        jPanel1.add(employeeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 61, -1));

        nameUser.setText(" ");
        jPanel1.add(nameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 7, 114, -1));

        jLabel2.setText("TotalShift :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        totalShift.setText(" ");
        jPanel1.add(totalShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 61, -1));

        registerButton.setText("ResgisterShift");
        jPanel1.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 109, -1, -1));

        totalPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Javanese Text", 2, 12)); // NOI18N
        jLabel6.setText("Welcome!");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 2, 36)); // NOI18N
        jLabel4.setText("EMPLOYEE ZONE");

        javax.swing.GroupLayout totalPanelLayout = new javax.swing.GroupLayout(totalPanel);
        totalPanel.setLayout(totalPanelLayout);
        totalPanelLayout.setHorizontalGroup(
            totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPanelLayout.createSequentialGroup()
                .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalPanelLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(totalPanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel4)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        totalPanelLayout.setVerticalGroup(
            totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(totalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 10, -1, 413));

        jLabel3.setText("TotalSalary :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 75, -1, -1));

        totalSalary.setText(" ");
        jPanel1.add(totalSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 75, 61, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/back.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 430));

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
            java.util.logging.Logger.getLogger(homeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new homeEmployee().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(homeEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel employeeUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameUser;
    private javax.swing.JButton registerButton;
    private javax.swing.JPanel totalPanel;
    private javax.swing.JLabel totalSalary;
    private javax.swing.JLabel totalShift;
    // End of variables declaration//GEN-END:variables
}
