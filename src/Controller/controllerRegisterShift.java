package Controller;

import Model.Employee;
import View.homeEmployee;
import View.loginForm;
import View.registerShift;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controllerRegisterShift {

    private registerShift registerShift;
    private Employee Employee;
    
    public controllerRegisterShift(registerShift registerShift) {
        this.registerShift = registerShift;
        Employee = new Employee();
    }

    public void callData(JTable table) throws SQLException {

        DefaultTableModel dt = (DefaultTableModel) table.getModel();
        dt.setRowCount(0);

        String sql = "SELECT * FROM dateofshift";

        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getString("dateOfWeek"));
                v.add(rs.getString("dateOfMonth"));
                v.add(rs.getString("shiftHaveChoose"));

                dt.addRow(v);
            }
        }
        
       
        
    }

    public void handleChooseShift(JTable table, JComboBox jcombo) throws SQLException {
        int row = table.getSelectedRow();
        Object shiftChoose = table.getValueAt(row, 0);
        Object shiftTimeTable = table.getValueAt(row, 2);
        String shift = shiftChoose.toString();

        String shiftTime = jcombo.getSelectedItem().toString();

        if (!shiftTimeTable.toString().equals("not registered")) {
            JOptionPane.showMessageDialog(null, "Shift have been choose , please choose other shift...");
            return;
        }

        String sql = "UPDATE dateofshift SET shiftHaveChoose = ? WHERE dateOfWeek = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, shiftTime);
            pr.setString(2, shift);
            pr.executeUpdate();
            callData(table);
        }

        String detailShift = shift + shiftTime + "\n";
        String sql2 = "SELECT detailShift FROM employee WHERE UserName = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql2)) {
            pr.setString(1, loginForm.username);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                String oldDetail = rs.getString("detailShift");
                if (oldDetail != null) {
                    detailShift = oldDetail + detailShift;
                }
            }
        }

        String sql3 = "UPDATE employee SET detailShift = ? , totalShift = ? WHERE UserName = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql3)) {
            pr.setString(1, detailShift);
            pr.setString(2, String.valueOf(homeEmployee.countShift));
            pr.setString(3, loginForm.username);
            pr.executeUpdate();
        }
        
        
    }

    public void handleDeleteShift(JTable table) throws SQLException {
        int row = table.getSelectedRow();
        Object shiftChoose = table.getValueAt(row, 0);

        String sql = "UPDATE dateofshift SET shiftHaveChoose = ? WHERE dateOfWeek = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, "not registered");
            pr.setString(2, shiftChoose.toString());
            pr.executeUpdate();
            callData(table);
        }
    }
}
