package model;

public class Customer {
    private int customerID;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;

    // Constructor
    public Customer(int customerID, String customerName, String contactNumber, String email, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        return "Customer ID: " + customerID + ", Name: " + customerName + ", Contact: " + contactNumber + ", Email: " + email + ", Address: " + address;
    }
}
