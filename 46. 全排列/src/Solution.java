import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res.clear();

        if (nums.length == 0)
            return res;

        used = new boolean[nums.length];
        generatePermutation(nums,0,new ArrayList<>());

        return res;
    }

    private void generatePermutation(int[] nums, int index, ArrayList<Integer> list) {

        if (index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if ( !used[i] ){
                list.add(nums[i]);
                used[i] = true;

                generatePermutation(nums,index+1,list);

                list.remove(list.size()-1);
                used[i] = false;
            }
        }
        return;
    }
}