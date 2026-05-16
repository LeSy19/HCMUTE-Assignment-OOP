public class Book {
    String title;
    String author;
    int year;
    double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        year = 2000;
        price = 0;
    }

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000;
    }

    public void displayInfo() {
        System.out.println("Sách: " + title + " - Tác giả: " + author + " - Năm: " + year + " - Giá: " + price);
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }

    public static void main(String[] args) {
        Book b1 = new Book();

        Book b2 = new Book("Tren duong bang", "Sy Le", 1957, 15.99);

        Book b3 = new Book("Đắc Nhân Tâm", "Nguyễn Nhật Ánh");

        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();

        b3.applyDiscount(10);
        System.out.println("Giá sau khi giảm ");
        b3.displayInfo();

    }
}
