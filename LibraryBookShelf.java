import java.util.Scanner;

public class LibraryBookShelf {

    static final int MAX = 10;
    static int[] bookIDs = new int[MAX];
    static int size = 0;

    static Scanner input = new Scanner(System.in);

    // 1. Add a book ID at the end
    static void addBook() {
        if (size == MAX) {
            System.out.println("The bookshelf is full!");
            return;
        }

        System.out.print("Enter Book ID: ");
        int id = input.nextInt();

        bookIDs[size] = id;
        size++;

        System.out.println("Book added successfully.");
    }

    // 2. Insert a book ID at a specific index
    static void insertBook() {
        if (size == MAX) {
            System.out.println("The bookshelf is full!");
            return;
        }

        System.out.print("Enter index (0 to " + size + "): ");
        int index = input.nextInt();

        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.print("Enter Book ID: ");
        int id = input.nextInt();

        for (int i = size; i > index; i--) {
            bookIDs[i] = bookIDs[i - 1];
        }

        bookIDs[index] = id;
        size++;

        System.out.println("Book inserted successfully.");
    }

    // 3. Fill the bookshelf with multiple book IDs
    static void fillArray() {
        if (size == MAX) {
            System.out.println("The bookshelf is already full!");
            return;
        }

        while (size < MAX) {
            System.out.print("Enter Book ID (or -1 to stop): ");
            int id = input.nextInt();

            if (id == -1) {
                break;
            }

            bookIDs[size] = id;
            size++;

            System.out.println("Book ID added.");

            if (size == MAX) {
                System.out.println("The bookshelf is now full.");
            }
        }
    }

    // 4. Delete the last book ID
    static void deleteLast() {
        if (size == 0) {
            System.out.println("The bookshelf is empty!");
            return;
        }

        System.out.println("Deleted Book ID: " + bookIDs[size - 1]);
        size--;

        System.out.println("Last book deleted successfully.");
    }

    // 5. Delete a book ID by index
    static void deleteByIndex() {
        if (size == 0) {
            System.out.println("The bookshelf is empty!");
            return;
        }

        System.out.print("Enter index to delete (0 to "
                + (size - 1) + "): ");
        int index = input.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.println("Deleted Book ID: " + bookIDs[index]);

        for (int i = index; i < size - 1; i++) {
            bookIDs[i] = bookIDs[i + 1];
        }

        size--;

        System.out.println("Book deleted successfully.");
    }

    // 6. Display all book IDs
    static void displayBooks() {
        if (size == 0) {
            System.out.println("The bookshelf is empty!");
            return;
        }

        System.out.println("\n--- BOOKS ON THE SHELF ---");

        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i
                    + " : Book ID " + bookIDs[i]);
        }
    }

    // 7. Search for a book ID
    static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = input.nextInt();

        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (bookIDs[i] == id) {
                System.out.println(
                        "Book ID found at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book ID not found.");
        }
    }

    // 8. Get a book ID at a specific index
    static void getBook() {
        System.out.print("Enter index (0 to "
                + (size - 1) + "): ");
        int index = input.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.println("Book ID at index "
                + index + " is " + bookIDs[index]);
    }

    // 9. Replace or update a book ID
    static void updateBook() {
        System.out.print("Enter index to update (0 to "
                + (size - 1) + "): ");
        int index = input.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.println("Current Book ID: "
                + bookIDs[index]);

        System.out.print("Enter new Book ID: ");
        int newID = input.nextInt();

        bookIDs[index] = newID;

        System.out.println("Book ID updated successfully.");
    }

    // 10. Show the current number of books
    static void showSize() {
        System.out.println("Total books on the shelf: " + size);
        System.out.println("Shelf capacity: " + MAX);
        System.out.println("Available spaces: " + (MAX - size));
    }

    // Display the library bookshelf menu
    static void showMenu() {
        System.out.println("\n===== LIBRARY BOOKSHELF MENU =====");
        System.out.println("1. Add Book ID");
        System.out.println("2. Insert Book ID at Index");
        System.out.println("3. Fill Bookshelf");
        System.out.println("4. Delete Last Book");
        System.out.println("5. Delete Book by Index");
        System.out.println("6. Display All Books");
        System.out.println("7. Search Book ID");
        System.out.println("8. Get Book ID at Index");
        System.out.println("9. Replace/Update Book ID");
        System.out.println("10. Show Number of Books");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {
            showMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    insertBook();
                    break;

                case 3:
                    fillArray();
                    break;

                case 4:
                    deleteLast();
                    break;

                case 5:
                    deleteByIndex();
                    break;

                case 6:
                    displayBooks();
                    break;

                case 7:
                    searchBook();
                    break;

                case 8:
                    getBook();
                    break;

                case 9:
                    updateBook();
                    break;

                case 10:
                    showSize();
                    break;

                case 11:
                    System.out.println(
                            "Exiting Library Bookshelf System. Goodbye!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please select 1 to 11.");
            }

        } while (choice != 11);

        input.close();
    }
}
