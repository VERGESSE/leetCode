import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ret = new LinkedList<>();
        rightView(ret,root,0);
        return ret;
    }

    private void rightView(List<Integer> ret, TreeNode treeNode, int level) {

        if (treeNode == null) return;

        if (!ret.isEmpty() && ret.size() > level) {
            ret.set(level, treeNode.val);
        }else {
            ret.add(level,treeNode.val);
        }

        rightView(ret,treeNode.left,level+1);
        rightView(ret,treeNode.right,level+1);
    }
}