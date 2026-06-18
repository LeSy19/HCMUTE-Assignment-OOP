package model;

import java.util.List;

import service.Borrowable;
import service.Notifiable;

public class LibraryManager {
    public void processAllBorrowable(List<Borrowable> items) {
        System.out.println("=== BORROWABLE ITEM STATUS ===");
        for (Borrowable item : items) {
            String s = item.isAvailable()
                    ? "Available"
                    : "Borrowed by " + item.getBorrowId();
            System.out.println("  -> " + s);
        }
    }

    public void notifyAll(List<Notifiable> users, String message) {
        System.out.println("=== SENDING NOTIFICATIONS ===");
        for (Notifiable user : users) {
            user.sendNotification(message);
        }

    }
}
