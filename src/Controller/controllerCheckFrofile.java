package Controller;

import Model.Account;
import View.checkFrofileForm;
import View.viewProfileForm;
import javax.swing.JPanel;
import Controller.JpanelLoader;
import View.changePassView;
import View.homeAdminForm;
import java.sql.SQLException;

public class controllerCheckFrofile {
    private checkFrofileForm checkFrofileForm; // khoi tao view
    private Account account; // khoi tao account
    private JpanelLoader jloader = new JpanelLoader();
    public controllerCheckFrofile(checkFrofileForm checkFrofileForm) {
        this.checkFrofileForm = checkFrofileForm;// tham chieu form view
        this.account = new Account();
    }
    
    /**
     *
     * @param mainPanel
     * @param newPanel
     */
    public void switchPanel(JPanel mainPanel, JPanel newPanel) {
        mainPanel.removeAll();
        mainPanel.add(newPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void handleCallProfileView() throws SQLException{
        viewProfileForm viewFrofile = new viewProfileForm();
        
        jloader.jPanelLoader(checkFrofileForm.getMainPanel(), viewFrofile);
        
    }
    
    public void handleCallChangePass(){
         changePassView changePassView = new changePassView();
        
        jloader.jPanelLoader(checkFrofileForm.getMainPanel(), changePassView);
    }
    
    public void handleBackDashBroad(){
        homeAdminForm homeAdmin = new homeAdminForm();
        checkFrofileForm.setVisible(false);
        homeAdmin.setVisible(true);
    }
    
}
