class Solution {

    private static final int[][] dirs =
            new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] memo = null;
    private int m = 0;
    private int n = 0;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if(m == 0) return false;
        n = board[0].length;
        if(n == 0) return false;
        if(word == null || word.length() == 0) return false;
        if(m * n < word.length()) return false;
        memo = new boolean[m][n];
        char first = word.charAt(0);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == first){
                    memo[i][j] = true;
                    if(exist(board, word, 1, i, j))
                        return true;
                    memo[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int x, int y) {
        if(word.length() == index)
            return true;
        for(int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(isLegal(newX, newY) && !memo[newX][newY]
                    && board[newX][newY] == word.charAt(index)){
                memo[newX][newY] = true;
                if(exist(board, word, index + 1, newX, newY))
                    return true;
                memo[newX][newY] = false;
            }
        }
        return false;
    }

    private boolean isLegal(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(solution
            .exist(board, "ABCCED"));
    }
}
