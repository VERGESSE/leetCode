import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {

        int one = 1;
        int two = 1;
        for(int i = 2; i <= n; i++){
            if((i & 1) == 1){
                one += two;
            } else {
                two += one;
            }
        }

        return (n & 1) == 0 ? two : one;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
    }

    // 动态规划
    //public int climbStairs(int n) {
    //    int[] memo = new int[n+1];
    //    Arrays.fill(memo,-1);
    //
    //    memo[0] = 1;
    //    memo[1] = 1;
    //    for (int i = 2; i <= n; i++){
    //        memo[i] = memo[i-1] + memo[i-2];
    //    }
    //    return memo[n];
    //}
}

/*  记忆化搜索
class Solution {

    int[] memo;

    public int climbStairs(int n) {

        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return calcWays(n);
    }

    private int calcWays(int n) {

        if (n == 0 || n ==1)
            return 1;

        if (memo[n] == -1)
            memo[n] = calcWays(n-1) + calcWays(n-2);

        return memo[n];
    }
}
 */
