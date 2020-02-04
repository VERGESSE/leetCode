





class Solution {
    public int removeDuplicates(int[] nums) {

        int k;
        int val;
        int j;
        if (nums.length > 0) {
            val = nums[0];
            k = 1;
        }else {
            return 0;
        }
        if(nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                for (j = i; j < nums.length; j++) {
                    if (val != nums[j]) {
                        val = nums[j];
                        k++;
                        break;
                    }
                }
                int h = i;
                for (; h < j; h++)
                    nums[h] = val;

            }
        }else {
            return 1;
        }
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = solution.removeDuplicates(nums);
        for(int i = 0; i < n; i++){
            System.out.println(nums[i]);
        }

    }
}