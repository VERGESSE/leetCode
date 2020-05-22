import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 时间O(1), 空间O(1)
class Solution {

    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLen = preorder.length;
        int inLen = inorder.length;

        // 使用哈希表记录中序遍历数组中每个值的索引，空间换时间
        map = new HashMap<>();
        for(int i = 0; i < inLen; i++){
            map.put(inorder[i], i);
        }

        // 构造二叉树
        return buildTree(preorder, 0, preLen - 1,
                inorder, 0, inLen - 1);
    }

    /**
     * 根据传入信息构造二叉树
     * @param preorder 前序遍历数组
     * @param preLeft 构造二叉树使用前序遍历数组的起始坐标
     * @param preRight 构造二叉树使用前序遍历数组的终止坐标
     * @param inorder 中序遍历数组
     * @param inLeft 构造二叉树使用中序遍历数组的起始坐标
     * @param inRight 构造二叉树使用中序遍历数组的终止坐标
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }

        // 前序遍历数组的preLeft即为此次构造二叉树的头结点，
        // 根据这个信息从map中得出中序遍历该位置的索引
        Integer rootIndex = map.get(preorder[preLeft]);
        // 构造根节点
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 计算左子树的起始和终止位置并构造左子树
        root.left = buildTree(preorder, preLeft + 1, preLeft + rootIndex - inLeft,
                                inorder, inLeft, rootIndex - 1);
        // 计算右子树的起始和终止位置并构造右子树
        root.right = buildTree(preorder, preLeft + rootIndex -inLeft + 1, preRight,
                                inorder, rootIndex + 1, inRight);

        return root;
    }
}