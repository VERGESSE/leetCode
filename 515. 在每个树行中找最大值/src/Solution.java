import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        dfs(res, root, 1);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node, int deep) {
        if (node == null){
            return;
        }
        if (deep > res.size()){
            res.add(node.val);
        } else if (node.val > res.get(deep - 1)){
            res.set(deep - 1, node.val);
        }
        dfs(res, node.left, deep + 1);
        dfs(res, node.right, deep + 1);
    }
}

/* bfs
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }
        Deque<Node> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        deque.offer(new Node(1, root));
        while (!deque.isEmpty()) {
            Node cur = deque.remove();
            if (cur.layer > res.size()){
                res.add(cur.treeNode.val);
            } else if (cur.treeNode.val > res.get(cur.layer - 1)) {
                res.set(cur.layer - 1, cur.treeNode.val);
            }
            if (cur.treeNode.left != null){
                deque.offer(new Node(cur.layer + 1, cur.treeNode.left));
            }
            if (cur.treeNode.right != null){
                deque.offer(new Node(cur.layer + 1, cur.treeNode.right));
            }
        }

        return res;
    }

    private static class Node {
        int layer;
        TreeNode treeNode;

        Node(int layer, TreeNode treeNode){
            this.layer = layer;
            this.treeNode = treeNode;
        }
    }
}
 */
