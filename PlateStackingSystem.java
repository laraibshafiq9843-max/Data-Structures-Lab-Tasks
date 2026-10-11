import java.util.Scanner;

class Stack {

    // Maximum capacity of stack
    static final int MAX = 10;

    // Array to store stack values
    int[] stack;

    // Top variable
    int top;

    // Constructor
    Stack() {
        stack = new int[MAX];
        top = -1;
    }

    // 1. Push
    void push(int value) {

        // Check if stack is full
        if (top == MAX - 1) {
            System.out.println("Stack Overflow! Stack is full.");
            return;
        }

        // Increase top
        top++;

        // Store value
        stack[top] = value;

        System.out.println("Value pushed successfully.");
    }

    // 2. Pop
    void pop() {

        // Check if stack is empty
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }

        // Store top value
        int value = stack[top];

        // Decrease top
        top--;

        System.out.println("Popped value: " + value);
    }

    // 3. Display
    void display() {

        // Check if stack is empty
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack values (Top to Bottom):");

        // Start from top and move downward
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // 4. Size
    void size() {

        System.out.println("Current stack size: " + (top + 1));
    }

    // 5. isEmpty
    void isEmpty() {

        if (top == -1) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack is NOT Empty.");
        }
    }

    // 6. isFull
    void isFull() {

        if (top == MAX - 1) {
            System.out.println("Stack is Full.");
        } else {
            System.out.println("Stack is NOT Full.");
        }
    }
}


// Main class
public class PlateStackingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Stack object
        Stack s = new Stack();

        int choice;

        // Menu-driven program
        do {

            System.out.println("\n----- Plate Stacking System MENU -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter value to push: ");
                    int value = input.nextInt();

                    s.push(value);

                    break;


                case 2:

                    s.pop();

                    break;


                case 3:

                    s.display();

                    break;


                case 4:

                    s.size();

                    break;


                case 5:

                    s.isEmpty();

                    break;


                case 6:

                    s.isFull();

                    break;


                case 7:

                    System.out.println("Program exited successfully.");

                    break;


                default:

                    System.out.println(
                        "Invalid choice! Please select 1 to 7."
                    );
            }

        } while (choice != 7);

        input.close();
    }
}