import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canJump(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.canJump(nums));
    }
}
/*  找出全部0，看看0前的元素是否可以越过0
public boolean canJump(int[] nums) {

        int n = nums.length;
        if (n == 1) return true;
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (nums[i] == 0)
                zeros.add(i);
        for (Integer index : zeros) {
            boolean flag = false;
            for (int i = index-1; i >= 0; i--){
                if (nums[i]+i > index){
                    flag = true;
                    break;
                }
            }
            if (flag == false) return false;
        }
        return true;
    }
 */
/*  贪心O(n)
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

 */

/* 从后至前dp
public boolean canJump(int[] nums) {

        int n = nums.length;
        if (n == 1) return true;

        int[] dp = new int[n];
        dp[n-1] = n - 1;

        for (int i = n-2; i >= 0; i--){
            int num = nums[i];
            if (num+i >= n-1){
                dp[i] = n-1;
                continue;
            }
            dp[i] = i;
            for (int j = i+num; j > i; j--){
                dp[i] = Math.max(dp[i], dp[j]);
                if (dp[i] == dp[n-1]) break;
            }
        }

        return dp[0] == n-1;
    }
 */