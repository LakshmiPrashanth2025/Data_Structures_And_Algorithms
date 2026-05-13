// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class InorderTraversalRecursive {

    // Recursive method to perform inorder traversal
    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);         // Visit left subtree
        System.out.print(root.val + " ");    // Visit root
        inorderTraversal(root.right);        // Visit right subtree
    }

    public static void main(String[] args) {
        // Sample binary tree: 
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversalRecursive tree = new InorderTraversalRecursive();
        tree.inorderTraversal(root); // Output: 1 3 2
    }
}
