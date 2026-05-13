public class CheckForBST {

    // Java program to check if a tree is BST
    // Using specified range of Min and Max Values
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Helper function to check if a tree is BST within a given range
    static boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;

        // If the current node's data is not in the valid range, return false
        if (node.data < min || node.data > max)
            return false;

        // Recursively check the left and  right subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max);
    }

    // Function to check if the entire binary tree is a BST
    static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        // Create a sample binary tree
        // 10
        // / \
        // 5 20
        // / \
        // 9 25
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(9);
        root.right.right = new Node(25);

        if (isBST(root)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
