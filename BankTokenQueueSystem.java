import java.util.Scanner;

class Queue {

    // Maximum capacity of the queue
    static final int MAX = 10;

    // Array to store queue elements
    int[] queue;

    // Front and rear variables
    int front;
    int rear;

    // Constructor
    Queue() {

        queue = new int[MAX];

        // Initially queue is empty
        front = 0;
        rear = -1;
    }

    // 1. Enqueue
    void enqueue(int value) {

        // Check overflow
        if (isFull()) {
            System.out.println("Queue Overflow! Queue is full.");
            return;
        }

        rear++;
        queue[rear] = value;

        System.out.println(value + " added to the queue.");
    }

    // 2. Dequeue
    void dequeue() {

        // Check underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return;
        }

        System.out.println("Dequeued value: " + queue[front]);

        front++;

        // Reset queue when it becomes empty
        if (front > rear) {
            front = 0;
            rear = -1;
        }
    }

    // 3. Display
    void display() {

        // Check if queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\nQueue elements (Front to Rear):");

        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }

    // 4. Size
    void size() {

        if (isEmpty()) {
            System.out.println("Current queue size: 0");
        } else {
            System.out.println("Current queue size: " + (rear - front + 1));
        }
    }

    // 5. isEmpty
    boolean isEmpty() {

        return rear == -1;
    }

    // 6. isFull
    boolean isFull() {

        return rear == MAX - 1;
    }
}


// Main class
public class  BankTokenQueueSystem
 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Queue object
        Queue q = new Queue();

        int choice;

        // Menu-driven program
        do {

            System.out.println("\n----- Bank Token Queue System -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter token number: ");
                    int value = input.nextInt();

                    q.enqueue(value);

                    break;


                case 2:

                    q.dequeue();

                    break;


                case 3:

                    q.display();

                    break;


                case 4:

                    q.size();

                    break;


                case 5:

                    if (q.isEmpty()) {
                        System.out.println("Queue is Empty.");
                    } else {
                        System.out.println("Queue is Not Empty.");
                    }

                    break;


                case 6:

                    if (q.isFull()) {
                        System.out.println("Queue is Full.");
                    } else {
                        System.out.println("Queue is Not Full.");
                    }

                    break;


                case 7:

                    System.out.println("Program exited successfully.");

                    break;


                default:

                    System.out.println("Invalid choice! Please select 1 to 7.");
            }

        } while (choice != 7);

        input.close();
    }
}