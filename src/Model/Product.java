package Model;

import Controller.db;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;


public class Product {

    private int pID;
    private String barCode;
    private String nameProduct;
    private String costPrice;
    private String sellPrice;
    private String quantity;
    private Date mfdDate;
    private Date expDate;
    private String nameBrand;
    private float discount;
    private String pathImg;

    public Product(int pID, String barCode, String nameProduct, String costPrice, String sellPrice, String quantity, Date mfdDate, Date expDate, String nameBrand, float discount, String pathImg) {
        this.pID = pID;
        this.barCode = barCode;
        this.nameProduct = nameProduct;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.mfdDate = mfdDate;
        this.expDate = expDate;
        this.nameBrand = nameBrand;
        this.discount = discount;
        this.pathImg = pathImg;
    }
    
    public Product(){
        
    }
    
    public Product(int pID, String barCode, String nameProduct, String sellPrice,String quantity,String nameBrand,String pathImg) {
        this.pID = pID;
        this.barCode = barCode;
        this.nameProduct = nameProduct;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.nameBrand = nameBrand;
        this.pathImg = pathImg;
    }

    public Product(int pID, String barCode, String nameProduct, String sellPrice, String quantity, String nameBrand) {
        this.pID = pID;
        this.barCode = barCode;
        this.nameProduct = nameProduct;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.nameBrand = nameBrand;
    }

    
    
    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getMfdDate() {
        return mfdDate;
    }

    public void setMfdDate(Date mfdDate) {
        this.mfdDate = mfdDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    
    public Product returnProduct(String name) throws SQLException{
        
        String sql = "SELECT * FROM product WHERE NameProduct = ?";
        
        try(PreparedStatement pr = db.mycon().prepareStatement(sql)){
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            
            if(rs.next()){
                return new Product(
                        rs.getInt("pID"),
                        rs.getString("barCode"),
                        rs.getString("nameProduct"),
                        rs.getString("costPrice"),
                        rs.getString("quantity"),
                        rs.getString("brandName"),
                        rs.getString("pathImg")
                );
            }
        }
        return null;
    }
    
    public ImageIcon getImageIcon() {
        if (pathImg != null && !pathImg.isEmpty()) {
            return new ImageIcon(pathImg);
        }
        return null; // Trả về null nếu không có đường dẫn
    }
}
