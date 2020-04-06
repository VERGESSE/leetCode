import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<String>> res = new ArrayList<>();
    boolean[] col,dia1,dia2;

    public List<List<String>> solveNQueens(int n) {
        res.clear();
        if (n <= 0) return res;
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];

        putQueen(n,0,new ArrayList<>());
        return res;
    }

    // 尝试在一个n皇后问题中，摆放第index行的皇后位置
    private void putQueen(int n, int index, ArrayList<Integer> list) {

        if (n == index){
            res.add(generateBoard(n,list));
            return;
        }

        for (int i = 0; i < n; i++){
            if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                list.add(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n,index+1,list);
                list.remove(list.size()-1);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
            }
        }
        return;
    }

    private List<String> generateBoard(int n, ArrayList<Integer> list) {

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < n; i++){
            StringBuilder stringBuilder = new StringBuilder();
            Integer index = list.get(i);
            for (int j = 0; j < n; j++){
                if(index == j)
                    stringBuilder.append("Q");
                else stringBuilder.append(".");
            }
            ret.add(stringBuilder.toString());
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }
}