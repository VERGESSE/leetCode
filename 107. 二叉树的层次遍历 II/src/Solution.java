import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> ret = new LinkedList<>();
        helper(ret, root, 0);
        return ret;
    }

    private void helper(LinkedList<List<Integer>> ret, TreeNode n, int level) {
        if ( n == null ) return;
        if (ret.size() == level) {
            ret.addFirst(new LinkedList<Integer>());
        }
        ret.get(ret.size() - level -1).add(n.val);
        helper(ret, n.left, level+1);
        helper(ret, n.right, level+1);
    }
}