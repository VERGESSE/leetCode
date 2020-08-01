class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非 *
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1)
                                || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2)
                                || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch(
                "aaa", "a*a"
        ));
    }
}

/* 失败思路
class Solution {
    public boolean isMatch(String s, String p) {

        if (s.length() == 0 && p.length() == 0)
            return true;
        else if(s.length() == 0 || p.length() == 0)
            return false;
        int index = 0;
        int pindex = 0;
        int len = s.length();
        int plen = p.length();

        while (index < len && pindex < plen){
            if (pindex < plen - 1 && p.charAt(pindex + 1) == '*'){
                char cur = p.charAt(pindex);
                while (index < len
                        && (s.charAt(index) == cur || cur == '.'))
                    index++;
                pindex += 2;
            } else {
                if (s.charAt(index) != p.charAt(pindex)
                        && p.charAt(pindex) != '.')
                    return false;
                index++; pindex++;
            }
        }
        return pindex == plen && index == len;
    }
}*/
