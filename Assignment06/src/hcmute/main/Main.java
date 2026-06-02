package hcmute.main;

import hcmute.model.Book;
import hcmute.model.GuestAccount;
import hcmute.model.Lecturer;
import hcmute.model.LecturerAccount;
import hcmute.model.Librarian;
import hcmute.model.LibraryCard;
import hcmute.model.Reader;
import hcmute.model.SeniorReader;
import hcmute.model.Student;
import hcmute.service.Library;
import hcmute.service.Library.CharityFeePolicy;
import hcmute.service.Library.WaivedFeePolicy;

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
                                0,
                                true);

                Book b2 = new Book(
                                "B02",
                                "Database System",
                                "Thomas Connolly",
                                2019,
                                3,
                                2,
                                false);

                library.addBooks(b1);
                library.addBooks(b2);

                // Thêm độc giả
                Reader sv = new Student("001", "Le Van Sy", "sy@gmail.com");
                Reader gv = new Lecturer("002", "Phan Hieu Nghia", "nghia@gmail.com");
                Reader sr = new SeniorReader("SR003", "Tran Van A", "a@gmail.com", "SC003");

                library.addReaders(sv);
                library.addReaders(gv);
                library.addReaders(sr);

                // Tháng bình thường:
                System.out.println("=== Thang binh thuong ===");
                library.caculateTotalLateFee(7);

                // Tháng từ thiện — chỉ đổi policy, không sửa code Library
                library.setFeePolicy(library.new CharityFeePolicy());
                System.out.println("\n=== Thang tu thien ===");
                library.caculateTotalLateFee(7);

                // Tháng khai trương — miễn phí
                library.setFeePolicy(library.new WaivedFeePolicy());
                System.out.println("\n=== Thang khai truong ===");

        }
}
