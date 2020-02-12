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
    public int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        int res = 0;
        res += findPath(root,sum);
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);

        return res;
    }

    private int findPath(TreeNode root, int sum) {

        if (root == null)
            return 0;

        int res = 0;
        if (root.val == sum)
            res += 1;

        res += findPath(root.left,sum-root.val);
        res += findPath(root.right,sum-root.val);

        return res;
    }
}