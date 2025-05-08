package Controller;

import View.update;
import Model.Customer;
import View.customerView;
import View.homeAdminForm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;

public class controllerUpdateButton {

    private final Customer customer;// khoi tao bien customer
    private final update updateView;// khoi tao bien updateView
    private controllerCustomerView controllerCustomerView;// khoi tao controllerCusView
    private controllerEmployeeView conEmployeeView;// khoi tao controllerCusView
    private controllerSupplier controllerSupplier;
    private customerView customerView;// khoi tao viewCustomer

    public controllerUpdateButton(update updateView) {
        this.customer = new Customer();// khoi tao customer
        this.updateView = updateView;// tham chieu view
    }
    
    // tham chieu controlleCustomerView 
    public void setControllerCustomerView(controllerCustomerView controllerView) {
        this.controllerCustomerView = controllerView;
        Vector<String> list = controllerCustomerView.getDataUserSelect();
        setDataInView(list);
    }
    
    public void setControllerEmployeeView(controllerEmployeeView conEmployeeView){
        this.conEmployeeView = conEmployeeView;
        Vector<String> list = conEmployeeView.getDataUserSelect();
        setDataInView(list);
    }
    
    public void setControllerSupplier(controllerSupplier controllerSupplier){
        this.controllerSupplier = controllerSupplier;
        Vector<String> list = this.controllerSupplier.getDataUserSelect();
        setDataInView(list);
    }

    public void handleUpdateButton(String nameTable, JTable table, int selectedRow,String id) throws SQLException {
        Vector<String> list = new Vector<>();
        
        if(selectedRow == -1){
            System.out.println("Flag");
        }
        
        String whichChoose = homeAdminForm.whichChoose;
        
        String oldName = (String) table.getValueAt(selectedRow, 1);
        String name = updateView.getFullName();
        String dob = updateView.getDob();
        String email = updateView.getEmail();
        String address = updateView.getAddress();
        String user = updateView.getUser();
        String pass = updateView.getPass();
        String gender = updateView.getGender();
        Object value = table.getValueAt(selectedRow, 0);
        int intValue = Integer.parseInt(value.toString());
        
        //boolean checkDupName = name.equals(oldName);
        String  sql = "UPDATE " + nameTable + " SET Address=?, Gender=?, Email=?, Dob=?, UserName=?, PassWord=? WHERE "+id+" = ?";

        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            
            pr.setString(1, address);
            pr.setString(2, gender);
            pr.setString(3, email);
            pr.setString(4, dob);
            pr.setString(5, user);
            pr.setString(6, pass);
            pr.setInt(7, intValue);
            
            pr.executeUpdate();
            updateView.inform("Update Successfully");
            
            switch (whichChoose) {
                case "1" -> controllerCustomerView.tableLoading();
                case "2" -> conEmployeeView.tableLoading();
                case "3" -> controllerSupplier.tableLoading();
                default -> {
                }
            }
        } catch (SQLException e) {
            updateView.inform("Name is not allowed change"
                             + "Update failed");
            e.printStackTrace();
        }
    }


    public void setDataInView(Vector<String> list) {
        updateView.setFullNameField(list.get(1));
        updateView.setAddressField(list.get(2));
        updateView.setGenderField(list.get(3));
        updateView.setEmailField(list.get(4));
        updateView.setDob(list.get(5));
        updateView.setUserField(list.get(6));
        updateView.setPassFIeld(list.get(7));
    }

}
