package Controller;

import Model.Product;
import View.homeAdminForm;
import View.homeCustomer;
import View.tableProductCus;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controllerTableProductCus {

    private tableProductCus tableProductCus;
    private Product Product;

    public controllerTableProductCus(tableProductCus tableProductCus) {
        this.tableProductCus = tableProductCus;
        this.Product = new Product();
    }

    public void tableLoading(JTable table) throws SQLException {
        String sql = "SELECT * FROM product";
        int countQuantity = 0;
        try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();

            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            dt.setRowCount(0); // Clear table

            while (rs.next()) {
                Vector<Object> v = new Vector<>();

                v.add(rs.getString("pID"));
                v.add(rs.getString("barCode"));
                v.add(rs.getString("NameProduct"));
                v.add(rs.getString("costPrice"));
                v.add(rs.getString("quantity"));
                v.add(rs.getString("brandName"));
                countQuantity += Integer.parseInt(rs.getString("quantity"));
                // Tạo ImageIcon từ đường dẫn ảnh
                String imgPath = rs.getString("pathImg");
                ImageIcon icon = new ImageIcon(imgPath);

                // Resize ảnh nếu cần
                Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);

                v.add(icon); // Thêm ảnh

                dt.addRow(v);
            }

            // Chiều cao để ảnh không bị cắt
            table.setRowHeight(60);
        }
        
    }

    public void handleChoose(JTable table, homeCustomer hom) {
        Vector v = getData(table);
        Object pID = v.get(0);
        Object barCode = v.get(1);
        Object name = v.get(2);
        Object cost = v.get(3);
        Object quan = v.get(4);
        Object brand = v.get(5);
        Object img = v.get(6);

        hom.setPid(pID.toString());
        hom.setBarcode(barCode.toString());
        hom.setNamePro(name.toString());
        hom.setPrice(cost.toString());
        hom.setQuan(quan.toString());
        hom.setBrandName(brand.toString());

        if (img instanceof ImageIcon) {
            JLabel imgLabel = hom.getImgLabel();
            ImageIcon icon = (ImageIcon) img;
            int width = imgLabel.getWidth();
            int height = imgLabel.getHeight();
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imgLabel.setIcon(new ImageIcon(scaledImage));
        }

        tableProductCus.setVisible(false);
    }

public Vector<Object> getData(JTable table) {
        int row = table.getSelectedRow();

        Vector v = new Vector();
        v.add(table.getValueAt(row, 0));
        v.add(table.getValueAt(row, 1));
        v.add(table.getValueAt(row, 2));
        v.add(table.getValueAt(row, 3));
        v.add(table.getValueAt(row, 4));
        v.add(table.getValueAt(row, 5));
        v.add(table.getValueAt(row, 6));

        return v;
    }

}
