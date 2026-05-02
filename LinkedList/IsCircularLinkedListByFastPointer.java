public class IsCircularLinkedListByFastPointer {

    // Java program to check if linked list is circular

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }



    // Function to check if the linked list is circular
    static boolean isCircular(Node head) {
        if (head == null)
            return true;

        Node slow = head;
        Node fast = head.next;

        // Traverse the linked list with two pointers
        // If next of fast pointer becomes null: exit the loop as we have reached the end of list
        // which proves it is not circular list
        while (fast != null && fast.next != null) {

            // If Slow and fast pointers become one and the same, it is a circular list
            if (slow == fast){
                return true;
            }

            // Slow Pointer will go 1 step forward
            // Fast Pointer will go 2 steps forward
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Check if the linked list is circular
        System.out.println(isCircular(head) ? "Yes" : "No");

        // Making the linked list circular
        head.next.next.next.next = head;

        // Check again if the linked list is circular
        System.out.println(isCircular(head) ? "Yes" : "No");
    }
}
