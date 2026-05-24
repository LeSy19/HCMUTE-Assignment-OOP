import hcmute.model.Book;
import hcmute.model.Librarian;
import hcmute.model.Library;
import hcmute.model.Reader;

public class Main {
    public static void main(String[] args) throws Exception {

        Library library = new Library();

        Librarian librarian = new Librarian("L01", "Nguyen Van Admin");

        // Thêm sách
        Book b1 = new Book(
                "B01",
                "Java Programming",
                "James Gosling",
                2020,
                5,
                0);

        Book b2 = new Book(
                "B02",
                "Database System",
                "Thomas Connolly",
                2019,
                3,
                2);

        library.addBooks(b1);
        library.addBooks(b2);

        // Thêm độc giả
        Reader r1 = new Reader(
                "R01",
                "Nguyen Van A",
                "abc@gmail.com",
                "Sinh viên");

        Reader r2 = new Reader(
                "R02",
                "Tran Thi B",
                "sy@gmail.com",
                "Giảng viên");

        library.addReaders(r1);
        library.addReaders(r2);

        // Tìm kiếm sách theo tên
        library.searchBooksByTitle("Database");

        // Tìm kiếm sách theo tác giả
        library.searchBooksByAuthor("James");

        // ===== TRƯỚC KHI MƯỢN =====
        System.out.println("===== BOOK BEFORE BORROW =====");
        b1.displayInfo();

        // ===== MƯỢN SÁCH =====
        librarian.createBorrowSlip(
                library,
                r1,
                b1,
                "B01");

        // ===== SAU KHI MƯỢN =====
        System.out.println("\n===== BOOK AFTER BORROW =====");
        b1.displayInfo();

        library.getOverdueSlips(java.time.LocalDate.now().plusDays(8));
    }
}
