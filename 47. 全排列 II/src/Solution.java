import java.util.*;

class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res.clear();

        if (nums.length == 0)
            return res;

        Arrays.sort(nums);

        used = new boolean[nums.length];
        generatePermutation(nums,0,new ArrayDeque<>());

        return res;
    }

    private void generatePermutation(int[] nums, int index, Deque<Integer> list) {

        if (index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if ( !used[i] ){

                // 修改 2：在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，故"剪枝"
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }

                list.push(nums[i]);
                used[i] = true;

                generatePermutation(nums,index+1,list);

                list.pop();
                used[i] = false;
            }
        }
        return;
    }
}