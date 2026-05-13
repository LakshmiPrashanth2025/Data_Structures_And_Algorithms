
import java.util.LinkedList;
import java.util.Queue;

public class BFS_LevelOrderTraversal {

    TreeNode root;

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }
    }

    

    public static void main(String[] args) {
        BFS_LevelOrderTraversal tree = new BFS_LevelOrderTraversal();

        // Sample tree:
        //     1
        //    / \
        //   2   3
        //  / \   \
        // 4   5   6

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);

        System.out.println("Level Order Traversal:");
        tree.levelOrderTraversal(tree.root);
    }
}


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int value) {
        this.val = value;
        left = right = null;
    }
}


