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
    public int kthLargest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inorderTraversal(list, root, k);
        return list.get(list.size() - 1);
    }

    // 先遍历右节点的中序遍历，只取最大k个元素
    private int inorderTraversal(List<Integer> list, TreeNode node, int k){
        if (node == null || k == 0)
            return k;
        int n = inorderTraversal(list, node.right, k);
        if (n == 0)
            return 0;
        list.add(node.val);
        n = inorderTraversal(list, node.left, n - 1);
        return n;
    }
}
