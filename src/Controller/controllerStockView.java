        package Controller;

        import View.stockView;
        import Model.Product;
        import View.addMerchandise;
        import View.findForm;
        import View.updateProduct;
        import java.awt.Image;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.Vector;
        import javax.swing.ImageIcon;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;
        import javax.swing.JTable;
        import javax.swing.table.DefaultTableModel;

        public class controllerStockView {

            private stockView stockView;
            private Product product;
            private addMerchandise addGoodsView;
            private updateProduct updateProView;
            private findForm findForm;

            public controllerStockView(stockView stockView) {
                this.stockView = stockView;
                this.product = new Product();
            }

            public void handleAddGoods() {
                addGoodsView = new addMerchandise();
                addGoodsView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addGoodsView.setVisible(true);
            }

            public controllerStockView() {
            }

            ;
           public void tableLoading() throws SQLException {
                String sql = "SELECT * FROM product";
                int countQuantity = 0;
                try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
                    ResultSet rs = pr.executeQuery();

                    DefaultTableModel dt = (DefaultTableModel) stockView.getTable().getModel();
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
                    stockView.getTable().setRowHeight(60);
                }
                stockView.setTextTotalQuantity(String.valueOf(countQuantity));
            }

            public void handleUpdateButton() throws SQLException {
                updateProView = new updateProduct();
                updateProView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Lấy dữ liệu từ dòng đã chọn
                Vector<Object> selectedData = getDateUserSelect();

                // Đặt dữ liệu vào form cập nhật
                updateProView.setPID(selectedData.get(0).toString());
                updateProView.setBarcodeField((String) selectedData.get(1));
                updateProView.setNameProductField((String) selectedData.get(2));
                updateProView.setCostField((String) selectedData.get(3));
                updateProView.setQuantityField((String) selectedData.get(4));
                updateProView.setBrandField((String) selectedData.get(5));
                if (selectedData.get(6) instanceof ImageIcon) {
                    updateProView.setImg(selectedData.get(6));
                }
                updateProView.setVisible(true);
            }

            public Vector<Object> getDateUserSelect() {
                int row = stockView.getRow();
                JTable stockTable = stockView.getTable();
                String pIF = stockTable.getValueAt(row, 0).toString();
                String barCode = stockTable.getValueAt(row, 1).toString();
                String nameProduct = stockTable.getValueAt(row, 2).toString();
                String costPrice = stockTable.getValueAt(row, 3).toString();
                String quantity = stockTable.getValueAt(row, 4).toString();
                String brandName = stockTable.getValueAt(row, 5).toString();
                Object value = stockTable.getValueAt(row, 6); // Cột ảnh

                ImageIcon icon = null;
                if (value instanceof ImageIcon) {
                    icon = (ImageIcon) value;
                }

                Vector<Object> data = new Vector<>();
                data.add(pIF);
                data.add(barCode);
                data.add(nameProduct);
                data.add(costPrice);
                data.add(quantity);
                data.add(brandName);
                data.add(icon); // Cho ảnh vào vector luôn, để có thể dùng sau

                return data;
            }

            public void handleFindButton() {
                try {
                    findForm = new findForm(stockView);  // Use the stockView constructor instead of default
                    findForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    findForm.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            public void handleDeleteButton() throws SQLException{
                int row = stockView.getTable().getSelectedRow();
                String sql = "DELETE FROM product WHERE pID = ?";
                int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this product?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION);
                boolean confirmed = (choice == JOptionPane.YES_OPTION);

                if(confirmed){
                    Object x = stockView.getTable().getValueAt(row, 0);
                    int pID = Integer.parseInt(x.toString());

                    try(PreparedStatement pr = db.mycon().prepareStatement(sql)){
                        pr.setInt(1, pID);

                    pr.executeUpdate();
                    tableLoading();
                }
                }
            }

            public void handleRefresh() throws SQLException{
                tableLoading();
            }

        }
