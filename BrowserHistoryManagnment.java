import java.util.Scanner;

class Stack {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            
            this.next = null;
        }
    }

    // Top of stack
    Node top;

    // Constructor
    Stack() {
        top = null;
    }

    // Push: Add element at top
    void push(int value) {

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed into stack.");
    }

    // Pop: Remove element from top
    void pop() {

        if (top == null) {
            System.out.println("Stack Underflow! Stack is empty.");
        } 
        else {
            System.out.println(top.data + " popped from stack.");

            top = top.next;
        }
    }

    // Peek: Show top element
    void peek() {

        if (top == null) {
            System.out.println("Stack is empty.");
        } 
        else {
            System.out.println("Top element = " + top.data);
        }
    }

    // Display stack
    void display() {

        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = top;

        System.out.println("Stack elements:");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == null;
    }

    // Find size of stack
    int size() {

        int count = 0;
        Node current = top;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}


public class BrowserHistoryManagnment {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Stack s = new Stack();

        int choice;
        int value;

        do {

            System.out.println("\n=====  BROWSER HISTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Is Empty");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    value = input.nextInt();

                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.peek();
                    break;

                case 4:
                    s.display();
                    break;

                case 5:
                    System.out.println("Stack size = " + s.size());
                    break;

                case 6:
                    if (s.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } 
                    else {
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 7:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        input.close();
    }
}