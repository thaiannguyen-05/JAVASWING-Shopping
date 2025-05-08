package Controller;

import Model.Customer;
import Model.Product;
import View.homeCustomer;
import View.loginForm;
import View.tableProductCus;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class controllerHomeCustomer {

    private homeCustomer homeCustomer;
    private Customer Customer;

    public controllerHomeCustomer(homeCustomer homeCustomer) {
        this.homeCustomer = homeCustomer;
        this.Customer = new Customer();
    }

    public void handleBackLogin(JLabel x) throws SQLException {
        homeCustomer.setVisible(false);
        new loginForm().setVisible(true);
    }

    public void loadInformCus() throws SQLException {
        Customer customerReutrn = Customer.returnUserByUserName(loginForm.username);
        homeCustomer.idUserSet(String.valueOf(customerReutrn.getId()));
        homeCustomer.budgetSet(customerReutrn.getBudget());
    }

    public void loadingData() throws SQLException {
        Vector NameEmp = new Vector();
        String sql2 = "SELECT * FROM employee";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql2)) {
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                NameEmp.add(rs.getString("Name"));
            }

            DefaultComboBoxModel com3 = new DefaultComboBoxModel(NameEmp);
            homeCustomer.getListEmp().setModel(com3);

        }
        homeCustomer.setCodeInvoice("INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());

    }

    public Product searchProduct(String brand, String type, String name) throws SQLException {
        String sql = "SELECT * FROM product WHERE brandName = ? AND typeOfClothes = ?";

        if (name != null && !name.trim().isEmpty()) {
            sql += " AND NameProduct LIKE ?";
        }

        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, brand);
            pr.setString(2, type);

            if (name != null && !name.trim().isEmpty()) {
                pr.setString(3, "%" + name + "%");
            }

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                System.out.println("Tìm thấy sản phẩm có ID: " + rs.getInt("pID"));
                return new Product(
                        rs.getInt("pID"),
                        rs.getString("barCode"),
                        rs.getString("NameProduct"),
                        rs.getString("sellPrice"),
                        rs.getString("quantity"),
                        rs.getString("brandName"),
                        rs.getString("pathImg")
                );
            } else {
                System.out.println("Không tìm thấy sản phẩm");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL trong searchProduct: " + e.getMessage());
            throw e;
        }
        return null;
    }

    public void setDataProductSearch(String brand, String type, String name, boolean choose) throws SQLException {
        System.out.println("Tìm kiếm sản phẩm với: Brand=" + brand + ", Type=" + type + ", Name=" + name + ", Discount=" + choose);

        Product productReturn = searchProduct(brand, type, name);

        if (productReturn == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm");
            return;
        }

        System.out.println("Đã tìm thấy sản phẩm");

        ImageIcon icon = new ImageIcon(productReturn.getPathImg());

        JLabel img = homeCustomer.getImgLabel();

        int width = img.getWidth();
        int height = img.getHeight();

        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        img.setIcon(new ImageIcon(scaledImage));

        homeCustomer.setPid(String.valueOf(productReturn.getpID()));
        homeCustomer.setNamePro(productReturn.getNameProduct());
        homeCustomer.setBarcode(productReturn.getBarCode());
        homeCustomer.setPrice(productReturn.getSellPrice());
        homeCustomer.setQuan(productReturn.getQuantity());
        homeCustomer.setBrandName(productReturn.getNameBrand());
    }
    
    public void handleAddQuan(JLabel x,String invenQuan){
        int i = Integer.parseInt(x.getText());
        ++i;
        x.setText(String.valueOf(i));
        if(Integer.parseInt(invenQuan) < i){
            homeCustomer.getInformError().setVisible(true);
        }
    }
    
    public void handleSubButton(JLabel x,String invenQuan){
        int i = Integer.parseInt(x.getText());
        --i;
        x.setText(String.valueOf(i));
        if(Integer.parseInt(invenQuan) < i){
            homeCustomer.getInformError().setVisible(true);
        }
    }
    
    public void handleGetAllProduct(homeCustomer homeCustomer) throws SQLException{
        tableProductCus tableProductCus = new tableProductCus(homeCustomer);
        tableProductCus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableProductCus.setVisible(true);
    }
    
    public void handleAddPurchase(DefaultTableModel dt) throws SQLException{
        Object data[] = {
            homeCustomer.getPidSelect(),
            homeCustomer.getNameSelect(),
            homeCustomer.getPriceSelect(),
            homeCustomer.getQuanSelect()
        };
        dt.addRow(data);
        int discount = 0;
        String sql = "SELECT * FROM product WHERE NameProduct  = ?";
        try(PreparedStatement pr = db.mycon().prepareStatement(sql)){
            pr.setString(1, homeCustomer.getNameSelect());
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                discount = Integer.parseInt(rs.getString("discount"));
            }
        }
        int quantity = Integer.parseInt(homeCustomer.getQuanPur());
        
        int TotalDiscount = quantity*(discount/10 * Integer.parseInt(homeCustomer.getPriceSelect()));
        Float priceAfterDis = quantity*(Float.parseFloat(homeCustomer.getPriceSelect()) - (TotalDiscount/10));
        
        homeCustomer.setDiscount(String.valueOf(Integer.parseInt(homeCustomer.getDiscount()) + TotalDiscount));
        homeCustomer.setTotalPay(String.valueOf(Integer.parseInt(homeCustomer.getTotalPay()) + priceAfterDis));
    }
    
    public void handlePurchaseButton() throws SQLException{
        Float budget = Float.parseFloat(homeCustomer.getBudget());
        float budgetRecently = budget - Float.parseFloat(homeCustomer.getTotalPay());
        homeCustomer.budgetSet(String.valueOf(budgetRecently));
        
        String sql = "UPDATE customer SET Budget = ? WHERE UserName = ?";
        try(PreparedStatement pr = db.mycon().prepareStatement(sql)){
            pr.setString(1, homeCustomer.getBudget());
            pr.setString(2,loginForm.username);
            int rowsAffected = pr.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        }
    }
}
