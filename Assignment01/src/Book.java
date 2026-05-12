public class Book {
    String title;
    String author;
    double price;
    boolean instock;

    public Book(String title, String author, double price, boolean instock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.instock = instock;
    }

    // print info
    public void printInfo() {
        System.out.print("Title: " + title);
        System.out.print("Author: " + author);
        System.out.print("Price: " + price);
        System.out.println("In stock: " + instock);
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java", "Le Van Sy", 233, true);
        Book book2 = new Book("Python", "Vo Ho Chi", 122, true);
        Book book3 = new Book("JavaScript", "Le Yen", 100, true);

        System.out.println("=== Truoc giam gia ===");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();

        // Giảm 10%
        book1.applyDiscount(10);
        book2.applyDiscount(10);
        book3.applyDiscount(10);

        System.out.println("=== Sau giam gia ===");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
