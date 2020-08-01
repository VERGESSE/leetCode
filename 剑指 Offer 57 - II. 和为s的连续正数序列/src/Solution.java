import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {

        List<int[]> res = new ArrayList<>();
        int left = 1, right = 1;
        int sum = 0;
        while(left <= target / 2){
            if(sum < target)
                sum += right++;
            else if(sum > target)
                sum -= left++;
            else {
                int[] cur = new int[right - left];
                for(int i = left; i < right; i++)
                    cur[i - left] = i;
                res.add(cur);
                sum -= left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}


/*class Solution {
    public int[][] findContinuousSequence(int target) {

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= target / 2; i++)
            findContinuousSequence(res, i, target);

        int[][] ret = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            List<Integer> list = res.get(i);
            int[] c = new int[list.size()];
            for(int j = 0; j < list.size(); j++){
                c[j] = list.get(j);
            }
            ret[i] = c;
        }

        return ret;
    }

    private void findContinuousSequence(
            List<List<Integer>> res, int start, int target) {
        List<Integer> cur = new ArrayList<>();
        while(target > 0){
            cur.add(start);
            target -= start++;
            if(target == 0)
                res.add(cur);
        }
    }
}*/
