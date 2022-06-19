import java.util.*;

class Solution {

    private Map<Integer, Integer> frequencyMap;
    private int maxFrequency;
    private List<Integer> list;

    public int[] findFrequentTreeSum(TreeNode root) {

        frequencyMap = new HashMap<>();
        list = new ArrayList<>();
        preorderTraversal(root);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private int preorderTraversal(TreeNode treeNode) {

        int res = treeNode.val;

        if (treeNode.left != null){
            res += preorderTraversal(treeNode.left);
        }
        if (treeNode.right != null){
            res += preorderTraversal(treeNode.right);
        }

        int frequency = frequencyMap.getOrDefault(res, 0) + 1;
        if (frequency > maxFrequency){
            maxFrequency = frequency;
            list.clear();
            list.add(res);
        } else if (frequency == maxFrequency){
            list.add(res);
        }
        frequencyMap.put(res, frequency);

        return res;
    }
}
