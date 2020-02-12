class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;

        boolean flag = false;

        flag = isSameTree(p.left,q.left);
        if (flag == false) return false;
        flag = isSameTree(p.right,q.right);
        if (flag == false) return false;

        return flag;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.isSameTree(treeNode1,treeNode2));
    }
}