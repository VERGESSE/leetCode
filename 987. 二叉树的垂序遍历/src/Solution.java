import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        nodes.sort((tuple1, tuple2) -> {
            if (tuple1[0] != tuple2[0]) {
                return tuple1[0] - tuple2[0];
            } else if (tuple1[1] != tuple2[1]) {
                return tuple1[1] - tuple2[1];
            } else {
                return tuple1[2] - tuple2[2];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
