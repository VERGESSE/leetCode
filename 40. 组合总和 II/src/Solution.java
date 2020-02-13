import java.util.*;

public class Solution {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            //剪枝  20ms -> 3ms 添加&& target - candidates[i] >= 0
            for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
                //因为这个数和上个数相同，所以从这个数开始的所以情况，在上个数里面都考虑过了，需要跳过
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                list.add(candidates[i]);
                process(i + 1, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> combinationSum = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum);
    }
}