class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
//            System.out.println(i + "--dp_i_0--= " + dp_i_0);

            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
//            System.out.println(i + "--dp_i_1--= " + dp_i_1);

            dp_pre_0 = temp;
//            System.out.println(i + "--dp_pre_0--= " + dp_pre_0);
            System.out.println();
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {3,2,1,1,10,11,12,1,1,9};
        System.out.println(new Solution().maxProfit(prices));
    }
}

/**
    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                  max(   选择 rest  ,           选择 sell      )

    解释：今天我没有持有股票，有两种可能：
    要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
    要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。

    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
                  max(   选择 rest  ,           选择 buy         )

    解释：今天我持有着股票，有两种可能：
    要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
    要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
    这个解释应该很清楚了，如果 buy，就要从利润中减去 prices[i]，如果 sell，就要给利润增加 prices[i]。今天的最大利润就是这两种可能选择中较大的那个。而且注意 k 的限制，我们在选择 buy 的时候，把 k 减小了 1，很好理解吧，当然你也可以在 sell 的时候减 1，一样的。

    现在，我们已经完成了动态规划中最困难的一步：状态转移方程。如果之前的内容你都可以理解，那么你已经可以秒杀所有问题了，只要套这个框架就行了。不过还差最后一点点，就是定义 base case，即最简单的情况。

    dp[-1][k][0] = 0
    解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
    dp[-1][k][1] = -infinity
    解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
    dp[i][0][0] = 0
    解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
    dp[i][0][1] = -infinity
    解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
    把上面的状态转移方程总结一下：

    base case：
    dp[-1][k][0] = dp[i][0][0] = 0
    dp[-1][k][1] = dp[i][0][1] = -infinity

    状态转移方程：
    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。

 */