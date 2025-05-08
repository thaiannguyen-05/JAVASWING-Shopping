package Controller;

import Model.Account;
import View.homeAdminForm;
import View.loginForm;
import View.checkFrofileForm;
import View.customerView;
import View.employee;
import View.reportView;
import View.stockView;
import View.supplierView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class controllerHomeAdmin {
    private homeAdminForm homeAdmin;
    private Account account;
    private loginForm loginForm;
    private customerView customerView;
    private employee employeeView;
    private supplierView supplierView;
    private stockView stock;
    private reportView reportView;
    private JpanelLoader jloader;
    
    public controllerHomeAdmin(homeAdminForm homeAdmin) {
        this.homeAdmin = homeAdmin;
        this.account = new Account();
        jloader = new JpanelLoader();
    }
    
    public void handleLogout() throws SQLException {
        
        new loginForm().setVisible(true);
        homeAdmin.setVisible(false);
    }
    
    public void handleCheckProfile() throws SQLException {
        checkFrofileForm checkProfileForm = new checkFrofileForm();
        checkProfileForm.setVisible(true);
        
        Account accountUser = account.getLogin();
        checkProfileForm.setUsername(accountUser.getUserName());
        
        homeAdmin.setVisible(false);
    }
    
    public void handleCustomerButton() throws SQLException {
        try {
            customerView = new customerView();
            jloader.jPanelLoader(homeAdmin.getTotalPanel(), customerView);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(homeAdmin, 
                "Error loading customer view: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
    }
    
    public void handleEmployeeButton(){
        try {
            employeeView = new employee();
            jloader.jPanelLoader(homeAdmin.getTotalPanel(), employeeView);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void handleSupplierButton(){
        try {
            supplierView = new supplierView();
            jloader.jPanelLoader(homeAdmin.getTotalPanel(), supplierView);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void handleStockButton(){
        try {
            stock = new stockView();
            jloader.jPanelLoader(homeAdmin.getTotalPanel(), stock);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void handleReportButton() throws SQLException{
        reportView = new reportView();
        jloader.jPanelLoader(homeAdmin.getTotalPanel(), reportView);
    }
}
