import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Product> products = new HashMap<>();
        List<Customer> customers = new ArrayList<>();
        List<Supplier> suppliers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Sample Products
        products.put(1, new Product(1, "Dell Inspiron 15", 1, 10, 800.0, 2));
        products.put(2, new Product(2, "Sony WH-1000XM4", 2, 20, 350.0, 5));

        // Sample Customers
        customers.add(new Customer(1, "John Doe", "1234567890", "john@example.com", "123 Elm Street"));
        customers.add(new Customer(2, "Jane Smith", "0987654321", "jane@example.com", "456 Oak Street"));

        // Sample Suppliers
        suppliers.add(new Supplier(1, "TechSupply Co.", "555-1234", "techsupply@example.com", "789 Tech Road"));
        suppliers.add(new Supplier(2, "Gizmo Distributors", "555-5678", "gizmo@example.com", "321 Gadget Ave"));

        while (running) {
            System.out.println("=== Inventory Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Make Purchase Order");
            System.out.println("4. Make Sales Order");
            System.out.println("5. Add Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Add Supplier");
            System.out.println("8. Delete Supplier");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Category ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Reorder Level: ");
                    int reorder = sc.nextInt();
                    products.put(pid, new Product(pid, name, cid, qty, price, reorder));
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    // View Products
                    System.out.println("=== Products List ===");
                    List<Product> sortedProducts = new ArrayList<>(products.values());
                    quickSort(sortedProducts, 0, sortedProducts.size() - 1);
                    for (Product product : sortedProducts) {
                        System.out.println("ID: " + product.getProductID() + ", Name: " + product.getName() + ", Stock: " + product.getQuantityInStock());
                    }
                    break;

                case 3:
                    // Make Purchase Order
                    System.out.print("Enter Purchase Order ID: ");
                    int poID = sc.nextInt();
                    System.out.print("Enter Supplier ID: ");
                    int supID = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Order Status: ");
                    String poStatus = sc.nextLine();
                    PurchaseOrder po = new PurchaseOrder(poID, supID, new Date().toString(), poStatus);
                    List<PurchaseOrderItem> poItems = new ArrayList<>();
                    System.out.print("How many items in the Purchase Order? ");
                    int poCount = sc.nextInt();
                    for (int i = 0; i < poCount; i++) {
                        System.out.print("Product ID: ");
                        int pidPo = sc.nextInt();
                        System.out.print("Quantity: ");
                        int qtyPo = sc.nextInt();
                        System.out.print("Unit Cost: ");
                        double costPo = sc.nextDouble();
                        poItems.add(new PurchaseOrderItem(i + 1, poID, pidPo, qtyPo, costPo));
                    }
                    poItems.forEach(po::addItem);
                    po.processOrder(products);
                    break;

                case 4:
                    // Make Sales Order
                    System.out.print("Enter Sales Order ID: ");
                    int soID = sc.nextInt();
                    System.out.print("Enter Customer ID: ");
                    int custID = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Order Status: ");
                    String soStatus = sc.nextLine();
                    SalesOrder so = new SalesOrder(soID, custID, new Date().toString(), soStatus);
                    List<SalesOrderItem> soItems = new ArrayList<>();
                    System.out.print("How many items in the Sales Order? ");
                    int soCount = sc.nextInt();
                    for (int i = 0; i < soCount; i++) {
                        System.out.print("Product ID: ");
                        int pidSo = sc.nextInt();
                        System.out.print("Quantity: ");
                        int qtySo = sc.nextInt();
                        System.out.print("Unit Price: ");
                        double priceSo = sc.nextDouble();
                        soItems.add(new SalesOrderItem(i + 1, soID, pidSo, qtySo, priceSo));
                    }
                    soItems.forEach(so::addItem);
                    so.processOrder(products);
                    break;

                case 5:
                    // Add Customer
                    System.out.print("Enter Customer ID: ");
                    int custIDToAdd = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String custName = sc.nextLine();
                    System.out.print("Enter Customer Contact Number: ");
                    String custContact = sc.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String custEmail = sc.nextLine();
                    System.out.print("Enter Customer Address: ");
                    String custAddress = sc.nextLine();
                    customers.add(new Customer(custIDToAdd, custName, custContact, custEmail, custAddress));
                    System.out.println("Customer added successfully!");
                    break;

                case 6:
                    // Delete Customer
                    System.out.print("Enter Customer ID to delete: ");
                    int deleteCustID = sc.nextInt();
                    customers.removeIf(customer -> customer.getCustomerID() == deleteCustID);
                    System.out.println("Customer deleted successfully!");
                    break;

                case 7:
                    // Add Supplier
                    System.out.print("Enter Supplier ID: ");
                    int supIDToAdd = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Supplier Name: ");
                    String supName = sc.nextLine();
                    System.out.print("Enter Supplier Contact Number: ");
                    String supContact = sc.nextLine();
                    System.out.print("Enter Supplier Email: ");
                    String supEmail = sc.nextLine();
                    System.out.print("Enter Supplier Address: ");
                    String supAddress = sc.nextLine();
                    suppliers.add(new Supplier(supIDToAdd, supName, supContact, supEmail, supAddress));
                    System.out.println("Supplier added successfully!");
                    break;

                case 8:
                    // Delete Supplier
                    System.out.print("Enter Supplier ID to delete: ");
                    int deleteSupID = sc.nextInt();
                    suppliers.removeIf(supplier -> supplier.getSupplierID() == deleteSupID);
                    System.out.println("Supplier deleted successfully!");
                    break;

                case 9:
                    // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
        sc.close();
    }

    // === Utility Methods ===

    public static void quickSort(List<Product> products, int low, int high) {
        if (low < high) {
            int pi = partition(products, low, high);
            quickSort(products, low, pi - 1);
            quickSort(products, pi + 1, high);
        }
    }

    private static int partition(List<Product> products, int low, int high) {
        int pivot = products.get(high).getProductID();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (products.get(j).getProductID() < pivot) {
                i++;
                Collections.swap(products, i, j);
            }
        }
        Collections.swap(products, i + 1, high);
        return i + 1;
    }

    public static Product binarySearch(List<Product> products, int targetID) {
        int low = 0;
        int high = products.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = products.get(mid);
            if (midProduct.getProductID() == targetID) {
                return midProduct;
            } else if (midProduct.getProductID() < targetID) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
