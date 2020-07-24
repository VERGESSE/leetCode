class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 0) return 0;
        int res = 0;
        int start = 0, end = nums.length-1;
        int mid = 0;
        while(start <= end){
            mid = (end - start) / 2 + start;
            if(nums[mid] == target)
                break;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        for(int i = mid; i >= 0; i--){
            if(nums[i] != target)
                break;
            res++;
        }
        for(int i = mid+1; i < nums.length; i++){
            if(nums[i] != target)
                break;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{1}, 1));
    }
}
