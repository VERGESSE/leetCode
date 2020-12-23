class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices){
            if (price < minPrice){
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

/* O(n2)
class Solution {
    public int maxProfit(int[] prices) {

        int max = Integer.MIN_VALUE;
        int cur = 0;

        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                cur = prices[j] - prices[i];
                if(cur > max){
                    max = cur;
                }
            }
        }

        if(max < 0){
            return 0;
        }

        return max;
    }
}
 */
