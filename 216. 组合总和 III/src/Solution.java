import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (n < 0 || k < 0 || k > n || n > 55)
            return res;

        generateCombinationSum(n,1,k,new ArrayList<>());
        return res;
    }

    private void generateCombinationSum(int n, int start, int k,ArrayList<Integer> list) {

        if (n == 0 && k == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9 && i <= n && k > 0; i++){
            list.add(i);
            generateCombinationSum(n-i,i+1,k-1,list);
            list.remove(list.size()-1);
        }
    }
}