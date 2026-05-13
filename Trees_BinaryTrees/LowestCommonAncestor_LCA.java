class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class LowestCommonAncestor_LCA {
    TreeNode root;

    // Function to find LCA of two nodes n1 and n2
    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        // Base case
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report the presence
        if (root.val == n1 || root.val == n2)
            return root;

        // Look for keys in left and right subtrees
        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);

        // If both of the above calls return non-null, then one key
        // is present in one subtree and the other is present in the other,
        // so this node is the LCA
        if (leftLCA != null && rightLCA != null)
            return root;

        // Otherwise, return the non-null node
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper method to test the function
    public static void main(String[] args) {
        LowestCommonAncestor_LCA tree = new LowestCommonAncestor_LCA();

            // Sample tree:
        //     1
        //    / \
        //   2   3
        //  / \   \
        // 4   5   6

        // Example tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        TreeNode lca = tree.findLCA(tree.root, 4, 5);
        System.out.println("LCA(4, 5) = " + lca.val); // Output: 2

        lca = tree.findLCA(tree.root, 4, 6);
        System.out.println("LCA(4, 6) = " + lca.val); // Output: 1
    }
}
