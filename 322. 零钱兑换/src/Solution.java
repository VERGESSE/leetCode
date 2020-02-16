import java.util.Arrays;

// 动态规划
class Solution {
    public int coinChange(int[] coins, int amount) {

        int [] f = new int[amount + 1];
        f[0] = 0;

        for(int i = 1; i <= amount; i++){

            int cost = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }

            f[i] = cost;
        }

        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
    }
}

/*  3ms   递归回溯
class Solution {
     int minCount=Integer.MAX_VALUE;
     public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        //递归调用，从尾向首递归调用，尽量使用大额硬币
        useNext(0,amount,coins,coins.length-1);
        if (minCount==Integer.MAX_VALUE)return -1;
        else return minCount;
    }
    //i是已经用了多少个硬币，amount是剩下金额，coins是硬币集合，n是第几种硬币
     private void useNext(int i, int amount, int[] coins, int n) {
        if (amount==0){ //找到一种组合
            if (i<minCount)minCount=i;
            return;//结束
        }
        //尝试失败，压根就不用进行后面的循环
        if(n==-1||amount/coins[n]+i>=minCount)return;
        //尽可能多的使用大硬币，
        for (int j = amount/coins[n]; j >=0 ; j--) {
            useNext(i+j,amount-coins[n]*j,coins,n-1);
        }
    }
}
 */


/*public class Solution {
    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}*/
