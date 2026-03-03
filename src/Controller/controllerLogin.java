package Controller;

import Model.Account;
import View.loginForm;
import View.registerForm;
import Controller.EmailSender;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import View.homeAdminForm;
import View.homeCustomer;
import View.homeEmployee;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class controllerLogin {

    private loginForm loginForm;// khoi tao view
    private Account account;// khoi tao model
    private EmailSender email; //khoi tao emailAIP
    private homeAdminForm homeAdmin; // khoi tao homeAdmin

    public controllerLogin(loginForm login) {
        this.loginForm = login;// truyen tham chieu view
        account = new Account();// khoi tao account moi
        //email = new EmailSender(); // khoi tao emailSender
    }

    // load user keeping stay login
    public void accountLoadSignUp() throws SQLException {
        Account accountKeepSign = account.getUserSignUp();

        if (accountKeepSign == null) {
            return;
        }

        loginForm.setUserName(accountKeepSign.getUserName());
        loginForm.setPass(accountKeepSign.getPassWord());
        loginForm.setKeepDefaultSignUp();
    }

    // handle buttonLogin 
    public boolean handleLoginButton() throws SQLException {
        String userName = loginForm.getUserName();
        String pass = loginForm.getPassWord();

        Account accountCheck = account.returnUser(userName, pass);

        String sqlResetCheckLogin = "UPDATE user SET CheckLogin = ?";
        PreparedStatement pr = db.mycon().prepareStatement(sqlResetCheckLogin);
        pr.setString(1, "0");
        pr.executeUpdate();

        if (accountCheck == null) {
           loginForm.callError();
        }

        if (accountCheck != null && accountCheck.getPosition().equalsIgnoreCase("admin")) {
            new homeAdminForm().setVisible(true);
            loginForm.setVisible(false);
            String sql = "UPDATE user SET CheckLogin = ? WHERE userName = ?";
            try (PreparedStatement pr1 = db.mycon().prepareStatement(sql)) {
                pr1.setString(1, "1");
                pr1.setString(2, userName);
                pr1.executeUpdate();
            }
            return true;
        }

        if (accountCheck != null && accountCheck.getPosition().equalsIgnoreCase("employee")) {
            new homeEmployee().setVisible(true);
            loginForm.setVisible(false);
            String sql = "UPDATE user SET CheckLogin = ? WHERE userName = ?";
            try (PreparedStatement pr1 = db.mycon().prepareStatement(sql)) {
                pr1.setString(1, "1");
                pr1.setString(2, userName);
                pr1.executeUpdate();
            }
            return true;
        }

        if (accountCheck != null && accountCheck.getPosition().equalsIgnoreCase("customer")) {
            new homeCustomer().setVisible(true);
            loginForm.setVisible(false);
            String sql = "UPDATE user SET CheckLogin = ? WHERE userName = ?";
            try (PreparedStatement pr1 = db.mycon().prepareStatement(sql)) {
                pr1.setString(1, "1");
                pr1.setString(2, userName);
                pr1.executeUpdate();
            }
            return true;
        }
        return false;
    }

    public void automaticallyHandleLoginButton(String userName) throws SQLException {

        String pass = account.getPassWhenAccountTrue(userName);
        if (!pass.equals("")) {
            loginForm.setPass(pass);
        }
        
    }

    public void handleRegisterClicked() {
        // call register view and turn off login form
        registerForm registerForm = new registerForm();
        registerForm.setVisible(true);
        loginForm.setVisible(false);
    }

    public void handleForgotPass() {
        String userName = loginForm.getUserName();

        if (userName.equals("")) {
            loginForm.callError();
            return;
        }
        String checkVailable = account.IsUserAvailable(userName);
        try {
            String emailText = "Your Account's Password has been resetd to 'accountClone' . Please after get the email , change your new password right now. Thanks you for using my service.";
            if (!checkVailable.equals("")) {
                email.sendEmail(checkVailable, "Change your password", emailText);
                JOptionPane.showMessageDialog(null, "Email sent");
                try {
                    String sql = "UPDATE user SET passWord = ? WHERE email = ?";
                    PreparedStatement pr = db.mycon().prepareStatement(sql);
                    pr.setString(1, "accountClone");
                    pr.setString(2, checkVailable);

                    pr.executeUpdate();
                } catch (SQLException e) {
                }

            } else {
                loginForm.callError();
                JOptionPane.showMessageDialog(null, "Email cant be sent");
            }
        } catch (HeadlessException e) {
        }
    }

    public void handleStaySingedIn() throws SQLException {
        String name = loginForm.getUserName();
        String pass = loginForm.getPassWord();
        // reset for all member by 0
        String sql1 = "UPDATE user SET selectStaySign = '0' ";
        PreparedStatement p = db.mycon().prepareStatement(sql1);
        p.executeUpdate();

        Account accountSign = account.returnUser(name, pass);
        if (accountSign != null) {
            accountSign.setIsStaySignedIn("1");

            String sql = "UPDATE user SET selectStaySign = ? WHERE userName = ? AND passWord = ?";
            try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {

                pr.setString(1, "1");
                pr.setString(2, name);
                pr.setString(3, pass);

                pr.executeUpdate();
            }
        }
    }

    public void handleSeeingPassButton() {
        JPasswordField passField = loginForm.gettextFieldPass();
        if (passField.getEchoChar() == (char) 0) {
            passField.setEchoChar('•');
            ImageIcon openEyes = new ImageIcon("D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\icons8-closed-eye-50.png");
            loginForm.getSeeingButton().setIcon(openEyes);
        } else {
            passField.setEchoChar((char) 0);
            ImageIcon openEyes = new ImageIcon("D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\icons8-eye-24.png");
            loginForm.getSeeingButton().setIcon(openEyes);
        }
    }
}
