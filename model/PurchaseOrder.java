package model;

import java.util.*;

public class PurchaseOrder {
    private int purchaseOrderID;
    private int supplierID;
    private String orderDate;
    private String status;
    private List<PurchaseOrderItem> orderItems = new ArrayList<>();

    public PurchaseOrder(int purchaseOrderID, int supplierID, String orderDate, String status) {
        this.purchaseOrderID = purchaseOrderID;
        this.supplierID = supplierID;
        this.orderDate = orderDate;
        this.status = status;
    }

    public void addItem(PurchaseOrderItem item) {
        orderItems.add(item);
    }

    public void processOrder(Map<Integer, Product> products) {
        for (PurchaseOrderItem item : orderItems) {
            Product product = products.get(item.getProductID());
            if (product != null) {
                product.setQuantityInStock(product.getQuantityInStock() + item.getQuantity());
                System.out.println("Purchase Order Processed for Product ID: " + product.getProductID() + ", Quantity Added: " + item.getQuantity());
            }
        }
    }
}
