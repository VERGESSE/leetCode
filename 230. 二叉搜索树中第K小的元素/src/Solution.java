import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true){

            while (root != null){
                stack.addLast(root);
                root = root.left;
            }
            TreeNode res = stack.removeLast();
            if (--k == 0) return res.val;
            else root = res.right;
        }
    }
}