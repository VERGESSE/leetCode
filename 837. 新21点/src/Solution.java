class Solution {
    public double new21Game(int N, int K, int W) {
        int expair = N - K + 1;
        if(expair >= W || K == 0){
            return 1.0D;
        }
        double w = W;
        double[] dp = new double[K+W];
        for(int i = K; i <= N; i++){
            dp[i] = 1.0D;
        }
        dp[K - 1] = expair / w;

        for(int i = K - 2; i >= 0; --i){
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / w;
        }

        return dp[0];
    }
}
