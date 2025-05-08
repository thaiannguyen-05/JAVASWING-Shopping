package View;

import Controller.controllerSupplier;
import Model.Supplier;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;

public class supplierView extends javax.swing.JPanel {

    private controllerSupplier controllerSupplier;//khoi tao controller
    private Supplier supplier;// khoi tao customer

    public supplierView() throws SQLException {
        initComponents();
        controllerSupplier = new controllerSupplier(this);

        // Set background color for main panel
        jPanel1.setBackground(new java.awt.Color(240, 248, 255)); // Light blue

        // Set background and foreground for buttons
        addButton.setBackground(new java.awt.Color(65, 105, 225)); // Royal Blue
        addButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        updateButton.setBackground(new java.awt.Color(100, 149, 237)); // Cornflower Blue
        updateButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        findButton.setBackground(new java.awt.Color(70, 130, 180)); // Steel Blue
        findButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        deleteButton.setBackground(new java.awt.Color(220, 20, 60)); // Crimson
        deleteButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        // Set font and selection color for table
        supplierTable.setSelectionBackground(new java.awt.Color(173, 216, 230)); // Light Blue
        supplierTable.setSelectionForeground(new java.awt.Color(0, 0, 0)); // Black
        supplierTable.setGridColor(new java.awt.Color(70, 130, 180)); // Steel Blue

        // Set border for main panel
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
                "Supplier Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 14),
                new java.awt.Color(70, 130, 180)));

        // Set font and color for label
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel1.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel2.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green

        // Set background for text field
        userFind.setBackground(new java.awt.Color(245, 245, 255)); // Very light blue
        userFind.setForeground(new java.awt.Color(0, 0, 128)); // Navy

        // Set color for totalBudget label
        totalBudget.setForeground(new java.awt.Color(220, 20, 60)); // Crimson

        // handle addButton
        addButton.addActionListener(e -> {
            try {
                controllerSupplier.handleAddButton();
            } catch (SQLException ex) {
                Logger.getLogger(supplierView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // handle UpdateButton
        updateButton.addActionListener(e -> {
            try {
                controllerSupplier.handleUpdateButton();
            } catch (SQLException ex) {
                Logger.getLogger(supplierView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //handle FindButton
        findButton.addActionListener(e -> {
            try {
                findForm findForm = new findForm(this);
                controllerSupplier.handleFindButton();
            } catch (SQLException ex) {
                Logger.getLogger(supplierView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // handle delete 
        deleteButton.addActionListener(e -> {
            try {
                controllerSupplier.handleDeleteButton();
            } catch (SQLException ex) {
                Logger.getLogger(supplierView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //table load
        supplier = new Supplier();
        userFind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    controllerSupplier.handleKeyrelease();
                } catch (SQLException ex) {
                    Logger.getLogger(supplierView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        controllerSupplier.tableLoading();
        controllerSupplier.calTotalBudget();
    }

// get table
    public JTable getTable() {
        return this.supplierTable;
    }

    // get select row
    public int getSelectRow() {
        return supplierTable.getSelectedRow();
    }

    public String getNameFind() {
        return userFind.getText();
    }

    public int getRowCount() {
        return supplierTable.getRowCount();
    }

    public JLabel getBudgetTotal() {
        return this.totalBudget;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        findButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        totalBudget = new javax.swing.JLabel();

        supplierTable.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sID", "Name", "Address", "Gender", "EMail", "Dob", "Username", "PassWord", "Phone", "Budget"
            }
        ));
        jScrollPane1.setViewportView(supplierTable);

        addButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/save.png"))); // NOI18N
        addButton.setText("Add");

        updateButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/up.png"))); // NOI18N
        updateButton.setText("Update");

        findButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/search x30.png"))); // NOI18N
        findButton.setText("Find");

        deleteButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/remove.png"))); // NOI18N
        deleteButton.setText("Delete");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setText("Name User : ");

        userFind.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setText("Total Budget : ");

        totalBudget.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        totalBudget.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userFind, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(totalBudget))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(findButton)
                    .addComponent(updateButton)
                    .addComponent(addButton))
                .addContainerGap(49, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable supplierTable;
    private javax.swing.JLabel totalBudget;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField userFind;
    // End of variables declaration//GEN-END:variables
}
