public class FindLoopLengthInCircularLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Function to detect loop and find its length
    static int findLoopLength(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                return countLoopLength(slow); // Pass the meeting point
            }
        }

        // No loop
        return 0;
    }

    // Count number of nodes in the loop
    static int countLoopLength(Node nodeInLoop) {
        Node current = nodeInLoop;
        int count = 1;

        // Move until you come back to the same node
        while (current.next != nodeInLoop) {
            current = current.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create loop: 5 → 3
        head.next.next.next.next.next = head.next.next; // Node with value 3

        int loopLength = findLoopLength(head);

        if (loopLength > 0)
            System.out.println("Length of the loop is: " + loopLength);
        else
            System.out.println("No loop detected.");
    }
}

