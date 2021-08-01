import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        List<int[]> list = new ArrayList<>(m);
        for(int i = 0; i < m; i++){
            int num = 0;
            for(int j = 0; j < n && mat[i][j] == 1; j++){
                num ++;
            }
            list.add(new int[]{num, i});
        }

        list.sort((a, b) -> {
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = list.get(i)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] kWeakestRows = solution.kWeakestRows(new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}},
                3);
        for (int kWeakestRow : kWeakestRows) {
            System.out.print(kWeakestRow + " ");
        }
    }
}
