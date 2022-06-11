class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int zeros = 0;
        int ones = 0;
        for (char c : chars) {
            if (c == '0'){
                zeros++;
            }
        }
        if (zeros == 0 || zeros == chars.length){
            return 0;
        }
        int ret = zeros;
        for (char c : chars) {
            if (c == '0'){
                zeros --;
            } else {
                ones ++;
            }
            ret = Math.min(ret, zeros + ones);
        }

        return ret;
    }
}

/* 动态规划
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }
}
 */
