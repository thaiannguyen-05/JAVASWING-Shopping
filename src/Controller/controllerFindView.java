package Controller;

import View.findForm;
import Model.Customer;
import Model.Employee;
import Model.Product;
import Model.Supplier;
import View.customerView;
import View.employee;
import View.homeAdminForm;
import View.stockView;
import View.supplierView;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class controllerFindView {

    private findForm findForm;// khoi tao form
    private Customer customer;// khoi tao customer
    private Employee employee;// khoi tao employee
    private Supplier supplier;
    private Product product;
    private customerView customerView;
    private employee employeeView;
    private supplierView supplierView;
    private stockView stockView;
    private homeAdminForm homeAdmin;

    public controllerFindView(findForm findForm) throws SQLException {
        this.findForm = findForm;
        this.customer = new Customer();
        this.employee = new Employee();
        this.supplier = new Supplier();
        this.product = new Product();
        this.stockView = new stockView();
        homeAdmin = new homeAdminForm();
    }

    public void setCustomerView(customerView customerView) {
        this.customerView = customerView;
    }

    public void setEmployeeView(employee employeeView) {
        this.employeeView = employeeView;
    }

    public void setSupplierView(supplierView supplierView) {
        this.supplierView = supplierView;
    }

    public void setStockView(stockView stockView){
        this.stockView = stockView;
    }
    
    // handleFindButton for customer
    public void handleFindButton() throws SQLException {

        Customer customerReturn = customer.returnUser(findForm.getNameSearch());

        if (customerReturn != null) {
            try {
                DefaultTableModel dt = (DefaultTableModel) customerView.getTable().getModel();
                dt.setRowCount(0); // clear bảng cũ

                Object[] rowData = {
                    customerReturn.getId(),
                    customerReturn.getName(),
                    customerReturn.getAddress(),
                    customerReturn.getGender(),
                    customerReturn.getDob(),
                    customerReturn.getEmail(),
                    customerReturn.getUserName(),
                    customerReturn.getPassWord(),
                    customerReturn.getPhone(),
                    customerReturn.getBudget()
                };

                dt.addRow(rowData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Name invalid");
        }
    }

    // handleFindButton for employee
    public void handleFindButtonEmp() throws SQLException {
        Employee employeeReturn = employee.returnEmp(findForm.getNameSearch());

        if (employeeReturn != null) {
            try {
                DefaultTableModel dt = (DefaultTableModel) employeeView.getTable().getModel();
                dt.setRowCount(0); // clear bảng cũ

                Object[] rowData = {
                    employeeReturn.getId(),
                    employeeReturn.getName(),
                    employeeReturn.getAddress(),
                    employeeReturn.getGender(),
                    employeeReturn.getEmail(),
                    employeeReturn.getDob(),
                    employeeReturn.getUserName(),
                    employeeReturn.getPassWord(),
                    employeeReturn.getPhone(),
                    employeeReturn.getSalary(),
                    employeeReturn.getTotalShip()
                };

                dt.addRow(rowData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Name invalid");
        }
    }

    public void handleFindButtonSupplier() throws SQLException {
        Supplier supplierReturn = supplier.returnSupplier(findForm.getNameSearch());

        if (supplierReturn != null) {
            try {
                DefaultTableModel dt = (DefaultTableModel) supplierView.getTable().getModel();
                dt.setRowCount(0); // clear bảng cũ

                Object[] rowData = {
                    supplierReturn.getId(),
                    supplierReturn.getName(),
                    supplierReturn.getAddress(),
                    supplierReturn.getGender(),
                    supplierReturn.getEmail(),
                    supplierReturn.getDob(),
                    supplierReturn.getUserName(),
                    supplierReturn.getPassWord(),
                    supplierReturn.getPhone(),
                    supplierReturn.getBudget()
                };

                dt.addRow(rowData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Name invalid");
        }
    }
    
    public void handleFindProduct() throws SQLException {
        String sql = "SELECT * FROM product WHERE NameProduct = ?";
        String name = findForm.getNameSearch();
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            
            DefaultTableModel dt = (DefaultTableModel) stockView.getTable().getModel();
            dt.setRowCount(0); // Clear table

            while (rs.next()) {
                Vector<Object> v = new Vector<>();

                v.add(rs.getString("pID"));
                v.add(rs.getString("BarCode"));
                v.add(rs.getString("NameProduct"));
                v.add(rs.getString("CostPrice"));
                v.add(rs.getString("Quantity"));
                v.add(rs.getString("BrandName"));
                
                // Tạo ImageIcon từ đường dẫn ảnh
                String imgPath = rs.getString("pathImg");
                ImageIcon icon = new ImageIcon(imgPath);

                // Resize ảnh nếu cần
                Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);

                v.add(icon); // Thêm ảnh

                dt.addRow(v);
            }

            // Chiều cao để ảnh không bị cắt
            stockView.getTable().setRowHeight(60);
        }
    }
            
}
