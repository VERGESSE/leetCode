class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length, cols = matrix[0].length;
        dp = new int[rows + 1][cols + 1];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j]
                        + dp[i][j + 1] + matrix[i][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1]
                - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        });

        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }
}
