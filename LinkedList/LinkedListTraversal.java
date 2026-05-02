public class LinkedListTraversal {// Internal node class// Node class
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private ListNode head;
    private ListNode currentNode; // for next() traversal

    // Insert at the end
    public void insert(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Insert at a given position (0-based)
    public void insertAtPosition(int position, int value) {
        ListNode newNode = new ListNode(value);
        if (position <= 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete first occurrence of value
    public void delete(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        // We will reach here only if (current.next,value == value)
        // In that case -> reset the next node bypassing/ deleting the next node 
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Reverse the list
    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        head = prev;
    }

    // Print list
    public void printList() {
        ListNode current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Reset iterator for next()
    public void resetIterator() {
        currentNode = head;
    }

    // Return value of next node during traversal
    public Integer next() {
        if (currentNode == null) return null;
        int value = currentNode.value;
        currentNode = currentNode.next;
        return value;
    }

    // Test
    public static void main(String[] args) {
        LinkedListTraversal list = new LinkedListTraversal();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.printList(); // 10 20 30 40

        list.insertAtPosition(2, 25);
        list.printList(); // 10 20 25 30 40

        list.delete(20);
        list.printList(); // 10 25 30 40

        list.reverse();
        list.printList(); // 40 30 25 10

        System.out.print("Using next(): ");
        list.resetIterator();

        Integer val;
        while ((val = list.next()) != null) {
            System.out.print(val + " ");
        }
    }
}