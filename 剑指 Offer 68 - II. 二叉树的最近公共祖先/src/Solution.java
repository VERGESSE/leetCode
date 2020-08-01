import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left为空，说明这两个节点在root结点的右子树上，我们只需要返回右子树查找的结果即可
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        // 如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        // 我们只需要返回cur结点即可。
        return root;
    }
}

/* 使用Set，效果还可以
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        Set<TreeNode> leftSet = new LinkedHashSet<>();
        Set<TreeNode> rightSet = new HashSet<>();
        isExit(root, p, leftSet);
        isExit(root, q, rightSet);
        for (TreeNode node : leftSet) {
            if (rightSet.contains(node))
                return node;
        }
        return root;
    }

    private boolean isExit(TreeNode root, TreeNode search, Set<TreeNode> set){
        if(root == null)
            return false;
        if (root.val == search.val || isExit(root.left, search, set)
                || isExit(root.right, search, set)) {
            set.add(root);
            return true;
        }
        return false;
    }
}*/

/* low
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val == p.val || root.val == q.val)
            return root;
        boolean lp = isExit(root.left, p);
        boolean lq = isExit(root.left, q);

        if(lp && lq)
            return lowestCommonAncestor(root.left, p, q);
        else if(!lp && !lq)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    private boolean isExit(TreeNode root, TreeNode search){
        if(root == null)
            return false;
        if(root.val == search.val)
            return true;
        return isExit(root.left, search) || isExit(root.right, search);
    }
}
 */
