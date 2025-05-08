package Model;

import Controller.db;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Customer extends Account {

    private String budget;
    private int id;
    //private customerView customerView;// khoi tao view

    public Customer(int id, String name, String address, String gender, Date dob, String email, String position, String userName, String passWord, String phone, String isStaySignedIn, String budget) {
        super(name, address, gender, dob, email, position, userName, passWord, phone, isStaySignedIn);
        this.budget = budget;
        this.id = id;
    }

    public Customer(int id, String name, String address, String gender, Date dob, String email, String userName, String passWord, String phone, String budget) {
        super(name, address, gender, email, dob, userName, passWord, phone);
        this.budget = budget;
        this.id = id;
    }

    
    
    public Customer() {
    }

    public String getBudget() {
        return budget;
    }

    public int getId() {
        return id;
    }


    
    
    
    // get date to print in table
    public Vector<String> getData() throws SQLException {
        String sql = "SELECT * FROM customer";
        Vector<String> v = new Vector<>();

        try (PreparedStatement pr = db.mycon().prepareStatement(sql); ResultSet rs = pr.executeQuery()) {

            while (rs.next()) {
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
            }
        }
        return v;
    }

    // return customer
    public Customer returnUser(String name) throws SQLException {
        String sql = "SELECT * FROM customer WHERE Name = ?";
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

                return new Customer(
                        rs.getInt("cID"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        dob,
                        rs.getString("Email"),
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("Budget")
                );

            }
        }
        return null;
    }
    
        public Customer returnUserByUserName(String name) throws SQLException {
        String sql = "SELECT * FROM customer WHERE UserName = ?";
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

                return new Customer(
                        rs.getInt("cID"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        dob,
                        rs.getString("Email"),
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
