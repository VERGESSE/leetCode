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
    public boolean isSubtree(TreeNode s, TreeNode t) {

        // 如果他为空一定存在
        if(t == null) return true;
        // 如果s为空一定不存在
        if(s == null) return false;
        // 判断s的左右子树是不是包含t，然后判断当前s和t是否相等
        return isSubtree(s.left,t) || isSubtree(s.right, t) || isSame(s, t);
    }

    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}