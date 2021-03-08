class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int num = books.length;
        if (num == 1) {
            return books[0][1];
        }
        int[] dp = new int[num];
        dp[0] = books[0][1];
        for (int i = 1; i < num; i++) {
            int height = books[i][1];
            int weight = books[i][0];
            dp[i] = dp[i - 1] + books[i][1];
            for (int j = i - 1; j >= 0; j--) {
                height = Math.max(height, books[j][1]);
                weight = weight + books[j][0];
                if (weight > shelf_width) {
                    break;
                }
                if (j == 0) {
                    dp[i] = Math.min(dp[i], height);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + height);
                }

            }
        }
        return dp[num - 1];
    }
}
