package Controller;

import Model.Product;
import View.addMerchandise;
import View.stockView;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class controllerAddMerchandise {

    private Product product;
    private addMerchandise addMarchandie;
    private SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd");
    private controllerStockView controllerStockView;
    public controllerAddMerchandise(addMerchandise addMarchandie) {
        this.product = new Product();
        this.addMarchandie = addMarchandie;
        controllerStockView = new controllerStockView();
    }

    public void handleGetImgProduct() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn ảnh sản phẩm");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(addMarchandie.getAddImgLabel());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());

            // Resize ảnh cho vừa với label
            Image image = icon.getImage().getScaledInstance(
                    addMarchandie.getAddImgLabel().getWidth(),
                    addMarchandie.getAddImgLabel().getHeight(),
                    Image.SCALE_SMOOTH
            );

            addMarchandie.getAddImgLabel().setIcon(new ImageIcon(image));
            addMarchandie.getAddImgLabel().setText(""); // Xóa text nếu có

            product.setPathImg(selectedFile.getAbsolutePath());
        }
    }

    public void handleAddButton() throws ParseException {
        String sql = "INSERT INTO product (barCode,NameProduct,costPrice,sellPrice,discount,quantity,mfdDate,expDate,brandName,pathImg,typeOfClothes) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = db.mycon().prepareStatement(sql);

            pr.setString(1, addMarchandie.getBarcode());
            pr.setString(2, addMarchandie.getNameField());
            pr.setString(3, addMarchandie.getCostPrice());
            pr.setString(4, addMarchandie.getCostSell());
            pr.setString(5, addMarchandie.getDiscount());
            pr.setString(6, addMarchandie.getQty()); 
            pr.setString(7, addMarchandie.getmfdDate());
            pr.setString(8, addMarchandie.getexpDate());
            pr.setString(9, addMarchandie.getBrandName());
            pr.setString(10, product.getPathImg());
            pr.setString(11, addMarchandie.getTypeClothes());
            pr.executeUpdate();
            addMarchandie.setInform("Add successfully");
        } catch (SQLException e) {
            addMarchandie.setInform("Add failed");
            e.printStackTrace();
        }
    }
    

}
