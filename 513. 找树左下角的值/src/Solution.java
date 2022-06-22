import java.util.*;

class Solution {
    public int findBottomLeftValue(TreeNode root) {

        int res = -1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.remove();
            if (treeNode.right != null){
                deque.offer(treeNode.right);
            }
            if (treeNode.left != null){
                deque.offer(treeNode.left);
            }
            res = treeNode.val;
        }
        return res;
    }
}
