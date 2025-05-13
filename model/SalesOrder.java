package model;

import java.util.*;

public class SalesOrder {
    private int salesOrderID;
    private int customerID;
    private String orderDate;
    private String status;
    private List<SalesOrderItem> orderItems = new ArrayList<>();

    public SalesOrder(int salesOrderID, int customerID, String orderDate, String status) {
        this.salesOrderID = salesOrderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.status = status;
    }

    public void addItem(SalesOrderItem item) {
        orderItems.add(item);
    }

    public void processOrder(Map<Integer, Product> products) {
        for (SalesOrderItem item : orderItems) {
            Product product = products.get(item.getProductID());
            if (product != null) {
                product.setQuantityInStock(product.getQuantityInStock() - item.getQuantity());
                System.out.println("Sales Order Processed for Product ID: " + product.getProductID() + ", Quantity Sold: " + item.getQuantity());
            }
        }
    }
}
