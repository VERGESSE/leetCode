import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<List<Integer>> ret = new LinkedList<>();
        levelOrder(ret,root,0);
        return ret;
    }

    private void levelOrder(LinkedList<List<Integer>> ret, TreeNode treeNode, int level) {

        if (treeNode == null) return;

        if (level == ret.size()){
            ret.add(new LinkedList<>());
        }
        if (level%2 == 0){
            ret.get(level).add(treeNode.val);
        }else {
            ((LinkedList<Integer>)ret.get(level)).addFirst(treeNode.val);
        }

        levelOrder(ret,treeNode.left,level+1);
        levelOrder(ret,treeNode.right,level+1);

    }
}