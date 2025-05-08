package Controller;

import Model.Employee;
import View.add;
import View.customerView;
import View.employee;
import View.findForm;
import View.update;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controllerEmployeeView {

    private Employee employee;
    private employee employeeView;
    private add addView;
    private update updateView;
    private findForm findForm;
    private customerView customerView;
    public static int selectRowEmp;
    
    public controllerEmployeeView(employee employeeView) throws SQLException {
        this.employee = new Employee();
        this.employeeView = employeeView;
    }

    public controllerEmployeeView() {
    }
    
    public void handleAddButton() throws SQLException {
        addView = new add();
        addView.setControllerEmployeeView(this);
        addView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addView.setVisible(true);
    }

    public void handleUpdateButton() throws SQLException {
        updateView = new update();
        updateView.setControllerEmployeeView(this);
        selectRowEmp = employeeView.getSelectRow();
        updateView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateView.setVisible(true);
    }

    public void handleFindButton() throws SQLException {
        findForm = new findForm(employeeView);
        findForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        findForm.setVisible(true);
    }

    public void handleDeleteButton() throws SQLException {
        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this employee?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);
        boolean confirmed = (choice == JOptionPane.YES_OPTION);

        int row = employeeView.getTable().getSelectedRow();
         String x = String.valueOf(employeeView.getTable().getValueAt(row, 0));

        if (confirmed) {
            String sql = "DELETE FROM employee WHERE eID = ?";

            try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
                pr.setString(1, x);
                pr.executeUpdate();
                tableLoading();
            }
        }
    }

    public void tableLoading() throws SQLException {

        DefaultTableModel dt = (DefaultTableModel) employeeView.getTable().getModel();
        dt.setRowCount(0);

        Vector<String> List;
        List = employee.getData();

        int rowCount = List.size() / 11; // Số cột là 9
        for (int i = 0; i < rowCount; i++) {
            Vector<Object> row = new Vector<>();
            for (int j = 0; j < 11; j++) {
                row.add(List.get(i * 11 + j));
            }
            dt.addRow(row);
        }
    }

    public void handleKeyrelease() throws SQLException {
        String name = employeeView.getNameFind();

        String sql = "SELECT * FROM employee WHERE Name LIKE ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, "%" + name + "%");

            DefaultTableModel dt = (DefaultTableModel) employeeView.getTable().getModel();
            dt.setRowCount(0);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getString("eID"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("Email"));
                v.add(rs.getString("Dob"));
                v.add(rs.getString("UserName"));
                v.add(rs.getString("PassWord"));
                v.add(rs.getString("Phone"));
                v.add(rs.getString("salary"));
                v.add(rs.getString("totalShift"));

                dt.addRow(v);
            }
        } catch (SQLException e) {
            tableLoading();
        }
    }
    
        public Vector<String> getDataUserSelect() {
        int row = employeeView.getSelectRow();
        JTable customerTable = employeeView.getTable();

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
