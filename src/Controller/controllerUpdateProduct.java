    package Controller;

    import Model.Product;
    import View.stockView;
    import View.updateProduct;
    import java.sql.SQLException;
    import java.util.Vector;
    import javax.swing.ImageIcon;
    import javax.swing.JTable;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class controllerUpdateProduct {

        private Product product;
        private updateProduct updateProduct;
        private stockView stockView;
        private controllerStockView controllerStockView;
        public controllerUpdateProduct(updateProduct updateProduct) throws SQLException {
            this.product = new Product();
            this.updateProduct = updateProduct;
        }
        // handle update Button
        public void handleUpdate(){
            String pID = updateProduct.getPID();
            String barCode1 = updateProduct.getBarcode();
            String nameProduct1 = updateProduct.getNameProduct();
            String costPrice1 = updateProduct.getCost();
            String quantity1 = updateProduct.getQuantity();
            String brandName1 = updateProduct.getBrandName();
            
            String sql = "UPDATE product SET barCode = ? , NameProduct = ? , costPrice = ? , quantity = ? , brandName = ? WHERE pID = ?";
            
            
           try(PreparedStatement pr = db.mycon().prepareStatement(sql)){
               pr.setString(1, barCode1);
               pr.setString(2, nameProduct1);
               pr.setString(3, costPrice1);
               pr.setString(4, quantity1);
               pr.setString(5, brandName1);
               pr.setString(6, pID);
               
               pr.executeUpdate();
               
               updateProduct.setInform("Updated successfully");
           } catch (SQLException ex) {
                updateProduct.setInform("Updated failed");
            }
        }

    }
