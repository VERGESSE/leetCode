class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int num = books.length;
        if (num == 1) {
            return books[0][1];
        }
        int[] dp = new int[num];
        dp[0] = books[0][1];
        for (int i = 1; i < num; i++) {  // 从第二本开始计算
            int height = books[i][1];    // height表示第i本书到i-1，i-2……本书的最大高度，一层书架的高度取决于最高的那本书
            int weight = books[i][0];    // weight则记录i-1，i-2……本书的总宽度，以此来判断能不能放下第i-n本书
            dp[i] = dp[i - 1] + books[i][1];  // 初始假设第i本书单独放到下一层
            for (int j = i - 1; j >= 0; j--) {
                height = Math.max(height, books[j][1]);
                weight = weight + books[j][0];
                if (weight > shelf_width) {    // 当前书太宽（厚），放不下，跳出循环
                    break;
                }
                if (j == 0) {                 // 第i本到第0本书，所有的书都放到一层
                    dp[i] = Math.min(dp[i], height);
                } else {
                    // dp[j - 1] + height解释：
                    // height表示第i本书到第j本书最大的高度，dp[j - 1]表示以第j-1本书为最后一本书，当前书架最小的高度
                    dp[i] = Math.min(dp[i], dp[j - 1] + height);
                }

            }
        }
        return dp[num - 1];
    }
}
