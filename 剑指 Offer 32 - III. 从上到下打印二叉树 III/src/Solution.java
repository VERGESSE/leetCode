import java.util.ArrayList;
import java.util.LinkedList;
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

    private List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {

        res = new ArrayList<>();
        levelOrder(root, 0);
        return res;
    }

    private void levelOrder(TreeNode root, int level) {
        if(root == null)
            return;
        if(res.size() <= level)
            res.add(new LinkedList<>());
        if(level % 2 == 0)
            res.get(level).add(root.val);
        else
            ((LinkedList<Integer>)res.get(level)).addFirst(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}

/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
     Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
 */
