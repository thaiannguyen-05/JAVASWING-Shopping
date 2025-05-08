
package View;

import Controller.controllerChangePassword;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class changePassView extends javax.swing.JPanel {
    
    private controllerChangePassword controllerChangePass;// khoi tao doi pass
    
    public changePassView() {
        initComponents();
        setPreferredSize(new java.awt.Dimension(892, 400));
        controllerChangePass = new controllerChangePassword(this); // khoi tao controller pass

        // Thêm đoạn này để làm đẹp giao diện
        changePass.setBackground(new java.awt.Color(240, 248, 255)); // Light blue
        changePass.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
            "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 1, 14),
            new java.awt.Color(70, 130, 180)));

        oldPassField.setBackground(new java.awt.Color(255, 255, 240)); // Ivory
        oldPassField.setForeground(new java.awt.Color(0, 0, 128)); // Navy

        newPassField.setBackground(new java.awt.Color(255, 255, 240));
        newPassField.setForeground(new java.awt.Color(0, 0, 128));

        saveButton.setBackground(new java.awt.Color(65, 105, 225)); // Royal Blue
        saveButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel5.setForeground(new java.awt.Color(70, 130, 180));

        // add action saveButton
        saveButton.addActionListener(e-> {
            try {
                controllerChangePass.saveNewPassWord();
            } catch (SQLException ex) {
                Logger.getLogger(changePassView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    public String getOldPass(){
        return oldPassField.getText();
    }
    
    public String getNewPass(){
        return newPassField.getText();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changePass = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        oldPassField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        newPassField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel4.setText("My profile");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel5.setText("Manage information profile securely");

        jLabel6.setText("Password");

        oldPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPassFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("NewPass");

        newPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Save");

        javax.swing.GroupLayout changePassLayout = new javax.swing.GroupLayout(changePass);
        changePass.setLayout(changePassLayout);
        changePassLayout.setHorizontalGroup(
            changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePassLayout.createSequentialGroup()
                .addGroup(changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changePassLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(changePassLayout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(changePassLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(56, 56, 56)
                        .addGroup(changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oldPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        changePassLayout.setVerticalGroup(
            changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addGroup(changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassField)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(changePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassField)
                    .addComponent(jLabel8))
                .addGap(53, 53, 53)
                .addComponent(saveButton)
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void oldPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPassFieldActionPerformed

    private void newPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel changePass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField newPassField;
    private javax.swing.JTextField oldPassField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
