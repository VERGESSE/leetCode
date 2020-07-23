import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public int[] levelOrder(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            res.add(cur.val);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }

        int[] ints = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            ints[i] = res.get(i);

        return ints;
    }
}
