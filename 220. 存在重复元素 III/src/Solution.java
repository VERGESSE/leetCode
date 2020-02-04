import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> record = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){

            if(record.ceiling((long) nums[i] - t) != null &&
                    record.ceiling((long) nums[i] - t) <= (long)nums[i] + t)
                return true;

            record.add((long)nums[i]);

            if(record.size() > k){
                record.remove((long)nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,5,9,1,8};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums,1,3));
    }
}