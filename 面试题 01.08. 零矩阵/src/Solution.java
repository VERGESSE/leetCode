class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        if(n == 0) return;

        int[] row = new int[m];
        int[] cow = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    cow[j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            if(row[i] == 1){
                for(int j = 0; j < n; j++)
                    matrix[i][j] = 0;
            }
        }
        for(int j = 0; j < n; j++){
            if(cow[j] == 1){
                for(int i = 0; i < m; i++)
                    matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        solution.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
