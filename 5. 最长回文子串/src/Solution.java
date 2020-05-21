// 中心扩展算法
class Solution {
    public String longestPalindrome(String s) {

        if(s == null || s.length() < 1) return "";
        char[] chars = s.toCharArray();
        int l = 0, r = 0;

        for(int i = 0; i < chars.length; i++){
            int len1 = numOfIndex(chars, i, i);
            int len2 = numOfIndex(chars, i, i+1);
            int len = Math.max(len1, len2);

            if(len > r - l){
                l = i - (len - 1) / 2;
                r = i + len / 2;
            }
        }

        return s.substring(l, r + 1);
    }

    // 计算从left到right为中心的回文长度
    private int numOfIndex(char[] chars, int left, int right){

        while(left >= 0 && right < chars.length && chars[left] == chars[right]){
            left--;
            right++;
        }
        // 每轮循环之后right和left都比正确索引大了1，所以返回值为right - left - 1
        return right - left - 1;
    }
}