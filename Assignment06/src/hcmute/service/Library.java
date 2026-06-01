package hcmute.service;

import java.time.LocalDate;
import java.util.ArrayList;

import hcmute.model.Book;
import hcmute.model.BorrowSlip;
import hcmute.model.Reader;
import hcmute.model.SeniorReader;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;
    private ArrayList<BorrowSlip> borrowSlips;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.borrowSlips = new ArrayList<>();
    }

    // Getter
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<BorrowSlip> getBorrowSlips() {
        return borrowSlips;
    }

    // Them sach
    public ArrayList<Book> addBooks(Book book) {
        books.add(book);
        return books;
    }

    // Them doc gia
    public ArrayList<Reader> addReaders(Reader reader) {
        readers.add(reader);
        return readers;
    }

    // them phieu muon
    public ArrayList<BorrowSlip> addBorrowSlips(BorrowSlip borrowSlip) {
        borrowSlips.add(borrowSlip);
        return borrowSlips;
    }

    // Tim kiem sach theo ten
    public void searchBooksByTitle(String title) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.displayInfo();
                found = true;
            }

        }
        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    // Tim kiem ten doc gia
    public Reader findReaderByName(String keyword) {

        for (Reader reader : readers) {
            if (reader.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                return reader;
            }

        }
        return null;
    }

    // Tim kiem ten tac gia
    public void searchBooksByAuthor(String author) {

        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with author: " + author);
        }
    }

    public void getOverdueSlips(LocalDate currentDate) {
        for (BorrowSlip slip : borrowSlips) {
            if (slip.isOverdue(currentDate)) {
                slip.displaySlip();
            } else {
                System.out.println("No overdue slips found.");
            }
        }
    }

    // in danh sach book
    public void showAllBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }

    // In danh sách độc giả
    public void showAllReaders() {

        System.out.println("\n===== DANH SACH DOC GIA (" + readers.size() + " nguoi) =====");

        for (Reader reader : readers) {
            System.out.println(reader.getInfo());
        }
    }

    // In phí phạt của tất cả độc giả (giả sử daysLate = 7)
    public void showLateFee(int daysLate) {
        System.out.println("======= PHI PHAT TRE HAN: (" + daysLate + " ngay) ========");
        for (Reader reader : readers) {
            System.out.printf("%-25s | Fee: %,.0f VND%n",
                    reader.getFullName(), reader.calculateLateFee(daysLate));
        }
    }

    public double caculateTotalLateFee(int daysLate) {
        double totalFee = 0.0;
        for (Reader reader : readers) {
            totalFee += reader.calculateLateFee(daysLate);
        }
        return totalFee;
    }

    public void printSeniorReaders() {
        System.out.println("======= DOC GIA NGUOI CAO TUOI =======");
        int count = 0;
        for (Reader r : readers) {
            if (r instanceof SeniorReader) { // kiem tra kieu thuc te
                SeniorReader sr = (SeniorReader) r; // downcast an toan
                System.out.println(sr.getInfo());
                System.out.println("Ma the NCT: " + sr.getSeniorCardNumber());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("CHUA CO DOC GIA NGUOI CAO TUOI");
        }
    }

}
