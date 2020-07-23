import java.util.ArrayList;
import java.util.List;

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

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {

        res = new ArrayList<>();
        levelOrder(root, 0);
        return res;
    }

    // 按层添加元素
    private void levelOrder(TreeNode root, int level) {
        if(root == null)
            return;
        if(res.size() <= level)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}
