class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // Push element onto stack
    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack Overflow: Cannot push " + value + ", stack is full.");
        }
        stack[++top] = value;
    }

    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from empty stack.");
        }
        return stack[top--];
    }

    // Peek top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Stack is empty.");
        }
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get current size of stack
    public int size() {
        return top + 1;
    }
}

public class StackWithArray {
    
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);

        // Push 3 elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        try {
            // This should throw StackOverflowError
            stack.push(40);
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
        }

        // Pop 3 elements
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        try {
            // This should throw StackUnderflow exception
            System.out.println("Popped: " + stack.pop());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
