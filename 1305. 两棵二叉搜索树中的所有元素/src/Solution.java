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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        int i = 0, j = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        while(i < size1 && j < size2){
            if(list1.get(i) <= list2.get(j)){
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        while(i < size1){
            res.add(list1.get(i++));
        }
        while(j < size2){
            res.add(list2.get(j++));
        }
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
