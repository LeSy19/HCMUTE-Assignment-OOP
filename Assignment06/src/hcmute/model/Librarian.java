package hcmute.model;

import java.time.LocalDate;

import hcmute.service.Library;

public class Librarian {

    private String librarianId;
    private String fullName;

    public Librarian(String librarianId, String fullName) {
        this.librarianId = librarianId;
        this.fullName = fullName;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // kiem tra the
    public boolean checkReaderCard(Reader reader) {
        return reader != null;
    }

    // kiem tra sach
    public boolean checkBookAvailability(Book book) {
        return book.checkAvailability();
    }

    // tao phieu muon
    public void createBorrowSlip(Library library, Reader reader, Book book, String slipId) {

        // Kiểm tra số lượng sách
        if (!book.checkAvailability()) {
            System.out.println("Book out of stock!");
            return;
        }

        // Đếm số sách đang mượn
        int borrowingCount = 0;

        for (BorrowSlip slip : library.getBorrowSlips()) {

            if (slip.getReader().equals(reader)
                    && slip.getReturnDate() == null) {

                borrowingCount++;
            }
        }

        // Kiểm tra giới hạn
        if (borrowingCount >= reader.getMaxBorrowLimit()) {

            System.out.println("Borrow limit exceeded!");
            return;
        }

        // Giảm kho
        book.descreaseQuantity();

        // Tạo phiếu
        BorrowSlip slip = new BorrowSlip(slipId, LocalDate.now(), LocalDate.now().plusDays(7), null, 0, reader, book);

        library.addBorrowSlips(slip);

        System.out.println("Borrow book successfully!");

    }

    public void searchBooksByTitle(Library library, String title) {
        library.searchBooksByTitle(title);
    }

    public void searchBookByAuthor(Library library, String author) {
        library.searchBooksByAuthor(author);
    }

    public void viewOverdueSlips(Library library, LocalDate currentDate) {
        library.getOverdueSlips(currentDate);
    }

}
