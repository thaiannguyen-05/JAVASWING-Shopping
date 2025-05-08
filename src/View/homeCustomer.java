package View;

import Controller.controllerHomeCustomer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class homeCustomer extends javax.swing.JFrame {

    private controllerHomeCustomer controllerHomeCustomer;

    public homeCustomer() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\icons8-logout-25.png");
        backLogin.setIcon(img);
        imgProduct.setVisible(true);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        // Main panel background color
        jPanel1.setBackground(new java.awt.Color(240, 248, 255)); // Light blue background

        // Style for filter panel
        filterPanel.setBackground(new java.awt.Color(230, 240, 250));
        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 130, 180), 2),
                "Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 12),
                new java.awt.Color(70, 130, 180)));

        // Style for product information panel
        jPanel6.setBackground(new java.awt.Color(245, 245, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 149, 237), 2),
                "Product Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 12),
                new java.awt.Color(100, 149, 237)));

        // Style for invoice panel
        jPanel7.setBackground(new java.awt.Color(245, 255, 250));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2),
                "Invoice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 12),
                new java.awt.Color(46, 139, 87)));

        // Style for invoice details panel
        jPanel8.setBackground(new java.awt.Color(240, 255, 240));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87)));

        // Style for product list panel
        jPanel9.setBackground(new java.awt.Color(240, 255, 240));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 139, 87), 2),
                "List of Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 1, 12),
                new java.awt.Color(46, 139, 87)));

        // Style for buttons
        findButton.setBackground(new java.awt.Color(70, 130, 180));
        findButton.setForeground(new java.awt.Color(255, 255, 255));
        findButton.setFont(new java.awt.Font("Segoe UI", 1, 12));

        addPurcharse.setBackground(new java.awt.Color(65, 105, 225));
        addPurcharse.setForeground(new java.awt.Color(255, 255, 255));
        addPurcharse.setFont(new java.awt.Font("Segoe UI", 1, 12));

        addQuanButton.setBackground(new java.awt.Color(152, 251, 152));
        addQuanButton.setForeground(new java.awt.Color(0, 0, 0));

        subButton.setBackground(new java.awt.Color(255, 240, 245));
        subButton.setForeground(new java.awt.Color(0, 0, 0));

        getAllProduct.setBackground(new java.awt.Color(100, 149, 237));
        getAllProduct.setForeground(new java.awt.Color(255, 255, 255));
        getAllProduct.setFont(new java.awt.Font("Segoe UI", 1, 12));

        purchaseButton.setBackground(new java.awt.Color(46, 139, 87));
        purchaseButton.setForeground(new java.awt.Color(255, 255, 255));
        purchaseButton.setFont(new java.awt.Font("Segoe UI", 1, 12));

        // Style for table
        productPurchaseTable.setSelectionBackground(new java.awt.Color(173, 216, 230));
        productPurchaseTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        productPurchaseTable.setGridColor(new java.awt.Color(70, 130, 180));

        informError.setVisible(false);

        dateInvoice.setText(formattedDate);

        controllerHomeCustomer = new controllerHomeCustomer(this);

        addQuanButton.setText("+");

        backLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    controllerHomeCustomer.handleBackLogin(backLogin);
                } catch (SQLException ex) {
                    Logger.getLogger(homeCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        controllerHomeCustomer.loadInformCus();

        userName.setText(loginForm.username);

        nameCus.setText(loginForm.username);
        controllerHomeCustomer.loadingData();

        // Trong homeCustomer.java, đảm bảo findButton được khởi tạo đúng cách
        findButton.addActionListener(e -> {
            try {
                System.out.println("Find button clicked");  // Thêm debug log
                String brand = brandName.getSelectedItem().toString();
                String type = typeProduct.getSelectedItem().toString();
                String name = nameProduct.getText();
                boolean hasDiscount = haveDiscount.isSelected();

                controllerHomeCustomer.setDataProductSearch(brand, type, name, hasDiscount);
            } catch (SQLException ex) {
                System.err.println("Lỗi SQL: " + ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm sản phẩm: " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("Lỗi chung: " + ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
            }
        });

        addQuanButton.addActionListener(e -> controllerHomeCustomer.handleAddQuan(quantityPurchase, quantityChoose.getText()));
        subButton.addActionListener(e -> controllerHomeCustomer.handleSubButton(quantityPurchase, quantityChoose.getText()));

        getAllProduct.addActionListener(e -> {
            try {
                controllerHomeCustomer.handleGetAllProduct(this);
            } catch (SQLException ex) {
                Logger.getLogger(homeCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        DefaultTableModel dt = (DefaultTableModel) productPurchaseTable.getModel();
        dt.setRowCount(0);

        addPurcharse.addActionListener(e -> {
            try {
                controllerHomeCustomer.handleAddPurchase(dt);
            } catch (SQLException ex) {
                Logger.getLogger(homeCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        purchaseButton.addActionListener(e -> {
            try {
                controllerHomeCustomer.handlePurchaseButton();
            } catch (SQLException ex) {
                Logger.getLogger(homeCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void setCodeInvoice(String x) {
        codeInvoice.setText(x);
    }

    public JLabel getInformError() {
        return this.informError;
    }

    public JComboBox getComboBrand() {
        return this.brandName;
    }

    public JComboBox getComboType() {
        return this.typeProduct;
    }

    public JComboBox getListEmp() {
        return this.EmpList;
    }

    public JLabel getImgLabel() {
        return this.imgProduct;
    }

    public void setPid(String x) {
        pID.setText(x);
    }

    public void setNamePro(String x) {
        nameProductChoose.setText(x);
    }

    public void setBarcode(String x) {
        barcodeChoose.setText(x);
    }

    public void setPrice(String x) {
        priceChoose.setText(x);
    }

    public void setQuan(String x) {
        quantityChoose.setText(x);
    }

    public void setBrandName(String x) {
        brandChoose.setText(x);
    }

    public void setNameCusInvoice(String x) {
        nameCus.setText(x);
    }

    public String getPidSelect() {
        return this.pID.getText();
    }

    public String getNameSelect() {
        return this.nameProductChoose.getText();
    }

    public String getPriceSelect() {
        return this.priceChoose.getText();
    }

    public String getQuanSelect() {
        return this.quantityPurchase.getText();
    }

    public void idUserSet(String x) {
        idUser.setText(x);
    }

    public void budgetSet(String x) {
        budget.setText(x);
    }

    public void setTotalPay(String x) {
        totalPay.setText(x);
    }

    public void setDiscount(String x) {
        discount.setText(x);
    }

    public String getTotalPay() {
        return this.totalPay.getText();
    }

    public String getDiscount() {
        return discount.getText();
    }

    public String getBudget() {
        return budget.getText();
    }

    public String getQuanPur() {
        return quantityPurchase.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        filterPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        brandName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        typeProduct = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        haveDiscount = new javax.swing.JRadioButton();
        nameProduct = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pID = new javax.swing.JLabel();
        imgProduct = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nameProductChoose = new javax.swing.JLabel();
        barcodeChoose = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        priceChoose = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        quantityChoose = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        brandChoose = new javax.swing.JLabel();
        addPurcharse = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        addQuanButton = new javax.swing.JButton();
        informError = new javax.swing.JLabel();
        subButton = new javax.swing.JButton();
        quantityPurchase = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        codeInvoice = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        dateInvoice = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        EmpList = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        nameCus = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productPurchaseTable = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        totalPay = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        purchaseButton = new javax.swing.JButton();
        getAllProduct = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backLogin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        budget = new javax.swing.JLabel();

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));

        jLabel9.setText("Brand :");

        brandName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EllBrand", "đẹp trai brand", "xấu trai brand", "saiboyBrand", "áo nắng Việt Nam" }));

        jLabel10.setText("Type :");

        typeProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trousers", "T-Shirt", "Jacket" }));

        jLabel11.setText("Name Product :");

        haveDiscount.setText("Have Discount");

        findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/search x30.png"))); // NOI18N
        findButton.setText("Find");

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameProduct)
                    .addComponent(typeProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brandName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findButton)
                    .addComponent(haveDiscount))
                .addGap(52, 52, 52))
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(brandName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(typeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(haveDiscount))
                .addGap(18, 18, 18)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Information"));

        jLabel12.setText("pID :");

        pID.setForeground(new java.awt.Color(51, 51, 51));
        pID.setText(" ");

        imgProduct.setText(" ");

        jLabel14.setText("Name :");

        nameProductChoose.setText(" ");

        barcodeChoose.setText(" ");

        jLabel17.setText("Barcode :");

        jLabel18.setText("Price :");

        priceChoose.setText(" ");

        jLabel20.setText("Quantity : ");

        quantityChoose.setText(" ");

        jLabel21.setText("Brand :");

        brandChoose.setText(" ");

        addPurcharse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/icons8-shopping-cart-25.png"))); // NOI18N
        addPurcharse.setText("Add to cart");

        jLabel23.setText("Quantity");

        addQuanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/icons8-calculator-64.png"))); // NOI18N
        addQuanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuanButtonActionPerformed(evt);
            }
        });

        informError.setForeground(new java.awt.Color(255, 51, 51));
        informError.setText("Inventory Quantity is not enough");

        subButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/sub.png"))); // NOI18N
        subButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subButtonActionPerformed(evt);
            }
        });

        quantityPurchase.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameProductChoose, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(11, 11, 11)
                                .addComponent(barcodeChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pID, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addPurcharse, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informError))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(brandChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(subButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addQuanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(nameProductChoose))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(barcodeChoose))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(priceChoose))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(quantityChoose))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brandChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addQuanButton)
                            .addComponent(jLabel23)
                            .addComponent(subButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addComponent(informError)
                        .addGap(20, 20, 20)
                        .addComponent(addPurcharse, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice"));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Code :");

        jLabel16.setText("Date :");

        jLabel19.setText("Employee");

        jLabel22.setText("Name");

        nameCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(codeInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateInvoice))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameCus))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EmpList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(155, 155, 155)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(codeInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(dateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(nameCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmpList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(26, 26, 26))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Product"));

        productPurchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pID", "Name", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(productPurchaseTable);

        jLabel25.setText("TotalPay");

        totalPay.setText("0");

        jLabel26.setText("Discount");

        discount.setText("0");

        purchaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/save.png"))); // NOI18N
        purchaseButton.setText("Purchase");
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseButton)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(totalPay, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(discount)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(totalPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(purchaseButton)
                .addGap(165, 165, 165))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAllProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/icons8-product-25.png"))); // NOI18N
        getAllProduct.setText("All Product");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product/icons8-walmart-app-50.png"))); // NOI18N

        idUser.setText(" ");

        jLabel3.setText("ID :");

        userName.setText(" ");

        jLabel5.setText("User :");

        backLogin.setText(" ");

        jLabel6.setText("Budget : ");

        budget.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getAllProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)
                        .addComponent(backLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(userName)
                        .addComponent(jLabel3)
                        .addComponent(idUser)
                        .addComponent(jLabel6)
                        .addComponent(budget)
                        .addComponent(backLogin))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(getAllProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameCusActionPerformed

    private void addQuanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuanButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addQuanButtonActionPerformed

    private void subButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subButtonActionPerformed

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(homeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new homeCustomer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(homeCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EmpList;
    private javax.swing.JButton addPurcharse;
    private javax.swing.JButton addQuanButton;
    private javax.swing.JLabel backLogin;
    private javax.swing.JLabel barcodeChoose;
    private javax.swing.JLabel brandChoose;
    private javax.swing.JComboBox<String> brandName;
    private javax.swing.JLabel budget;
    private javax.swing.JTextField codeInvoice;
    private javax.swing.JTextField dateInvoice;
    private javax.swing.JTextField discount;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JButton findButton;
    private javax.swing.JButton getAllProduct;
    private javax.swing.JRadioButton haveDiscount;
    private javax.swing.JLabel idUser;
    private javax.swing.JLabel imgProduct;
    private javax.swing.JLabel informError;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameCus;
    private javax.swing.JTextField nameProduct;
    private javax.swing.JLabel nameProductChoose;
    private javax.swing.JLabel pID;
    private javax.swing.JLabel priceChoose;
    private javax.swing.JTable productPurchaseTable;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JLabel quantityChoose;
    private javax.swing.JLabel quantityPurchase;
    private javax.swing.JButton subButton;
    private javax.swing.JTextField totalPay;
    private javax.swing.JComboBox<String> typeProduct;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
