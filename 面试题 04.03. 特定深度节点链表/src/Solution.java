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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {

        List<TreeNode> oneLayer = new ArrayList<>();
        List<ListNode> list = new ArrayList<>();
        oneLayer.add(tree);
        while(!oneLayer.isEmpty()){
            ListNode thisLayer = new ListNode(0);
            ListNode head = thisLayer;
            List<TreeNode> nodeList = new ArrayList<>(oneLayer);
            oneLayer = new ArrayList<>();
            for(TreeNode node : nodeList){
                head.next = new ListNode(node.val);
                head = head.next;
                if(node.left != null){
                    oneLayer.add(node.left);
                }
                if(node.right != null){
                    oneLayer.add(node.right);
                }
            }
            list.add(thisLayer.next);
        }
        return list.toArray(new ListNode[0]);
    }
}
