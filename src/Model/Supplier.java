package Model;

import Controller.db;
import java.util.Date;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Supplier extends Account {

    String budget;
    int id;

    public Supplier(int id, String name, String address, String gender, String email, Date dob, String userName, String passWord, String phone, String budget) {
        super(name, address, gender, email, dob, userName, passWord, phone);
        this.budget = budget;
        this.id = id;
    }

    public Supplier() {
    }

    public String getBudget() {
        return budget;
    }

    public int getId() {
        return id;
    }
    
    
    public Vector<String> getData() throws SQLException {
        String sql = "SELECT  * FROM supplier";
        Vector<String> v = new Vector();
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                v.add(rs.getString("sID"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("Email"));
                v.add(rs.getString("Dob"));
                v.add(rs.getString("UserName"));
                v.add(rs.getString("PassWord"));
                v.add(rs.getString("Phone"));
                v.add(rs.getString("Budget"));
            }
        }
        return v;
    }

    public Supplier returnSupplier(String name) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE Name = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {

                String dobString = rs.getString("Dob");
                Date dob = null;
                try {
                    dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString); // hoặc "dd/MM/yyyy" tùy database
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return new Supplier(
                        rs.getInt("sID"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        dob,
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("Budget")
                );

            }
        }
        return null;
    }
}
