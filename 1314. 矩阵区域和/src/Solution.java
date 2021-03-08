class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        if(m == 0)
            return null;
        int n = mat[0].length;
        if(n == 0)
            return null;
        int[][] ans = new int[m][n];
        int[][] sMat = sumMatrix(mat);
        int i1,j1,i2,j2;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                i1 = (i - K < 0) ? 0 : i - K;
                i2 = (i + K > m - 1) ? m-1 : i + K;
                j1 = (j - K < 0) ? 0 : j - K;
                j2 = (j + K > n - 1) ? n-1 : j + K;
                ans[i][j] = sum(sMat,i1,j1,i2,j2);
            }
        }
        return ans;
    }

    private int[][] sumMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i-1][j-1] + mat[i - 1][j - 1];
            }
        }
        return dp;
    }

    private int sum(int[][] mat, int i1, int j1, int i2, int j2){
        return mat[i2 + 1][j2 + 1] - mat[i2 + 1][j1] - mat[i1][j2 + 1] + mat[i1][j1];
    }
}
