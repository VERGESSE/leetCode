class Solution {
    public int maxProduct(int[] nums) {

        int len = nums.length;
        int[] max = new int[len + 1];
        int[] min = new int[len + 1];
        max[0] = 1; min[0] = 1;
        int MAX = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(max[i] * nums[i] > min[i] * nums[i]){
                max[i + 1] = Math.max(max[i] * nums[i], nums[i]);
                min[i + 1] = Math.min(min[i] * nums[i], nums[i]);
            } else {
                max[i + 1] = Math.max(min[i] * nums[i], nums[i]);
                min[i + 1] = Math.min(max[i] * nums[i], nums[i]);
            }
            MAX = Math.max(MAX, max[i + 1]);
            if(nums[i] == 0){
                max[i + 1] = 1;
                min[i + 1] = 1;
            }
        }

        return MAX;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxProduct(new int[]{2,-5,-2,-4,3});
        System.out.println(i);
    }
}

/*  清爽的实现
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
 */