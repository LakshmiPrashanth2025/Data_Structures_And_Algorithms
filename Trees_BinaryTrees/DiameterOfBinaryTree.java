
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    // Helper method to compute depth
    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update diameter at this node
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return depth to parent
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        // Sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        System.out.println("Diameter: " + tree.diameterOfBinaryTree(root));  // Output: 3
    }
}

