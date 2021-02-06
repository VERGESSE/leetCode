class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int sum = 0;

        for(int i = len - k; i < len; i++){
            sum += cardPoints[i];
        }
        int max = sum;

        for(int i = 0; i < k; i++){
            int pre = cardPoints[len - k + i];
            sum -= pre;
            int cur = cardPoints[i];
            sum += cur;
            max = Math.max(sum, max);
        }

        return max;
    }
}
