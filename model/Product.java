package model;

public class Product {
    private int productID;
    private String name;
    private int categoryID;
    private int quantityInStock;
    private double unitPrice;
    private int reorderLevel;

    public Product(int productID, String name, int categoryID, int quantityInStock, double unitPrice, int reorderLevel) {
        this.productID = productID;
        this.name = name;
        this.categoryID = categoryID;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
        this.reorderLevel = reorderLevel;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void increaseStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public void decreaseStock(int quantity) {
        this.quantityInStock -= quantity;
    }
}
