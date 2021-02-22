class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] preRow = new int[n];
        for(int j = n - 1; j > 0; j--){
            preRow[j] = matrix[0][j - 1];
        }

        for(int i = 1; i < m; i++){
            for(int j = n - 1; j > 0; j--){
                if(matrix[i][j] != preRow[j]){
                    return false;
                } else {
                    preRow[j] = matrix[i][j - 1];
                }
            }
        }

        return true;
    }
}
