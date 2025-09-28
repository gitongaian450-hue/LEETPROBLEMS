import java.util.Scanner;

class Stack {
    // Step 1: Define the maximum size of the stack
    final int N = 5;
    int[] stack = new int[N];
    int top = -1;  // Start with empty stack

    Scanner input = new Scanner(System.in);

    // Step 2: Push method
    void push() {
        System.out.print("Enter the value to push: ");
        int x = input.nextInt();

        if (top == N - 1) {   // If top is at the last index
            System.out.println("STACK OVERFLOW");
        } else {
            top++;
            stack[top] = x;
            System.out.println(x + " pushed into stack.");
        }
    }

    // Step 3: Pop method
    void pop() {
        if (top == -1) {   // Empty stack
            System.out.println("STACK UNDERFLOW");
        } else {
            int item = stack[top];
            top--;
            System.out.println(item + " popped from stack.");
        }
    }

    // Step 4: Peek method (to check the top element)
    void peek() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    // Step 5: Display method
    void display() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class STACK {
    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    s.push();
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
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}