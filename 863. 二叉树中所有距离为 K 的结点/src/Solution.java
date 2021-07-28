import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        initParent(root, parent);
        Set<TreeNode> visit = new HashSet<>();

        Deque<Node> deque = new ArrayDeque<>();
        deque.push(new Node(target, k));
        while(!deque.isEmpty()){
            Node curNode = deque.poll();
            int ck = curNode.k;
            TreeNode cur = curNode.node;
            visit.add(cur);
            if(ck == 0){
                res.add(cur.val);
                continue;
            }
            TreeNode parentNode = parent.get(cur);
            if(parentNode != null && !visit.contains(parentNode)){
                deque.push(new Node(parentNode, ck - 1));
            }
            if(cur.left != null && !visit.contains(cur.left)){
                deque.push(new Node(cur.left, ck - 1));
            }
            if(cur.right != null && !visit.contains(cur.right)){
                deque.push(new Node(cur.right, ck - 1));
            }
        }

        return res;
    }

    private void initParent(TreeNode root, Map<TreeNode, TreeNode> parent){
        if(root.left != null){
            parent.put(root.left, root);
            initParent(root.left, parent);
        }
        if(root.right != null){
            parent.put(root.right, root);
            initParent(root.right, parent);
        }
    }

    static class Node{
        TreeNode node;
        int k;
        Node(TreeNode node, int k){
            this.node = node;
            this.k = k;
        }
    }
}
