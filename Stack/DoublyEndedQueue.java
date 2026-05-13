public class DoublyEndedQueue {

    // Node definition
    private static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front, rear;
    private int size;

    // Constructor
    public DoublyEndedQueue() {
        front = rear = null;
        size = 0;
    }

    // Add an element to the front
    public void addFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    // Add an element to the rear
    public void addRear(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    // Remove an element from the front
    public int removeFront() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        int value = front.data;
        front = front.next;
        if (front != null) front.prev = null;
        else rear = null;
        size--;
        return value;
    }

    // Remove an element from the rear
    public int removeRear() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        int value = rear.data;
        rear = rear.prev;
        if (rear != null) rear.next = null;
        else front = null;
        size--;
        return value;
    }

    // Peek front
    public int peekFront() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        return front.data;
    }

    // Peek rear
    public int peekRear() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        return rear.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Display all elements
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main for quick test
    public static void main(String[] args) {
        DoublyEndedQueue deque = new DoublyEndedQueue();

        deque.addFront(10);
        deque.addRear(20);
        deque.addFront(5);
        deque.addRear(25);

        System.out.print("Deque: ");
        deque.display(); // Expected: 5 10 20 25

        System.out.println("Removed Front: " + deque.removeFront()); // 5
        System.out.println("Removed Rear: " + deque.removeRear());   // 25

        System.out.print("Deque after removals: ");
        deque.display(); // Expected: 10 20

        System.out.println("Front Element: " + deque.peekFront()); // 10
        System.out.println("Rear Element: " + deque.peekRear());   // 20
    }
}
