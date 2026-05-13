public class PreOrderTraversalRecursive {

    public void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Visit the root
        System.out.print(root.val + " ");
        
        // Traverse the left subtree
        preorderTraversal(root.left);
        
        // Traverse the right subtree
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Example binary tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreOrderTraversalRecursive tree = new PreOrderTraversalRecursive();
        System.out.println("Preorder traversal:");
        tree.preorderTraversal(root); // Output: 1 2 4 5 3
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


