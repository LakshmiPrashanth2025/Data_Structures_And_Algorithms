// Function to find the ceiling of a given input in BST. 
// If the input is more than the max key in BST, return -1.
public class CeilInBSTIterative {

    static class Node {

        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static int findCeil(Node root, int key) {

        // -1 indicates no ceiling found yet
        int ceil = -1; // 

        //  you have come to end condition in the tree, where root becomes null (i.e.)
        //  where the node in tree is just greater than or equal the key being searched
        while (root != null) {

            // If root itself is ceil 
            if (root.data == key) {
                return root.data;
            }

            // If root's data is smaller, ceil must be in the right subtree
            if (key > root.data) 
            {
                root = root.right;
            }
            // Else either root can be ceil or a node in the left child
            else 
            {
                ceil = root.data;
                root = root.left;
            }

        }
        
        return ceil;
    }

    public static void main(String[] args) {
        Node root = new Node(8);

        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        // Testing for values from 0 to 15
        for (int i = 0; i < 16; i++) {
             System.out.println("key: " + i + " " + "ceil: " + findCeil(root, i));
        }
    }
}
