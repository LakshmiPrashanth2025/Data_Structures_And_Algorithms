class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
    }
}

class MyStackLinkedList {
    private StackNode top;

    public void push(int value) {
        StackNode node = new StackNode(value);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class StackWithLinkedList {
    public static void main(String[] args) {
        MyStackLinkedList stack = new MyStackLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.peek());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
