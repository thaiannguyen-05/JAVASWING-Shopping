package Model;

import Controller.db;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Employee extends Account {

    private int id;
    private String salary;
    private int totalShip;

    public Employee(int id, String salary, int totalShip, String name, String address, String gender, Date dob, String email, String position, String userName, String passWord, String phone, String isStaySignedIn) {
        super(name, address, gender, dob, email, position, userName, passWord, phone, isStaySignedIn);
        this.id = id;
        this.salary = salary;
        this.totalShip = totalShip;
    }

    public Employee(int id, String name, String address, String gender, String email, Date dob, String userName, String passWord, String phone, String salary, int totalShip) {
        super(name, address, gender, email, dob, userName, passWord, phone);
        this.id = id;
        this.salary = salary;
        this.totalShip = totalShip;
    }
    
    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getTotalShip() {
        return totalShip;
    }

    public void setTotalShip(int totalShip) {
        this.totalShip = totalShip;
    }
    
    public Employee returnEmp(String x) throws SQLException {
    String sql = "SELECT * FROM employee WHERE Name = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)){
            pr.setString(1, x);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {

                String dobString = rs.getString("Dob");
                Date dob = null;
                try {
                    dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString); // hoặc "dd/MM/yyyy" tùy database
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return new Employee(
                        rs.getInt("eID"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        dob,
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("salary"),
                        rs.getInt("totalShift")
                );
            }
        }
        return null;
    }
    
    public Vector<String> getData() throws SQLException {
        String sql = "SELECT * FROM employee";
        Vector<String> v = new Vector<>();

        try (PreparedStatement pr = db.mycon().prepareStatement(sql); ResultSet rs = pr.executeQuery()) {

            while (rs.next()) {
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
            }
        }
        return v;
    }
    
    public Employee returnEmpID(String x) throws SQLException {
    String sql = "SELECT * FROM employee WHERE UserName = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)){
            pr.setString(1, x);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {

                String dobString = rs.getString("Dob");
                Date dob = null;
                try {
                    dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString); // hoặc "dd/MM/yyyy" tùy database
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return new Employee(
                        rs.getInt("eID"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        dob,
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("salary"),
                        rs.getInt("totalShift")
                );
            }
        }
        return null;
    }
}
