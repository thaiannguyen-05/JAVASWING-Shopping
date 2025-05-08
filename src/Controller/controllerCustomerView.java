package Controller;

import Model.Customer;
import View.add;
import View.customerView;
import View.employee;
import View.findForm;
import View.update;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class controllerCustomerView {

    private Customer customer;// khoi tao customer
    private customerView customerView;// khoi tao customerView
    private add addForm;// khoi tao addForm;
    private update updateView;// khoi tao updateView
    private findForm findForm;// khoi tao findView
    public static int selectRow = -1;
    
    public controllerCustomerView(customerView customerView) {
        this.customer = new Customer();
        this.customerView = customerView;
    }
    
    
    public controllerCustomerView() {
    }
    
    public void handleAddButton() throws SQLException {
        addForm = new add();
        addForm.setControllerCustomerView(this);
        addForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addForm.setVisible(true);
    }

    public void handleUpdateButton() throws SQLException {
        updateView = new update();
        updateView.setControllerCustomerView(this);
        selectRow = customerView.getSelectRow();
        updateView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateView.setVisible(true);
    }

    public void handleFindButton() throws SQLException {
        findForm = new findForm(customerView);
        findForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        findForm.setVisible(true);
    }

    public void handleDeleteButton() throws SQLException {

        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this customer?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);
        boolean confirmed = (choice == JOptionPane.YES_OPTION);

        if (confirmed) {
            int row = customerView.getSelectRow();
            String x = String.valueOf(customerView.getTable().getValueAt(row, 0));

            String sql = "DELETE  FROM customer WHERE cID = ?";
            try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
                pr.setString(1, x);

                pr.executeUpdate();

                tableLoading();
            }
        }
    }

    public void handleKeyrelease() throws SQLException{
        String name = customerView.getNameFind();

        String sql = "SELECT * FROM customer WHERE Name LIKE ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, "%"+name+"%");
            
            DefaultTableModel dt = (DefaultTableModel) customerView.getTable().getModel();
            dt.setRowCount(0);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getString("cID"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("Email"));
                v.add(rs.getString("Dob"));
                v.add(rs.getString("UserName"));
                v.add(rs.getString("PassWord"));
                v.add(rs.getString("Phone"));
                v.add(rs.getString("Budget"));
                
                dt.addRow(v);
            }
        }
        catch(SQLException e){
            tableLoading();
        }
    }

    public void tableLoading() throws SQLException {

        DefaultTableModel dt = (DefaultTableModel) customerView.getTable().getModel();
        dt.setRowCount(0);

        Vector<String> List;
        List = customer.getData();

        int rowCount = List.size() / 10; // Số cột là 9
        for (int i = 0; i < rowCount; i++) {
            Vector<Object> row = new Vector<>();
            for (int j = 0; j < 10; j++) {
                row.add(List.get(i * 10 + j));
            }
            dt.addRow(row);
        }
    }

    public int returnRow() {
        return customerView.getSelectRow();
    }

    public Vector<String> getDataUserSelect() {
        int row = customerView.getSelectRow();
        JTable customerTable = customerView.getTable();

        Vector<String> list = new Vector<>();
        list.add((String) customerTable.getValueAt(row, 0));
        list.add((String) customerTable.getValueAt(row, 1));
        list.add((String) customerTable.getValueAt(row, 2));
        list.add((String) customerTable.getValueAt(row, 3));
        list.add((String) customerTable.getValueAt(row, 4));
        list.add((String) customerTable.getValueAt(row, 5));
        list.add((String) customerTable.getValueAt(row, 6));
        list.add((String) customerTable.getValueAt(row, 7));
        list.add((String) customerTable.getValueAt(row, 8));

        return list;
    }

    
}
