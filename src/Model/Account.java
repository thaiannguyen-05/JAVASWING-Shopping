package Model;

import Controller.db;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {

    private String name;
    private String address;
    private String gender;
    private String email;
    private Date dob;
    private String position;
    private String userName;
    private String passWord;
    private String phone;
    private String isStaySignedIn;

    public Account(String name, String address, String gender, Date dob, String email, String position, String userName, String passWord, String phone, String isStaySignedIn) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.position = position;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.isStaySignedIn = isStaySignedIn;
    }

    public Account(String name, String address, String gender, String email, Date dob, String userName, String passWord, String phone) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
    }
    
    
    
    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String isIsStaySignedIn() {
        return isStaySignedIn;
    }

    public void setIsStaySignedIn(String isStaySignedIn) {
        this.isStaySignedIn = isStaySignedIn;
    }

    public boolean IsAuthenticateUserGetPos(String userName, String passWord) {
        String sql = "SELECT * FROM user WHERE userName = ? AND passWord = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, userName);
            pr.setString(2, passWord);

            ResultSet rs = pr.executeQuery();

            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public String IsUserAvailable(String userName) {
        String sql = "SELECT * FROM user WHERE userName = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, userName);

            ResultSet rs = pr.executeQuery();
            String email = null;
            if (rs.next()) {
                email = rs.getString("email").toString();
            }
            return email;
        } catch (Exception e) {
            return "";
        }
    }

    public Account returnUser(String userName, String passWord) throws SQLException {
        String sql = "SELECT * FROM user WHERE UserName = ? AND PassWord = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, userName);
            pr.setString(2, passWord);

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {

                Date dob = null;
                try {
                    dob = rs.getDate("Dob");
                } catch (SQLException e) {
                    // Xử lý ngoại lệ hoặc sử dụng ngày mặc định
                    dob = new Date(); // Ngày hiện tại làm giá trị dự phòng
                }

                return new Account(
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        dob,
                        rs.getString("Email"),
                        rs.getString("Position"),
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("SelectStaySign")
                );
            }
        }
        return null;
    }

    // get account keeping login 
    public Account getUserSignUp() throws SQLException {
        String sql = "SELECT * FROM user WHERE SelectStaySign = ?";
        try (PreparedStatement pr = db.mycon().prepareCall(sql)) {
            pr.setString(1, "1");
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {

                Date dob = null;
                try {
                    dob = rs.getDate("Dob");
                } catch (SQLException e) {
                    // Xử lý ngoại lệ hoặc sử dụng ngày mặc định
                    dob = new Date(); // Ngày hiện tại làm giá trị dự phòng
                }
                return new Account(
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        dob,
                        rs.getString("Email"),
                        rs.getString("Position"),
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("SelectStaySign")
                );
            }

        }
        return null;
    }

    public int getTimeToChangeUser(String name, String pass) {
        String sql = "SELECT * FROM user WHERE UserName = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, name);

            ResultSet rs = pr.executeQuery();
            int timeToChange = 0;
            if (rs.next()) {
                timeToChange = rs.getInt("TimeToCHangeUserName");
            }
            return timeToChange;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getPassWhenAccountTrue(String user) throws SQLException {
        String sql = "SELECT * FROM user WHERE UserName = ?";
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, user);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {  // kiểm tra có dòng dữ liệu không
                return rs.getString("PassWord");
            }
        }
        return ""; // không có user thì trả về chuỗi rỗng
    }

    // check status login
    public Account getLogin() throws SQLException {
        String sql = "SELECT * FROM user WHERE checkLogin = ?";

        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            pr.setString(1, "1");
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Gender"),
                        dob,
                        rs.getString("Email"),
                        rs.getString("Position"),
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getString("Phone"),
                        rs.getString("SelectStaySign")
                );
            }
            return null;
        }
    }

}
