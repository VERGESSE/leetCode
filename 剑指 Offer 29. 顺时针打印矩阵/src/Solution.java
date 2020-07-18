class Solution {
    public int[] spiralOrder(int[][] matrix) {

        if(matrix.length == 0)
            return new int[0];
        int lm = 0;
        int rm = matrix[0].length-1;
        int ln = 0;
        int rn = matrix.length-1;
        int[] res = new int[(rm+1)*(rn+1)];
        int index = 0;

        while(rm >= lm && rn >= ln){
            for(int tm = lm; tm <= rm; tm ++)
                res[index++] = matrix[ln][tm];
            for(int tn = ln + 1; tn <= rn; tn ++)
                res[index++] = matrix[tn][rm];
            // 重要
            if (rm > lm && rn > ln) {
                for (int tm = rm - 1; tm >= lm + 1; tm--)
                    res[index++] = matrix[rn][tm];
                for (int tn = rn; tn >= ln + 1; tn--)
                    res[index++] = matrix[tn][lm];
            }
            lm++; rm--;
            ln++; rn--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{3},{2}};
        int[] ints = solution.spiralOrder(matrix);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}
