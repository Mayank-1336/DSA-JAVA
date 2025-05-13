package model;

public class PurchaseOrderItem {
    private int purchaseOrderItemID;
    private int purchaseOrderID;
    private int productID;
    private int quantity;
    private double unitCost;

    public PurchaseOrderItem(int purchaseOrderItemID, int purchaseOrderID, int productID, int quantity, double unitCost) {
        this.purchaseOrderItemID = purchaseOrderItemID;
        this.purchaseOrderID = purchaseOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
}
