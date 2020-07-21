/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//O(nlogn)
class Solution {
    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        int lheight = 0;
        int rheight = 0;
        if(root.left != null){
            if(!isBalanced(root.left))
                return false;
            lheight = height(root.left);
        }
        if(root.right != null){
            if(!isBalanced(root.right))
                return false;
            rheight = height(root.right);
        }
        return Math.abs(rheight - lheight) < 2;
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;
        int lheight = 0;
        int rheight = 0;
        if(root.left != null)
            lheight = height(root.left);
        if(root.right != null)
            rheight = height(root.right);
        return 1 + Math.max(rheight, lheight);
    }
}

/* O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    // 如果为平衡树，返回深度，不是则返回-1
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

 */
