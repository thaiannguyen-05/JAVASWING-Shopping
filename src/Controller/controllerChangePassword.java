package Controller;

import Model.Account;
import View.changePassView;
import View.checkFrofileForm;
import View.loginForm;
import View.viewProfileForm;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controllerChangePassword {

    private changePassView changePassView;// khoi tao view
    private Account account;
    private loginForm loginForm;// khoi tao view login
    private JpanelLoader jloader;// khoi tao loadview
    private checkFrofileForm checkProfile; // khoi tao checkprofile view
    
    public controllerChangePassword(changePassView changePassView) {
        this.changePassView = changePassView; //truyen tham chieu view    
        this.account = new Account();

    }


    public void saveNewPassWord() throws SQLException {
        String oldPass = changePassView.getOldPass();
        String newPass = changePassView.getNewPass();
        loginForm = new loginForm();// khoi tao login

        String user = loginForm.getUserName();
        String pass = loginForm.getPassWord();

        String sql = "UPDATE user SET passWord = ? WHERE oldPass = ? AND userName = ?";

        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, newPass);
            pr.setString(2, oldPass);
            pr.setString(3, user);

            pr.executeUpdate();
        }
    }
}
