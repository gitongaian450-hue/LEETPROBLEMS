import java.util.*;

// Book model
class Book {
    String id;
    String title;
    boolean isAvailable;

    Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }
}

// Library manager using HashMap + Stack
class LibraryManager {
    HashMap<String, Book> books = new HashMap<>();
    Stack<Book> recentReturns = new Stack<>();

    void addBook(String id, String title) {
        books.put(id, new Book(id, title));
        System.out.println("Book added successfully!");
    }

    void borrowBook(String id) {
        if (!books.containsKey(id)) {
            System.out.println("Book not found!");
            return;
        }
        Book b = books.get(id);
        if (!b.isAvailable) {
            System.out.println("Book already borrowed!");
        } else {
            b.isAvailable = false;
            System.out.println("Book borrowed: " + b.title);
        }
    }

    void returnBook(String id) {
        if (!books.containsKey(id)) {
            System.out.println("Book not found!");
            return;
        }
        Book b = books.get(id);
        b.isAvailable = true;
        recentReturns.push(b);
        System.out.println("Book returned: " + b.title);
    }

    void undoLastReturn() {
        if (recentReturns.isEmpty()) {
            System.out.println("No returns to undo!");
            return;
        }
        Book b = recentReturns.pop();
        b.isAvailable = false;
        System.out.println("Undo successful! Book borrowed again: " + b.title);
    }

    void viewAllBooks() {
        System.out.println("\nAll Books:");
        for (Book b : books.values()) {
            String status = b.isAvailable ? "Available" : "Borrowed";
            System.out.println(b.id + " | " + b.title + " | " + status);
        }
    }
}

// Main driver
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager lm = new LibraryManager();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Undo Last Return");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                String id = sc.next();
                sc.nextLine();
                System.out.print("Enter Title: ");
                String title = sc.nextLine();
                lm.addBook(id, title);
            } else if (choice == 2) {
                System.out.print("Enter Book ID: ");
                String id = sc.next();
                lm.borrowBook(id);
            } else if (choice == 3) {
                System.out.print("Enter Book ID: ");
                String id = sc.next();
                lm.returnBook(id);
            } else if (choice == 4) {
                lm.undoLastReturn();
            } else if (choice == 5) {
                lm.viewAllBooks();
            } else break;
        }
    }
}