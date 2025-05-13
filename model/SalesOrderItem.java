package model;

public class SalesOrderItem {
    private int salesOrderItemID;
    private int salesOrderID;
    private int productID;
    private int quantity;
    private double unitPrice;

    public SalesOrderItem(int salesOrderItemID, int salesOrderID, int productID, int quantity, double unitPrice) {
        this.salesOrderItemID = salesOrderItemID;
        this.salesOrderID = salesOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
}
