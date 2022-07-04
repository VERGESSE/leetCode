import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++){
            int curDiff = arr[i + 1] - arr[i];
            if (curDiff == minDiff) {
                ArrayList<Integer> one = new ArrayList<>(2);
                one.add(arr[i]);
                one.add(arr[i+ 1]);
                res.add(one);
            } else if (curDiff < minDiff){
                minDiff = curDiff;
                res.clear();
                ArrayList<Integer> one = new ArrayList<>(2);
                one.add(arr[i]);
                one.add(arr[i+ 1]);
                res.add(one);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumAbsDifference(new int[]{1,2,3,4}));
    }
}
