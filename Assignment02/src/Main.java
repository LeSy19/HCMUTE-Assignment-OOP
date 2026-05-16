import model.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        // Tạo sản phẩm bằng nhiều constructor
        Product p1 = new Product();

        Product p2 = new Product(
                "MacBook Air M2",
                2500);

        Product p3 = new Product(
                "iPhone 15",
                1200,
                10);

        Product p4 = new Product(
                "Dell XPS",
                2000,
                5);

        // Hiển thị thông tin
        System.out.println("===== DANH SÁCH SẢN PHẨM =====");

        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();

        // Bán hàng
        System.out.println("===== BÁN HÀNG =====");

        p3.sell(3);

        // Lỗi bán quá số lượng
        p4.sell(100);

        // Nhập thêm hàng
        System.out.println("\n===== NHẬP HÀNG =====");

        p4.restock(20);

        // Báo cáo cửa hàng
        System.out.println("\n"
                + Product.getStoreReport());

        // Kiểm tra mã sản phẩm
        System.out.println("\n===== MÃ SẢN PHẨM =====");

        System.out.println(p1.getProductCode());
        System.out.println(p2.getProductCode());
        System.out.println(p3.getProductCode());
        System.out.println(p4.getProductCode());
    }
}
