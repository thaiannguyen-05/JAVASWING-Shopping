package View;

import Controller.controllerEmployeeView;
import Model.Employee;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class employee extends javax.swing.JPanel {

    private controllerEmployeeView controllerEmployee;//khoi tao controller
    private Employee employee;// khoi tao customer
    //private PanelState currentPanelState;

    public employee() throws SQLException {
        initComponents();
        controllerEmployee = new controllerEmployeeView(this);

        // Thêm các dòng sau để tô màu cho giao diện
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
        employeeTable.setSelectionBackground(new java.awt.Color(173, 216, 230)); // Light Blue
        employeeTable.setSelectionForeground(new java.awt.Color(0, 0, 0)); // Black
        employeeTable.setGridColor(new java.awt.Color(70, 130, 180)); // Steel Blue

        // Set border for main panel
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
            "Employee Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 1, 14),
            new java.awt.Color(70, 130, 180)));

        // Set font and color for label
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel1.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green

        // Set background for text field
        userFind.setBackground(new java.awt.Color(245, 245, 255)); // Very light blue
        userFind.setForeground(new java.awt.Color(0, 0, 128)); // Navy
       // currentPanelState = EMPLOYEE;
        // handle addButton
        addButton.addActionListener(e -> {
            try {
                controllerEmployee.handleAddButton();
            } catch (SQLException ex) {
                Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            
        // handle UpdateButton
        updateButton.addActionListener(e -> {
            try {
                controllerEmployee.handleUpdateButton();
            } catch (SQLException ex) {
                Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //handle FindButton
        findButton.addActionListener(e -> {
            try {
                findForm findForm = new findForm(this);
                controllerEmployee.handleFindButton();
            } catch (SQLException ex) {
                Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        // handle delete 
        deleteButton.addActionListener(e -> {
            try {
                controllerEmployee.handleDeleteButton();
            } catch (SQLException ex) {
                Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //table load
        employee = new Employee();
        userFind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    controllerEmployee.handleKeyrelease();
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        controllerEmployee.tableLoading();
    }

// get table
    public JTable getTable() {
        return this.employeeTable;
    }

    // get select row
    public int getSelectRow() {
        return employeeTable.getSelectedRow();
    }

    public String getNameFind() {
        return userFind.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        findButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userFind = new javax.swing.JTextField();

        employeeTable.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "eID", "Name", "Address", "Gender", "EMail", "Dob", "Username", "PassWord", "Phone", "salary", "TotalShift"
            }
        ));
        jScrollPane1.setViewportView(employeeTable);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userFind, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(findButton)
                    .addComponent(updateButton)
                    .addComponent(addButton))
                .addContainerGap(41, Short.MAX_VALUE))
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
    private javax.swing.JTable employeeTable;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField userFind;
    // End of variables declaration//GEN-END:variables
}
