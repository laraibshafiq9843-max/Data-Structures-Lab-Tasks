
import java.util.Scanner;

class Queue {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Front and rear of queue
    Node front;
    Node rear;

    // Constructor
    Queue() {
        front = null;
        rear = null;
    }

    // Enqueue: Add element at rear
    void enqueue(int value) {

        Node newNode = new Node(value);

        // If queue is empty
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } 
        else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(value + " added to queue.");
    }

    // Dequeue: Remove element from front
    void dequeue() {

        if (front == null) {
            System.out.println("Queue Underflow! Queue is empty.");
        } 
        else {
            System.out.println(front.data + " removed from queue.");

            front = front.next;

            // If queue becomes empty
            if (front == null) {
                rear = null;
            }
        }
    }

    // Display queue
    void display() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;

        System.out.println("Queue elements:");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // Find size of queue
    int size() {

        int count = 0;
        Node current = front;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}


public class HospitalWaitingListSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Queue q = new Queue();

        int choice;
        int value;

        do {

            System.out.println("\n===== HOSPITAL PATIENT WAITING LIST =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. Is Empty");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    value = input.nextInt();

                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    System.out.println("Queue size = " + q.size());
                    break;

                case 5:
                    if (q.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } 
                    else {
                        System.out.println("Queue is not empty.");
                    }
                    break;

                case 6:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        input.close();
    }
}