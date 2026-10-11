
import java.util.Scanner;

class LinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int size = 0;

    // Insert at beginning
    void insertAtBeginning(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
        size++;

        System.out.println("Node inserted successfully.");
    }

    // Insert at end
    void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        System.out.println("Node inserted successfully.");
    }

    // Insert at a specific position (0-based)
    void insertAtPosition(int value, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            insertAtBeginning(value);
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;

        size++;
        System.out.println("Node inserted successfully.");
    }

    // Delete from beginning
    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted: " + head.data);
        head = head.next;
        size--;
    }

    // Delete from end
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
        } else {
            Node current = head;

            while (current.next.next != null) {
                current = current.next;
            }

            System.out.println("Deleted: " + current.next.data);
            current.next = null;
        }

        size--;
    }

    // Delete from a specific position (0-based)
    void deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            deleteFromBeginning();
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        System.out.println("Deleted: " + current.next.data);
        current.next = current.next.next;
        size--;
    }

    // Display list
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        System.out.print("HEAD -> ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // Search for a value
    void search(int value) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == value) {
                System.out.println(
                    value + " found at position " + position
                );
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found.");
    }

    // Return size
    int getSize() {
        return size;
    }
}

public class StudentRecordManagnment{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice, value, position;

        do {
            System.out.println("\n===== Student Record Managnment System =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display");
            System.out.println("8. Search");
            System.out.println("9. Size");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = input.nextInt();
                    list.insertAtBeginning(value);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    value = input.nextInt();
                    list.insertAtEnd(value);
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    value = input.nextInt();
                    System.out.print("Enter position (starting at 0): ");
                    position = input.nextInt();
                    list.insertAtPosition(value, position);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    list.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter position (starting at 0): ");
                    position = input.nextInt();
                    list.deleteAtPosition(position);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.print("Enter value to search: ");
                    value = input.nextInt();
                    list.search(value);
                    break;

                case 9:
                    System.out.println("Size = " + list.getSize());
                    break;

                case 10:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        input.close();
    }
}
