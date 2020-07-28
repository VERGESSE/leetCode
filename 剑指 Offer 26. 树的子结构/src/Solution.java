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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B)
                || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    // 判断B树是否为A树子结构
    private boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

/* 中序遍历，失败，最后两个无法解决
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A != null && B == null)
            return false;
        if (A == null && B == null)
            return true;
        List<String> AList = new ArrayList<>();
        List<String> BList = new ArrayList<>();
        inorderTraversal(A, AList);
        inorderTraversal(B, BList);
        if (BList.size() > AList.size())
            return false;
        StringBuilder sb1 = new StringBuilder();
        for(String a : AList){
            sb1.append(a);
            sb1.append(",");
        }
        StringBuilder sb2 = new StringBuilder();
        for(String b : BList){
            sb2.append(b);
            sb2.append(",");
        }
        System.out.println(sb1);
        System.out.println(sb2);
        return sb1.toString().contains(sb2.toString());
    }

    private void inorderTraversal(TreeNode root, List<String> list){
        if(root == null) {
            list.add("null");
            return;
        }
        if(root.left == null && root.right == null){
            list.add(String.valueOf(root.val));
            return;
        }
        inorderTraversal(root.left, list);
        list.add(String.valueOf(root.val));
        inorderTraversal(root.right, list);
    }
}
*/
