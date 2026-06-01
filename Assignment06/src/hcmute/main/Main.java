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
                Reader sr = new SeniorReader("SR003", "Tran Van A", "a@gmail.com", "SC003");

                library.addReaders(sv);
                library.addReaders(gv);
                library.addReaders(sr);

                // 2.1 Dynamic biding qua showAllReaders
                library.showAllReaders();
                // 3 dong output, moi dong theo dinh dang rieng cua tung lop con

                // 2.2 Dynamic biding qua caculateTotalLateFee
                double total = library.caculateTotalLateFee(5);
                System.out.printf("\nTong tien phat neu qua han 5 ngay: %.0f VND%n", total);

                // 2.3 tim kiem va dung Dynamic biding tren ket qua
                Reader found = library.findReaderByName("sy");
                if (found != null) {
                        System.out.println(found.getInfo());
                        System.out.println(found.getMaxBorrow());
                }

                // 2.4 downcast an toan
                library.printSeniorReaders();
        }
}
