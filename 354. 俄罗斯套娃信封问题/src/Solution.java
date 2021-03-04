import java.util.Arrays;

// 最长上升子序列
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        int len = envelopes.length;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] memo = new int[len];
        Arrays.fill(memo,1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                int[] pre = envelopes[j];
                int[] cur = envelopes[i];
                if(cur[0] > pre[0] && cur[1] > pre[1]){
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i : memo){
            res = Math.max(res, i);
        }

        return res;
    }
}

/* 基于二分
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
 */
