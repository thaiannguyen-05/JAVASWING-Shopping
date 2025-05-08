package Controller;

import Model.AreaChartModel;
import View.AreaChartView;
import Model.Product;
import View.reportView;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;

public class controllerReportView {

    private reportView reportView;
    private Product product;

    public controllerReportView(reportView reportView) {
        this.reportView = reportView;
        this.product = new Product();
    }

public void insertData() throws SQLException {
    AreaChartView area = reportView.getAreaChartView1();
    String sql = "SELECT * FROM product";

    int quantityTShirt = 0, quantityJacket = 0, quantityTrousers = 0;
    int minQuantity = Integer.MIN_VALUE;
    float totalRevenue = 0;

    Map<String, Float> bestSeller = new LinkedHashMap<>();
    Vector<String> inventory = new Stack<>();

    try (PreparedStatement pr = db.mycon().prepareStatement(sql)) {
        ResultSet rs = pr.executeQuery();

        while (rs.next()) {
            String name = rs.getString("NameProduct");
            String type = rs.getString("typeOfClothes");
            float cost = Float.parseFloat(rs.getString("costPrice"));
            float sell = Float.parseFloat(rs.getString("sellPrice"));
            int quantity = Integer.parseInt(rs.getString("quantity"));

            float profit = (sell - cost) * quantity;

            // Store in bestSeller map
            bestSeller.put(name, profit);

            // Track max quantity for inventory
            if (quantity > minQuantity) {
                minQuantity = quantity;
                inventory.clear(); // Clear previous if new max found
                inventory.add(name);
            } else if (quantity == minQuantity) {
                inventory.add(name);
            }

            // Count by type
            if ("T-Shirt".equals(type)) {
                quantityTShirt += quantity;
            } else if ("Jacket".equals(type)) {
                quantityJacket += quantity;
            } else if ("Trousers".equals(type)) {
                quantityTrousers += quantity;
            }

            totalRevenue += sell * quantity;
        }
    }

    // Add data to area chart
    area.addItem(new AreaChartModel(new Color(52, 148, 203), "T-Shirt", quantityTShirt));
    area.addItem(new AreaChartModel(new Color(175, 67, 237), "Jacket", quantityJacket));
    area.addItem(new AreaChartModel(new Color(87, 218, 137), "Trousers", quantityTrousers));

    // Set inventory info
    if (!inventory.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (String productName : inventory) {
            sb.append(productName).append("--\n");
        }
        reportView.getNameInventory().setText(sb.toString());
        reportView.getQuantityInventory().setText(String.valueOf(minQuantity));
    }

    // Format and set total revenue
    DecimalFormat df = new DecimalFormat("#,###");
    df.setMaximumFractionDigits(0);
    reportView.getTotalRevenue().setText(df.format(totalRevenue) + " vnd");

    // Set total quantity sold
    int totalQuantity = quantityTShirt + quantityJacket + quantityTrousers;
    reportView.getTotalQuantity().setText(String.valueOf(totalQuantity));

    // Sort best sellers and get top 3
    Map<String, Float> top3BestSellers = bestSeller.entrySet().stream()
        .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
        .limit(3)
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
        ));

    int index = 0;
    for (Map.Entry<String, Float> entry : top3BestSellers.entrySet()) {
        String name = entry.getKey();
        String profitStr = df.format(entry.getValue());

        switch (index) {
            case 0:
                reportView.getNameProduct().setText(name);
                reportView.getmaxProfit().setText(profitStr);
                break;
            case 1:
                reportView.getNameProduct1().setText(name);
                reportView.getmaxProfit1().setText(profitStr);
                break;
            case 2:
                reportView.getNameProduct2().setText(name);
                reportView.getmaxProfit2().setText(profitStr);
                break;
        }
        index++;
    }
}


}
