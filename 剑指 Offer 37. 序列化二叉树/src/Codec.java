import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final TreeNode EMPTY_NODE = new TreeNode(0);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder res = new StringBuilder("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int emptyNum = 0;
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node == EMPTY_NODE) {
                res.append("null,");
                emptyNum++;
            }
            else {
                res.append(node.val);
                res.append(",");
                emptyNum = 0;
                deque.offer(node.left == null ? EMPTY_NODE : node.left);
                deque.offer(node.right == null ? EMPTY_NODE : node.right);
            }
        }
        return res.substring(0, res.length() - emptyNum * 5 - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "[]".equals(data)) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        int len = nodes.length;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int index = 1;
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (index < len && !nodes[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                deque.offer(node.left);
            }
            index++;
            if (index < len && !nodes[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                deque.offer(node.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
