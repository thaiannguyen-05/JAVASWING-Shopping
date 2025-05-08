package Controller;

import View.registerForm;
import Model.Account;
import View.loginForm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class controllerRegister {

    private registerForm registerForm;
    private Account account;

    public controllerRegister(registerForm registerForm) {
        this.registerForm = registerForm;
        account = new Account();
    }

    public void handleRegisterButton() {
        
        String name = registerForm.getFullname();
        String address = registerForm.getAddress();
        String gender = registerForm.getGender();
        String email = registerForm.getEmail();
        String dob = registerForm.getdob();
        String position = registerForm.getPosition();
        String user = registerForm.getUser();
        String pass = registerForm.getPass();
        
        System.out.println(position);
        
        if (position.equalsIgnoreCase("Admin")) {
            try {
                String sql = "INSERT INTO user (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, name);
                pr.setString(2, address);
                pr.setString(3, gender);
                pr.setString(4, email);
                pr.setString(5, dob);
                pr.setString(6, position);
                pr.setString(7, user);
                pr.setString(8, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }

        if (position.equalsIgnoreCase("Customer")) {
            try {
                String sql = "INSERT INTO customer (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, name);
                pr.setString(2, address);
                pr.setString(3, gender);
                pr.setString(4, email);
                pr.setString(5, dob);
                pr.setString(6, position);
                pr.setString(7, user);
                pr.setString(8, pass);
                
                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }

        if (position.equalsIgnoreCase("Employee")) {
            try {
                String sql = "INSERT INTO employee (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, "employee");
                pr.setString(2, name);
                pr.setString(3, address);
                pr.setString(4, gender);
                pr.setString(5, email);
                pr.setString(6, dob);
                pr.setString(7, position);
                pr.setString(8, user);
                pr.setString(9, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }

        if (position.equalsIgnoreCase("Supplier")) {
            try {
                String sql = "INSERT INTO supplier (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, "supplier");
                pr.setString(2, name);
                pr.setString(3, address);
                pr.setString(4, gender);
                pr.setString(5, email);
                pr.setString(6, dob);
                pr.setString(7, position);
                pr.setString(8, user);
                pr.setString(9, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }

        if (position.equalsIgnoreCase("stock")) {
            try {
                String sql = "INSERT INTO stock (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, "stock");
                pr.setString(2, name);
                pr.setString(3, address);
                pr.setString(4, gender);
                pr.setString(5, email);
                pr.setString(6, dob);
                pr.setString(7, position);
                pr.setString(8, user);
                pr.setString(9, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }

        if (position.equalsIgnoreCase("report")) {
            try {
                String sql = "INSERT INTO ? (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, "report");
                pr.setString(2, name);
                pr.setString(3, address);
                pr.setString(4, gender);
                pr.setString(5, email);
                pr.setString(6, dob);
                pr.setString(7, position);
                pr.setString(8, user);
                pr.setString(9, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }

        if (position.equalsIgnoreCase("invoice")) {
            try {
                String sql = "INSERT INTO ? (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, "invoice");
                pr.setString(2, name);
                pr.setString(3, address);
                pr.setString(4, gender);
                pr.setString(5, email);
                pr.setString(6, dob);
                pr.setString(7, position);
                pr.setString(8, user);
                pr.setString(9, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }
            return;
        }
        try {
                String sql = "INSERT INTO user (Name,Address,Gender,Email,Dob,Position,UserName,PassWord) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pr = db.mycon().prepareStatement(sql);
                pr.setString(1, name);
                pr.setString(2, address);
                pr.setString(3, gender);
                pr.setString(4, email);
                pr.setString(5, dob);
                pr.setString(6, position);
                pr.setString(7, user);
                pr.setString(8, pass);

                pr.executeUpdate();
                registerForm.setIfromLabel("Register successfully");
            } catch (SQLException e) {
                registerForm.setIfromLabel("Register failed");
            }

    }

    public void handleBackLogin() throws SQLException {
        loginForm loginForm = null;

        if (loginForm == null) {
            loginForm = new loginForm();
            loginForm.setVisible(true);
            registerForm.setVisible(false);
        }
    }

}
