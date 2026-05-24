package hcmute.model;

import java.time.LocalDate;

public class BorrowSlip {
    private String slipId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fineAmount;
    private Reader reader;
    private Book book;

    public BorrowSlip(String slipId, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, double fineAmount,
            Reader reader, Book book) {
        this.slipId = slipId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fineAmount = 0;
        this.reader = reader;
        this.book = book;
    }

    public String getSlipId() {
        return slipId;
    }

    public void setSlipId(String slipId) {
        this.slipId = slipId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Kiểm tra quá hạn
    public boolean isOverdue(LocalDate currentDate) {
        if (returnDate != null && returnDate.isAfter(dueDate)) {
            return true;
        }
        return false;
    }

    // Tính tiền phạt
    public double calculateFine() {
        if (returnDate != null && returnDate.isAfter(dueDate)) {
            long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
            fineAmount = daysOverdue * 5000; // Giả sử mỗi ngày quá hạn phạt 5000 VND

        }

        return fineAmount;

    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
        book.increaseQuantity();

        double fine = calculateFine();

        if (fine > 0) {
            System.out.println("Late fine: " + fine + " VND");
        } else {
            System.out.println("Returned successfully!");
        }
    }

    // Hiển thị phiếu
    public void displaySlip() {
        System.out.println("Slip ID: " + slipId);
        System.out.println("Reader: " + reader.getFullName());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Borrow Date: " + borrowDate);
        System.out.println("Due Date: " + dueDate);
    }

}
