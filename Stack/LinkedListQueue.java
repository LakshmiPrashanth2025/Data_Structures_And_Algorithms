public class LinkedListQueue {
    // Node class for linked list
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front; // Points to front of queue
    private Node rear;  // Points to rear of queue
    private int size;
    private int capacity; // Optional: Simulate overflow

    // Constructor without capacity (infinite queue)
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.capacity = Integer.MAX_VALUE; // Simulate no overflow
    }

    // Constructor with capacity
    public LinkedListQueue(int capacity) {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.capacity = capacity;
    }

    // Enqueue operation
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow. Cannot enqueue " + value);
            return false;
        }

        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    // Dequeue operation
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue.");
            return null;
        }

        int value = front.data;
        front = front.next;
        size--;

        // If the queue becomes empty, update rear as well
        if (front == null) {
            rear = null;
        }

        return value;
    }

    // Check if the queue is full (only relevant if capacity is set)
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Optional: Print the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.displayQueue();

        // Try to overflow
        queue.enqueue(60);

        queue.dequeue();
        queue.dequeue();
        queue.displayQueue();

        queue.enqueue(60);
        queue.enqueue(70); // Should trigger overflow
        queue.displayQueue();
    }
}
