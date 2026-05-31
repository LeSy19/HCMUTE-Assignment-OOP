package hcmute.main;

import hcmute.model.Book;
import hcmute.model.Lecturer;
import hcmute.model.Librarian;
import hcmute.model.Reader;
import hcmute.model.Student;
import hcmute.service.Library;

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
                Reader sv = new Student("001", "Le Van Sy", "sy@gmail.com");
                Reader gv = new Lecturer("002", "Phan Hieu Nghia", "nghia@gmail.com");

                library.addReaders(sv);
                library.addReaders(gv);

                // // Tìm kiếm sách theo tên
                // library.searchBooksByTitle("Database");

                // // Tìm kiếm sách theo tác giả
                // library.searchBooksByAuthor("James");

                // // ===== TRƯỚC KHI MƯỢN =====
                // System.out.println("===== BOOK BEFORE BORROW =====");
                // b1.displayInfo();

                // // ===== MƯỢN SÁCH =====
                // librarian.createBorrowSlip(
                // library,
                // r1,
                // b1,
                // "B01");

                // // ===== SAU KHI MƯỢN =====
                // System.out.println("\n===== BOOK AFTER BORROW =====");
                // b1.displayInfo();

                // library.getOverdueSlips(java.time.LocalDate.now().plusDays(8));

                System.out.println("===== DANH SACH SACH =====");
                library.showAllBooks();

                System.out.println("===== DANH SACH DOC GIA =====");
                library.showAllReaders();

                System.out.println("===== TINH PHI TRE HAN =====");
                library.showLateFee(7);

                System.out.println("===== HAN MUON =====");
                Reader[] reader = { sv, gv };
                for (Reader r : reader) {
                        System.out.println(r.getFullName() + ": " + r.getMaxBorrow() + " cuon");
                }
        }
}
