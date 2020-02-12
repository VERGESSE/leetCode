class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeavesHelper(root,false);
    }

    // 先序遍历求所有左叶子节点值之和
    public int sumOfLeftLeavesHelper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int leave = 0;
        // 左叶子节点
        if (flag && root.left == null && root.right == null) {
            leave = root.val;
        }
        int left = sumOfLeftLeavesHelper(root.left, true);
        int right = sumOfLeftLeavesHelper(root.right, false);
        return left + right + leave;
    }
}