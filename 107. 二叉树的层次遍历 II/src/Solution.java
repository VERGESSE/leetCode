import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<List<Integer>> ret = new ArrayList<>();
        helper(ret, root, 0);
        Collections.reverse(ret);
        return ret;
    }

    private void helper(List<List<Integer>> ret, TreeNode n, int level) {
        if ( n == null ) return;
        if (ret.size() == level) {
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(n.val);
        helper(ret, n.left, level+1);
        helper(ret, n.right, level+1);
    }
}
