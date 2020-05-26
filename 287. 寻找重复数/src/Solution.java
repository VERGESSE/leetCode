// 快慢指针
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // 寻找快慢指针相遇处
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 将慢指针调零，此时快慢指针距离入环点即重复数字的距离相同
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

/*  使用了额外空间，不满足题目要求
class Solution {
    public int findDuplicate(int[] nums) {

        int len = nums.length;
        boolean[] memo = new boolean[len];

        for(int n : nums){
            if(memo[n]){
                return n;
            }
            memo[n] = true;
        }

        return -1;
    }
}*/
