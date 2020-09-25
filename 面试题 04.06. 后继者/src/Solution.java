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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode node = root;

        while(root != null){
            if(root.val <= p.val){
                root = root.right;
            } else{
                node = root;
                root = node.left;
            }
        }
        return node.val > p.val ? node : null;
    }
}
