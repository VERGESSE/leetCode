class Solution {
    public int[] findSquare(int[][] matrix) {

        int maxSize = 0;
        int r = 0, c = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    int size = findSquareSize(matrix, i, j, maxSize);
                    if(size > maxSize){
                        maxSize = size;
                        r = i; c = j;
                    }
                }
            }
        }
        if(maxSize == 0)
            return new int[0];
        return new int[]{r, c ,maxSize};
    }

    private int findSquareSize(int[][] matrix, int r, int c, int curMaxSize){
        int rlen = matrix.length - 1;
        int clen = matrix[0].length - 1;
        // 校验这次的有没有机会超过最大的
        if (r + curMaxSize > rlen || c + curMaxSize > clen)
            return 0;
        for(int i = r; i < r + curMaxSize; i++){
            if(matrix[i][c] != 0) return 0;
        }
        for(int i = c; i < c + curMaxSize; i++){
            if(matrix[r][i] != 0) return 0;
        }

        int rr = r;
        int cc = c;
        int maxSize = 1;
        find:
        while(rr < rlen && cc < clen){
            rr++; cc++;
            if(matrix[rr][c] != 0 || matrix[r][cc] != 0){
                break;
            }
            for(int i = c; i <= cc; i++){
                if(matrix[rr][i] == 1){
                    continue find;
                }
            }
            for(int i = r; i < rr; i++){
                if(matrix[i][cc] == 1){
                    continue find;
                }
            }
            maxSize = rr - r + 1;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findSquare(new int[][]{{1,0,1},{0,0,1},{0,0,1}});
    }
}
