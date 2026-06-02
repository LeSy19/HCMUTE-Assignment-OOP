package hcmute.model;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;
    private int borrowCount;
    private boolean referenceOnly; // Sách tham khảo chỉ đọc tại chỗ

    public Book(String bookId, String title, String author, int publishYear, int quantity, int borrowCount,
            boolean referenceOnly) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.borrowCount = 0;
        this.referenceOnly = referenceOnly; // Sử dụng giá trị được truyền vào
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public boolean isReferenceOnly() {
        return referenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        this.referenceOnly = referenceOnly;
    }

    public boolean checkAvailability() {
        if (quantity > 0) {
            return true;
        } else {
            System.out.println("Sách " + title + " đã hết hàng.");
            return false;
        }
    }

    public void descreaseQuantity() {
        if (quantity > 0) {
            quantity--;
            borrowCount++;
        }
    }

    public void increaseQuantity() {
        quantity++;
    }

    // Hiển thị thông tin
    public void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publish Year: " + publishYear);
        System.out.println("Quantity: " + quantity);
    }
}
