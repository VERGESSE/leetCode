class Solution {

    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null) {
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
}

/*   1ms
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLevel = queryLevel(root.left, 1);
        int rightLevel = queryLevel(root.right, 1);
        if (Math.abs(leftLevel - rightLevel) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int queryLevel(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        return Math.max(queryLevel(node.left, level + 1), queryLevel(node.right, level + 1));
    }
}
 */