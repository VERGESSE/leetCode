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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(map, preorder,
                0, preorder.length, 0);
    }

    /**
     * @param map 中序遍历 值->位置 索引
     * @param preorder 前序遍历集合
     * @param ps 前序遍历数组起始位置
     * @param pd 前序遍历数组终止位置
     * @param is 中序遍历数组的起始位置,
     *           用于根据map的中序遍历索引值计算递归计算中前序遍历的偏移值
     * @return 根据提供的数据建立的树
     */
    private TreeNode buildTree(Map<Integer, Integer> map,
                               int[] preorder, int ps, int pd, int is) {
        if(ps >= pd)
            return null;
        int head = preorder[ps];
        int index = map.get(head);
        TreeNode node = new TreeNode(head);
        node.left = buildTree(map, preorder,
                ps + 1, ps + index - is + 1, is);
        node.right = buildTree(map, preorder,
                ps + index - is + 1, pd, index + 1);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{3,9,20,15,7},
                new int[]{9,3,15,20,7});
    }
}
