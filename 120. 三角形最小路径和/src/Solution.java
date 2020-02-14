import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<Integer> last = triangle.get(triangle.size() - 1);
        int[] meno = new int[last.size()];

        for (int i = 0; i < last.size(); i++){
            meno[i] = last.get(i);
        }

        for (int i = triangle.size()-2; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < i+1; j++){
                meno[j] = list.get(j) + Math.min(meno[j],meno[j+1]);
            }
        }

        return meno[0];
    }
}