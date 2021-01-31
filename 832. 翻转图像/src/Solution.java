class Solution {
    public int[][] flipAndInvertImage(int[][] A) {

        int M = A.length;
        int N = A[0].length;
        int mid = N / 2;

        for(int i = 0; i < M; i++){
            for(int j = 0; j < mid; j++){
                int tmp = A[i][j];
                A[i][j] = 1 ^ A[i][N - j - 1];
                A[i][N - j - 1] = 1 ^ tmp;
            }
        }

        if(N % 2 == 1){
            for(int i = 0; i < M; i++){
                A[i][mid] = 1 ^ A[i][mid];
            }
        }
        return A;
    }
}
