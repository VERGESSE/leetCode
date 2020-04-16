import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        int length = intervals.length;
        if (length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>(intervals.length);
        int[] cur = new int[2];
        for (int i = 0; i < length; i++){
            cur[0] = intervals[i][0];
            cur[1] = intervals[i][1];
            while ((i < length-1 && intervals[i+1][0] <= cur[1])){
                if (intervals[i+1][1] > cur[1])
                    cur[1] = intervals[i+1][1];
                i++;
            }
            int[] temp = new int[2];
            System.arraycopy(cur,0,temp,0,temp.length);
            res.add(temp);
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] merge = solution.merge(intervals);
        for (int[] interval : merge) {
            for (int i : interval)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

/*
class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
 */