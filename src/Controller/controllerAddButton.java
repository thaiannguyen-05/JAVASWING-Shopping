package Controller;

import View.add;
import Model.Customer;
import Model.Employee;
import View.homeAdminForm;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class controllerAddButton {

    private add addForm;// khoi tao view
    private Customer customer;// khoi tao doi tuong
    private Employee employee;// khoi tao doi tuong
    private controllerCustomerView controllerCustomerView;// khoi tao controllerCus de lay tbLoad
    private controllerEmployeeView controllerEMployee;
    private controllerSupplier controllerSupplier;
    private homeAdminForm homeView;
    private String budget = "0";

    public controllerAddButton(add addForm) throws SQLException {
        this.addForm = addForm;
        this.customer = new Customer();
        homeView = new homeAdminForm();
    }

    public controllerAddButton(add addForm, controllerCustomerView controllerCustomerView) throws SQLException {
        this.addForm = addForm;
        this.customer = new Customer();
        this.controllerCustomerView = controllerCustomerView;
    }

    public controllerAddButton(add addForm, controllerEmployeeView controllerEMployee) throws SQLException {
        this.addForm = addForm;
        this.employee = new Employee();
        this.controllerEMployee = controllerEMployee;
    }

    // set tham chieu controllerCustomerView len controllerAddButton
    public void setControllerCustomerView(controllerCustomerView controllerCustomerView) {
        this.controllerCustomerView = controllerCustomerView;
    }

    public void setControllerEmployeeView(controllerEmployeeView controllerEMployee) {
        this.controllerEMployee = controllerEMployee;
    }

    public void setControllerSupplierView(controllerSupplier controllerSupplier) {
        this.controllerSupplier = controllerSupplier;

    }

    public void handleAddButton() {
        String whichChoose = homeView.getWhichChoose();
        String sql = "";
        String tableName = "";
        switch (whichChoose) {
            case "1" -> {
                sql = "INSERT INTO customer (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                tableName = "customer";
            }
            case "2" -> {
                sql = "INSERT INTO employee (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                tableName = "employee";
            }
            case "3" -> {
                sql = "INSERT INTO supplier (Name,Address,Gender,Email,Dob,Position,UserName,PassWord,Budget) VALUES (?,?,?,?,?,?,?,?,?)";
                tableName = "supplier";
                 budget = this.budget;
                addForm.informAddBudget().setVisible(true);
                addForm.addBudget().setVisible(true);
            }
        }

        String name = addForm.getFullName();
        String dob = addForm.getDob();
        String email = addForm.getEmail();
        String address = addForm.getAddress();
        String user = addForm.getUser();
        String pass = addForm.getPass();
        String gender = addForm.getGender();

        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, name);
            pr.setString(2, address);
            pr.setString(3, gender);
            pr.setString(4, email);
            pr.setString(5, dob);
            pr.setString(6, tableName);
            pr.setString(7, user);
            pr.setString(8, pass);
            
            if(whichChoose.equals("3")){
                pr.setString(9, budget);
            }
            
            pr.executeUpdate();
            addForm.inform("Add Successfully");
            
            switch (whichChoose) {
                case "1" -> {
                    if (controllerCustomerView != null) {
                        controllerCustomerView.tableLoading();
                    }
                }
                case "2" -> {
                    if (controllerEMployee != null) {
                        controllerEMployee.tableLoading();
                    }
                }
                case "3" -> {
                    if (controllerSupplier != null) {
                        controllerSupplier.tableLoading();
                        controllerSupplier.calTotalBudget();
                    }
                }
            }
        } catch (SQLException e) {
            addForm.inform("Add failed");
            e.printStackTrace();
        }
    }

    public void handleAddBudget() {
        String x = JOptionPane.showInputDialog("Enter budget Supplier : ");
        if (x != null && !x.isEmpty()) {
            this.budget = x;
        } else {
            this.budget = "0";
        }
    }
}
