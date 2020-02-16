import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a,b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= intervals[pre][1]){
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }
}