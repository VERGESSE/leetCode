import java.util.*;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        pathSum(root, sum - root.val, res, cur);
        return res;
    }

    private void pathSum(TreeNode root, int sum,
                    List<List<Integer>> res, List<Integer> cur) {
        if(root.left == null && root.right == null && sum == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if (root.left != null){
            cur.add(root.left.val);
            pathSum(root.left, sum - root.left.val, res, cur);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null){
            cur.add(root.right.val);
            pathSum(root.right, sum - root.right.val, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
