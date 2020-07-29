class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() <= 1)
            return s.length();
        int left = 0;
        int right = 0;
        int[] memo = new int[256];
        int res = 0;
        char[] chars = s.toCharArray();
        while(right < s.length()){
            memo[chars[right]]++;
            while(memo[chars[right]] > 1){
                memo[chars[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
