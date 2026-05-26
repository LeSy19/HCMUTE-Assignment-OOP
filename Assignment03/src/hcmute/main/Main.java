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
                Student r1 = new Student(
                                "R01",
                                "Nguyen Van A",
                                "abc@gmail.com");

                Student r2 = new Student(
                                "R02",
                                "Tran Thi B",
                                "sy@gmail.com");

                // Thêm độc giả
                Lecturer l1 = new Lecturer(
                                "L01",
                                "Nguyen Van A",
                                "abc@gmail.com");

                Lecturer l2 = new Lecturer(
                                "L02",
                                "Tran Thi B",
                                "sy@gmail.com");

                library.addReaders(r1);
                library.addReaders(r2);
                library.addReaders(l1);
                library.addReaders(l2);

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
                library.displayBooks();

                System.out.println("===== DANH SACH DOC GIA =====");
                library.displayReaders();

        }
}
