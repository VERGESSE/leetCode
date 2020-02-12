class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return true;

        return isSameTree(root.left,root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;

        boolean flag = false;

        flag = isSameTree(p.left,q.right);
        if (flag == false) return false;
        flag = isSameTree(p.right,q.left);
        if (flag == false) return false;

        return flag;
    }

}