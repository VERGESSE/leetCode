class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2){
            return 0;
        }

        int have = 0 - prices[0];
        int notHave = 0;

        for(int i = 1; i < prices.length; i++){
            int tmp = have;
            have = Math.max(have, notHave - prices[i]);
            notHave = Math.max(notHave, tmp + prices[i]);
        }

        return notHave;
    }
}


/* 贪心 O(n)  fast
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
 */
