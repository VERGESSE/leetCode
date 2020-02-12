import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        if (root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftS = binaryTreePaths(root.left);
        for (String left : leftS) {
            res.add(Integer.toString(root.val) + "->" + left);
        }
        List<String> rightS = binaryTreePaths(root.right);
        for (String right : rightS) {
            res.add(Integer.toString(root.val) + "->" + right);
        }

        return res;
    }
}

/*  1ms
class Solution {
    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
                paths.add(path);  // 把路径加入到答案中
            else {
                path += "->";  // 当前节点不是叶子节点，继续递归遍历
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }
}
 */