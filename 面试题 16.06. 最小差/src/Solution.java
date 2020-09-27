import java.util.Arrays;

class Solution {
    public int smallestDifference(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) return -1;
        int minDiff = Integer.MAX_VALUE , aIdx = 0 , bIdx = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (aIdx < a.length && bIdx < b.length) {
            // 解决溢出
            minDiff = (int)Math.min(minDiff, Math.abs((long)a[aIdx] - b[bIdx]));

            if (a[aIdx] < b[bIdx]) {
                aIdx++;
            }
            else {
                bIdx++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestDifference(
                new int[]{-2147483648,1},
                new int[]{2147483647,0}
        ));
    }
}
