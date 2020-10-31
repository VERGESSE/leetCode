class Solution {
    public String tictactoe(int[][] moves) {

        char[][] chessboard = new char[3][3];
        // 构造棋盘
        for(int i = 0; i < moves.length; i++){
            int[] cur = moves[i];
            if(i % 2 == 0)
                chessboard[cur[0]][cur[1]] = 'X';
            else
                chessboard[cur[0]][cur[1]] = 'O';
        }

        for(int i = 0; i < 3; i++){
            if(chessboard[i][0] == chessboard[i][1]
                    && chessboard[i][0] == chessboard[i][2])
                if(chessboard[i][0] == 'X' || chessboard[i][0] == 'O')
                    return chessboard[i][0] == 'X' ? "A" : "B";
            if(chessboard[0][i] == chessboard[1][i]
                    && chessboard[0][i] == chessboard[2][i])
                if(chessboard[0][i] == 'X' || chessboard[0][i] == 'O')
                    return chessboard[0][i] == 'X' ? "A" : "B";
        }
        if(chessboard[0][0] == chessboard[1][1]
                && chessboard[0][0] == chessboard[2][2])
            if(chessboard[0][0] == 'X' || chessboard[0][0] == 'O')
                return chessboard[0][0] == 'X' ? "A" : "B";
        if(chessboard[0][2] == chessboard[1][1]
                && chessboard[0][2] == chessboard[2][0])
            if(chessboard[0][2] == 'X' || chessboard[0][2] == 'O')
                return chessboard[0][2] == 'X' ? "A" : "B";
        if(moves.length == 9)
            return "Draw";
        return "Pending";
    }
}
