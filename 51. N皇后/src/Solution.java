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

/*  more  3ms
class Solution {
   private  List<List<String>> res =new ArrayList<>();
    private  boolean[] j ;
    private  boolean[] jio1;
    private  boolean[] jio2;
    public  List<List<String>> solveNQueens(int n) {
        j=new boolean[n];
        jio1=new boolean[2*n-1];
        jio2=new boolean[2*n-1];
        char[][] board =new char[n][n];
        back(n,0,board);
        return res;
    }
    public  void back(int n,int i,char[][] board){
        if (n==i){
            List<String> list =new ArrayList<>();
            for (int j = 0; j <n ; j++) {
                list.add(new String(board[j]));
            }
            res.add(list);
            return;
        }
        Arrays.fill(board[i],'.');
        for (int k = 0; k <n ; k++) {
            if (!j[k]&&!jio1[k+i]&&!jio2[i-k+n-1]){
                board[i][k]='Q';
                j[k]=true;
                jio1[k+i]=true;
                jio2[i-k+n-1]=true;
                back(n,i+1,board);
                board[i][k]='.';
                j[k]=false;
                jio1[k+i]=false;
                jio2[i-k+n-1]=false;
            }
        }
    }
}
 */


/*  fast 1ms
class Solution {
    public List<List<String>> results = new ArrayList<>();
    public String[] map;

    public List<List<String>> solveNQueens(int n) {
        int[] result = new int[n];
        int x = 0;

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++) {
            sb.append('.');
        }

        map = new String[n];
        for (int i=0;i<n;i++) {
            sb.setCharAt(i, 'Q');
            map[i] = sb.toString();
            sb.setCharAt(i, '.');
        }

        check(n, new int[n], 0);

        return results;
    }

    private void check(int n, int[] result, int pos) {
        if (pos == n) {
            List<String> r = new ArrayList<>();
            for (int i=0;i<n;i++) {
                r.add(map[result[i]]);
            }
            results.add(r);
            return;
        }

        int[] left = new int[n];

        for (int i=0;i<pos; i++) {
            left[result[i]]=1;
            if (result[i]-pos+i >= 0) {
                left[result[i]-pos+i]=1;
            }
            if (result[i]+pos-i < n) {
                left[result[i]+pos-i]=1;
            }
        }

        for (int i=0;i<n;i++) {
            if (left[i] == 0){
                result[pos] = i;
                check(n, result, pos+1);
            }
        }
    }
}
 */