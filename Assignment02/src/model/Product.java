package model;

import util.ProductValidator;

public class Product {
    private String productCode;
    private String name;
    private double price;
    private int quantity;

    // Static
    private static int counter = 1;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    // Constructor không tham số
    public Product() {
        this.name = "Unknown";
        this.quantity = 0;
        this.price = 0;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    // Constructor 3 tham số
    public Product(String name, double price, int quantity) {

        // Tự động tạo mã sản phẩm
        this.productCode = String.format("P-%04d", counter);
        counter++;

        // Validation
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }

        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            this.price = 0;
        }

        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

        totalProducts++;
    }

    // Getter
    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setName(String name) {

        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Tên sản phẩm không hợp lệ!");
        }
    }

    public void setPrice(double price) {

        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            System.out.println("Giá sản phẩm không hợp lệ!");
        }
    }

    public void setQuantity(int quantity) {

        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            System.out.println("Số lượng không hợp lệ!");
        }
    }

    public void sell(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;

            totalRevenue += amount * price;

            System.out.println("Bán thành công " + amount + " sản phẩm.");
        } else {
            System.out.println("Loi!!!");
        }
    }

    public void restock(int amount) {
        if (amount <= 0) {
            System.out.println("Số lượng nhập phải > 0");
            return;
        }

        quantity += amount;

        System.out.println("Nhập thêm " + amount + " sản phẩm.");
    }

    public void displayInfo() {
        System.out.println("Mã SP: " + productCode);
        System.out.println("Tên SP: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Số lượng: " + quantity);

        System.out.println("--------------------------");
    }

    // Static method
    public static int getTotalProducts() {
        return totalProducts;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static String getStoreReport() {

        return "===== BÁO CÁO CỬA HÀNG =====\n"
                + "Tổng sản phẩm: " + totalProducts + "\n"
                + "Tổng doanh thu: " + totalRevenue;
    }

}
