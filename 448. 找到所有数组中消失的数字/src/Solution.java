import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int len = nums.length;
        int index = 0;
        while(index < len){
            int cur = nums[index] - 1;
            if(cur != index){
                if(cur != -2 && nums[cur] != -1){
                    swap(nums, index, cur);
                    nums[cur] = -1;
                } else {
                    index++;
                }
            } else {
                nums[index++] = -1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(nums[i] != -1){
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(
                new int[]{4,3,2,7,8,2,3,1}
        ));
    }
}

/* 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
 */
