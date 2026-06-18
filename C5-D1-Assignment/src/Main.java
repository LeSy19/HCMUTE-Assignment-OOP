import java.util.ArrayList;
import java.util.List;

import Utils.LibraryUtils;
import model.Book;
import model.GenericStack;
import model.LibraryManager;
import model.Pair;
import model.Reader;
import service.Borrowable;
import service.Notifiable;

public class Main {
    public static void main(String[] args) {
        LibraryManager mgr = new LibraryManager();

        List<Borrowable> items = new ArrayList<>();
        Book b1 = new Book("B001", "Clean Code", "Robert Martin");
        Book b2 = new Book("B002", "Design Patterns", "GoF");
        b1.borrowBy("R001", "2024-09-01");
        items.add(b1);
        items.add(b2);
        mgr.processAllBorrowable(items);

        List<Notifiable> readers = new ArrayList<>();
        readers.add(new Reader("R001", "Nguyen Van A"));
        readers.add(new Reader("R002", "Tran Thi B"));
        mgr.notifyAll(readers, "Thu vien se dong cua ngay 20/9.");

        System.out.println("--- KIỂM THỬ BÀI 1: GENERIC STACK ---");

        // 1. Quản lý lịch sử hành động (String)
        GenericStack<String> historyStack = new GenericStack<>();
        historyStack.push("Muon sach B001");
        historyStack.push("Tra sach B002");
        historyStack.push("Cap nhat doc gia R001");

        System.out.println("Dinh ngan xep hien tai (peek): " + historyStack.peek());
        System.out.println("Pop lan 1: " + historyStack.pop());
        System.out.println("Pop lan 2: " + historyStack.pop());
        System.out.println("Dinh ngan xep sau khi pop: " + historyStack.peek());

        System.out.println();

        // 2. Quản lý mã lỗi (Integer)
        GenericStack<Integer> errorStack = new GenericStack<>();
        errorStack.push(100);
        errorStack.push(200);
        errorStack.push(404);

        System.out.print("Cac ma loi trong stack: ");
        while (!errorStack.isEmpty()) {
            System.out.print(errorStack.pop() + " "); // LIFO: 404, 200, 100
        }
        System.out.println("\n");

        System.out.println("--- KIỂM THỬ BÀI 2: GENERIC PAIR ---");

        // 1. Cặp (Mã sách, Số lượt mượn)
        Pair<String, Integer> book1 = new Pair<>("B001", 15);
        Pair<String, Integer> book2 = new Pair<>("B002", 8);

        System.out.println("Sach 1: " + book1);
        System.out.println("Sach 2: " + book2);

        if (Pair.comparePairs(book1, book2)) {
            System.out.println("-> Pair co luot muon cao hon hoac bang: " + book1);
        } else {
            System.out.println("-> Pair co luot muon cao hon: " + book2);
        }

        System.out.println();

        // 2. Cặp (Tên độc giả, Mã thẻ) và swap()
        Pair<String, String> readerInfo = new Pair<>("Nguyen Van A", "R001");
        System.out.println("Truoc khi swap: " + readerInfo);

        Pair<String, String> swappedInfo = Pair.swap(readerInfo);
        System.out.println("Sau khi swap : " + swappedInfo);
        System.out.println();

        System.out.println("--- KIỂM THỬ BÀI 3: LIBRARY UTILS ---");

        // --- 1. Kiểm thử findMin với mảng Book ---
        Book[] bookArray = {
                new Book("B003", "Java Core", "LVS"),
                new Book("B001", "Design Patterns", "PHN"),
                new Book("B002", "Effective Java", "LTNY")
        };
        // Book minBook = LibraryUtils.findMin(bookArray);
        // System.out.println("Sach co ID nho nhat: " + minBook);
        // System.out.println();

        // --- 2. Kiểm thử printAll với danh sách Reader ---
        List<Reader> readers1 = new ArrayList<>();
        readers1.add(new Reader("001", "Tran Thi B"));
        readers1.add(new Reader("002", "Le Van C"));

        System.out.println("Danh sach doc gia (printAll):");
        LibraryUtils.printAll(readers);
        System.out.println();

        // --- 3. Kiểm thử copyList (PECS) ---
        List<Book> srcBooks = new ArrayList<>();
        srcBooks.add(new Book("B004", "Clean Code", "SSS"));
        srcBooks.add(new Book("B005", "Refactoring", "PHN"));

        // dest có thể là List<Book> hoặc List<Object> (vì Object là super của Book)
        List<Object> destList = new ArrayList<>();
        destList.add("--- Log he thong truoc khi copy ---");

        // Thực hiện copy từ srcBooks (extends Book) vào destList (super Book)
        LibraryUtils.copyList(destList, srcBooks);

        System.out.println("Danh sach dich sau khi copyList:");
        LibraryUtils.printAll(destList);

    }

}
