import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.LibraryManager;
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

    }
}
