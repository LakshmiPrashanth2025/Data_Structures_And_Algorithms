

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow. Cannot enqueue " + value);
            return false;
        }
        // First element
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    // Dequeue operation
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue.");
            return null;
        }
        int value = queue[front];
        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return value;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Optional: Print the queue for debugging
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.displayQueue();

        // Attempt to overflow
        cq.enqueue(60);

        cq.dequeue();
        cq.dequeue();
        cq.displayQueue();

        cq.enqueue(60);
        cq.enqueue(70);
        cq.displayQueue();
    }
}
