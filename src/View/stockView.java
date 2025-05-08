package View;

import Controller.controllerStockView;
import Model.Product;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class stockView extends javax.swing.JPanel {

    private controllerStockView controllerStock;
    private Product product;

    public stockView() throws SQLException {
        initComponents();

        JPanel productsContainer = new JPanel();
        productsContainer.setLayout(new BoxLayout(productsContainer, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(productsContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 500));

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

        refreshButton.setBackground(new java.awt.Color(46, 139, 87)); // Sea Green
        refreshButton.setForeground(new java.awt.Color(255, 255, 255)); // White

        // Set font and selection color for table
        stockTable.setSelectionBackground(new java.awt.Color(173, 216, 230)); // Light Blue
        stockTable.setSelectionForeground(new java.awt.Color(0, 0, 0)); // Black
        stockTable.setGridColor(new java.awt.Color(70, 130, 180)); // Steel Blue

        // Set border for main panel
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
                "Stock Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 14),
                new java.awt.Color(70, 130, 180)));

        // Set font and color for label
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel1.setForeground(new java.awt.Color(46, 139, 87)); // Sea Green

        // Set color for totalQuantity label
        totalQuantity.setForeground(new java.awt.Color(220, 20, 60)); // Crimson

        controllerStock = new controllerStockView(this);

        // handle AddButton
        addButton.addActionListener(e
                -> {
            controllerStock.handleAddGoods();
            try {
                controllerStock.tableLoading();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        // Thêm dòng này vào method constructor của bạn sau khi setup model cho bảng
        stockTable.setRowHeight(100); // Điều chỉnh chiều cao hàng phù hợp với kích thước hình ảnh
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "pID", "BarCode", "NameProduct", "CostPrice", "Quantity", "BrandName", "Image"
                }
        ) {
            Class[] types = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class, javax.swing.ImageIcon.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        // Thêm sau khi tạo model trong constructor
        stockTable.getColumnModel().getColumn(6).setPreferredWidth(150); // Điều chỉnh chiều rộng cột hình ảnh
        stockTable.setRowHeight(100);
        // handle updateButton
        updateButton.addActionListener(e -> {
            try {
                controllerStock.handleUpdateButton();
            } catch (SQLException ex) {
                Logger.getLogger(stockView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // handle findButton
        findButton.addActionListener(e -> controllerStock.handleFindButton());

        // handle deleteButton
        deleteButton.addActionListener(e -> {
            try {
                controllerStock.handleDeleteButton();
            } catch (SQLException ex) {
                Logger.getLogger(stockView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // handle refreshButton
        refreshButton.addActionListener(e -> {
            try {
                controllerStock.handleRefresh();
            } catch (SQLException ex) {
                Logger.getLogger(stockView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        controllerStock.tableLoading();
    }

    public JLabel getTotalQuantity() {
        return this.totalQuantity;
    }

    public void setTextTotalQuantity(String x) {
        totalQuantity.setText(x);
    }

    public JTable getTable() {
        return stockTable;
    }

    public int getRow() {
        return this.stockTable.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelStock = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        addButton = new javax.swing.JToggleButton();
        updateButton = new javax.swing.JToggleButton();
        findButton = new javax.swing.JToggleButton();
        deleteButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        totalQuantity = new javax.swing.JLabel();
        refreshButton = new javax.swing.JToggleButton();

        panelStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pID", "BarCode", "NameProduct", "CostPrice", "Quantity", "BrandName", "Image"
            }
        ));
        jScrollPane1.setViewportView(stockTable);

        javax.swing.GroupLayout panelStockLayout = new javax.swing.GroupLayout(panelStock);
        panelStock.setLayout(panelStockLayout);
        panelStockLayout.setHorizontalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );
        panelStockLayout.setVerticalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        buttonGroup1.add(addButton);
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/save.png"))); // NOI18N
        addButton.setText("Add");

        buttonGroup1.add(updateButton);
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/up.png"))); // NOI18N
        updateButton.setText("Update");

        buttonGroup1.add(findButton);
        findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/search x30.png"))); // NOI18N
        findButton.setText("Find");

        buttonGroup1.add(deleteButton);
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/delete.png"))); // NOI18N
        deleteButton.setText("Delete");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setText("Total Quantity : ");

        totalQuantity.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        totalQuantity.setText("0");

        buttonGroup1.add(refreshButton);
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/update.png"))); // NOI18N
        refreshButton.setText("Refresh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(addButton)
                        .addGap(28, 28, 28)
                        .addComponent(updateButton)
                        .addGap(26, 26, 26)
                        .addComponent(findButton)
                        .addGap(29, 29, 29)
                        .addComponent(deleteButton)
                        .addGap(27, 27, 27)
                        .addComponent(refreshButton)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalQuantity))
                .addGap(59, 59, 59))
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
    private javax.swing.JToggleButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JToggleButton findButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelStock;
    private javax.swing.JToggleButton refreshButton;
    private javax.swing.JTable stockTable;
    private javax.swing.JLabel totalQuantity;
    private javax.swing.JToggleButton updateButton;
    // End of variables declaration//GEN-END:variables
}
