class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length <= 1)
            return 0;
        int res = 0;
        int[] memo = new int[prices.length - 1];
        for(int i = 1; i < prices.length; i++){
            memo[i-1] = prices[i] - prices[i-1];
        }
        for(int i = 0; i < memo.length;){
            int tres = 0;
            while(tres >= 0 && i < memo.length){
                tres += memo[i++];
                res = Math.max(res, tres);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}

/* 暴力解法
class Solution {
    public int maxProfit(int[] prices) {

        int res = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                res = Math.max(res, prices[j]-prices[i]);
            }
        }
        return res;
    }
}
 */
