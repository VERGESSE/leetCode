import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root.val == x || root.val == y){
            return false;
        }
        Node xN = null, yN = null;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(root, 0, null));
        while (!deque.isEmpty()){
            Node node = deque.removeFirst();
            TreeNode cur = node.cur;
            if (cur.left != null){
                deque.addLast(new Node(cur.left, node.height + 1, cur));
            }
            if (cur.right != null){
                deque.addLast(new Node(cur.right, node.height + 1, cur));
            }
            if (cur.val == x){
                xN = node;
            }
            if (cur.val == y){
                yN = node;
            }
        }

        return (xN != null && yN != null) &&
                xN.height == yN.height && xN.parent != yN.parent;
    }

    static class Node{
        TreeNode cur;
        int height;
        TreeNode parent;

        Node(TreeNode cur, int height, TreeNode parent) {
            this.cur = cur;
            this.height = height;
            this.parent = parent;
        }
    }
}
