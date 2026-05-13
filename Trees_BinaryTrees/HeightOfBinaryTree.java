/*
 * The height of a binary tree is the length of the longest path from the root node to any leaf node, which
 */
public class HeightOfBinaryTree {

    // Method to calculate height of binary tree
    public int height(TreeNode root) {
        if (root == null) {
            return -1; // Use 0 if you define height of empty tree as 0
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Sample usage
    public static void main(String[] args) {
        /*

       1
       / \
      2   3
     / \
    4   5
    
       */
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Height of tree: " + tree.height(root)); // Output: 2
    }
}



// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}
