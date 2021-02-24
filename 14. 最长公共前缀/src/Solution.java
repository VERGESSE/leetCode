class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int len = strs.length;
        if(len == 1){
            return strs[0];
        }
        int max = longestCommonPrefix(strs[0], strs[1]);

        for(int i = 2; i < len; i++){
            if(strs[i].length() < max){
                max = strs[i].length();
            }
            while(max > 0 && strs[0].charAt(max - 1) != strs[i].charAt(max - 1)){
                max --;
            }
        }

        if(max <= 0){
            return "";
        }

        return strs[0].substring(0, max);
    }

    private int longestCommonPrefix(String s1, String s2) {
        int max = Math.min(s1.length(), s2.length());
        for(int i = 0; i < max; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return i;
            }
        }
        return max;
    }
}
