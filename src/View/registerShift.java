package View;

import Controller.controllerRegisterShift;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerShift extends javax.swing.JPanel {

    private controllerRegisterShift controllerRegisterShift;

    public registerShift() throws SQLException {
        initComponents();

        // Set background color for main panel
        jPanel1.setBackground(new java.awt.Color(240, 248, 255)); // Light blue
        jPanel2.setBackground(new java.awt.Color(245, 255, 250)); // Very light green

        // Set border for main panel
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
            "Register Shift", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 1, 16),
            new java.awt.Color(70, 130, 180)));

        // Set background and foreground for buttons
        saveButton.setBackground(new java.awt.Color(65, 105, 225)); // Royal Blue
        saveButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        deleteButton.setBackground(new java.awt.Color(220, 20, 60)); // Crimson
        deleteButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        // Set font and color for label
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabel1.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green

        // Set selection color for table
        shiftTable.setSelectionBackground(new java.awt.Color(173, 216, 230)); // Light Blue
        shiftTable.setSelectionForeground(new java.awt.Color(0, 0, 0)); // Black
        shiftTable.setGridColor(new java.awt.Color(70, 130, 180)); // Steel Blue

        controllerRegisterShift = new controllerRegisterShift(this);

        controllerRegisterShift.callData(shiftTable);

        saveButton.addActionListener(e -> {
            try {
                controllerRegisterShift.handleChooseShift(shiftTable, chooseShift);
            } catch (SQLException ex) {
                Logger.getLogger(registerShift.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                controllerRegisterShift.handleDeleteShift(shiftTable);
            } catch (SQLException ex) {
                Logger.getLogger(registerShift.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chooseShift = new javax.swing.JComboBox<>();
        saveButton = new javax.swing.JToggleButton();
        deleteButton = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shiftTable = new javax.swing.JTable();

        jLabel1.setText("Choose Shift :");

        chooseShift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning Shift(6 : 00 - 14 : 00)", "Afternoon Shift(14 : 00 - 22 : 00)", "Evening Shift(22 : 00 - 6 : 00)", "Retire" }));

        buttonGroup1.add(saveButton);
        saveButton.setText("Save Shift");

        buttonGroup1.add(deleteButton);
        deleteButton.setText("Delete Shift've choose");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        shiftTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DateOfWeek", "Date", "Shift"
            }
        ));
        jScrollPane1.setViewportView(shiftTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(chooseShift, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(saveButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> chooseShift;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton saveButton;
    private javax.swing.JTable shiftTable;
    // End of variables declaration//GEN-END:variables
}
