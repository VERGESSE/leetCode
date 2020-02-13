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

        if (root == null) return null;

        boolean pinleft = hasnode(root.left,p);
        boolean qinleft = hasnode(root.left,q);

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode ret = null;
        if (pinleft && qinleft){
            ret = lowestCommonAncestor(root.left,p,q);
        }else if (!pinleft && !qinleft){
            ret = lowestCommonAncestor(root.right,p,q);
        }else ret = root;

        return ret;
    }

    private boolean hasnode(TreeNode root,TreeNode query){

        if (root == null) return false;

        return hasnode(root.left,query)
                || (query.val == root.val)
                || hasnode(root.right,query);
    }
}

/*   more

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;

    }
}

 */

/*  fast

class Solution {
    // 我们设置成有可能q不在 那么返回root
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 两个节点的最低公共祖先
        // 如果p q在同一边

         if (root == null) return null;

         if (root == p || root == q) {
             return root;
         }

         //  p q 在子树
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         // 如果两边都找不到公共祖先 说明p q在两边
         if (left != null && right != null) {
             return root;
         }

         return left == null?right:left;
    }
}

 */