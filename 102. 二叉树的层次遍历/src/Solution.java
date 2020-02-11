import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,Integer> temp = new HashMap<>();
        temp.put(root,0);
        queue.addLast(root);
        while (!queue.isEmpty()){

            TreeNode treeNode = queue.removeFirst();
            Integer level = temp.remove(treeNode);

            if (level == res.size()){
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(treeNode.val);

            if (treeNode.left != null) {
                temp.put(treeNode.left,level+1);
                queue.addLast(treeNode.left);
            }
            if (treeNode.right != null){
                temp.put(treeNode.right,level+1);
                queue.addLast(treeNode.right);
            }
        }

        return res;
    }
}

/*   more
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList();
        List<Integer> courList = new ArrayList<Integer>(); // 每层的List
        Queue<TreeNode> queue = new LinkedList();
        int pollNum = 0; //出队的个数
        int preNum = 0;  //上一层个数
        int courrNum = 0;//当前层个数

        if (root != null) {
            queue.offer(root);

            courList.add(root.val);
            List<Integer> singleList = new ArrayList<>();
            singleList.addAll(courList);
            list.add(singleList);
            courList.clear();
        }
        preNum = 1;

        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.poll();
            pollNum++;

            if (node.left != null) {
                queue.offer(node.left);
                courrNum++;
                courList.add(node.left.val);
            }

            if (node.right != null) {
                queue.offer(node.right);
                courrNum++;
                courList.add(node.right.val);
            }

            if (pollNum == preNum) {
                preNum = courrNum;
                courrNum = 0;
                pollNum = 0;
            if (!courList.isEmpty()){
                List<Integer> singleList = new ArrayList<>();
                singleList.addAll(courList);
                list.add(singleList);
                courList.clear();

            }

            }

        }
        return list;
    }
}
 */

/*   fast
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(ret, root, 0);
        return ret;
    }

    private void helper(List<List<Integer>> ret, TreeNode n, int level) {
        if ( n == null ) return;
        if (ret.size() == level) {
            ret.add(new LinkedList<Integer>());
        }
        ret.get(level).add(n.val);
        helper(ret, n.left, level+1);
        helper(ret, n.right, level+1);
    }
}
 */