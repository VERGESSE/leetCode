class Solution {

    int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board.length < 1) return false;
        visited = new boolean[board[0].length][board.length];

        for (int x = 0; x < board[0].length; x++){
            for (int y = 0; y < board.length; y++){
                if (searchWord(board,word,0,x,y))
                    return true;
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {

        if (index == word.length() - 1){
            return board[y][x] == word.charAt(index);
        }

        if (board[y][x] == word.charAt(index)){
            visited[x][y] = true;
            for (int i = 0; i < 4; i++){
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (newX >= 0 && newX < board[0].length && newY >= 0 && newY < board.length
                        && !visited[newX][newY]
                            && searchWord(board,word,index+1,newX,newY))
                    return true;
            }
            visited[x][y] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] strings = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(solution.exist(strings,"ABCCED"));
    }
}