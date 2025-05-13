package model;

public class Supplier {
    private int supplierID;
    private String supplierName;
    private String contactNumber;
    private String email;
    private String address;

    // Constructor
    public Supplier(int supplierID, String supplierName, String contactNumber, String email, String address) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier ID: " + supplierID + ", Name: " + supplierName + ", Contact: " + contactNumber + ", Email: " + email + ", Address: " + address;
    }
}
