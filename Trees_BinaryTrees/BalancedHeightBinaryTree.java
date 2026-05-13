/*
 * Check if it is height balanced
 * A balanced binary tree or height-balanced binary tree is such a tree whose left and right subtrees' heights 
 * differ by not more than 1, which means the height difference could be -1, 0, and 1
 */
public class BalancedHeightBinaryTree {
    
    // Helper method returns -1 if subtree is not balanced, otherwise returns height
    private static int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; // left subtree not balanced

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1; // current node not balanced

        // Return Height of BinaryTree at this Node   
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Test the code
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);  // This makes it unbalanced

        System.out.println("Is tree balanced? " + isBalanced(root)); // Output: false
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

