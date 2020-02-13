import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();

        if (n <= 0 || k <= 0 || k > n)
            return res;

        generateCombinations(n,k,1,new ArrayList<>());

        return res;
    }

    // 求解C(n,k)，从start开始搜索新的的元素
    private void generateCombinations(int n, int k, int start, ArrayList<Integer> list){

        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        // 还有k - list.size()个空位，所以，[i...n]中至少要有k-list.size()个元素
        // i最多为 n - (k-list.size()) + 1    -----30ms->2ms
        for (int i = start; i <= n - (k-list.size()) + 1; i++){
            list.add(i);
            generateCombinations(n,k,i+1,list);
            list.remove(list.size()-1);
        }

    }
}

/*  旧（未优化）
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();

        if (n <= 0 || k <= 0 || k > n)
            return res;

        generateCombinations(n,k,1,new ArrayList<>());

        return res;
    }

    // 求解C(n,k)，从start开始搜索新的的元素
    private void generateCombinations(int n, int k, int start, ArrayList<Integer> list){

        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++){
            list.add(i);
            generateCombinations(n,k,i+1,list);
            list.remove(list.size()-1);
        }

    }
}
 */