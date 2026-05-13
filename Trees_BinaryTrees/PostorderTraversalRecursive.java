class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class PostorderTraversalRecursive {
    Node root;

    void postOrder(Node node) {
        if (node == null)
            return;

        // First recur on left subtree
        postOrder(node.left);

        // Then recur on right subtree
        postOrder(node.right);

        // Now deal with the node
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        PostorderTraversalRecursive tree = new PostorderTraversalRecursive();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Postorder traversal:");
        tree.postOrder(tree.root);
    }
}
