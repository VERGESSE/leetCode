import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> record = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!record.contains(nums[i])){
                record.add(nums[i]);
            }else {
                return true;
            }

            if(record.size() > k){
                record.remove(nums[i - k]);
            }
        }
        return false;
    }
}