class Solution {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length(), xy = 0, yx = 0;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        for(int i = 0; i < len; i ++) {
            if(cs1[i] == cs2[i]) {
                continue;
            }
            else if(cs1[i] == 'x') {
                xy ++;
            }
            else {
                yx ++;
            }
        }
        return ((xy + yx) & 1) == 1 ? -1 : (xy + 1) / 2 + (yx + 1) / 2;
    }
}
// 题解：https://leetcode-cn.com/problems/minimum-swaps-to-make-strings-equal/solution/java-tan-xin-suan-fa-xiang-jie-zhi-xing-yong-shi-n/
