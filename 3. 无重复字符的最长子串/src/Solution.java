import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;

        while( l < s.length()){

            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)] ++;
            }else {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res ,r - l +1);
        }

        return res;
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() < 2) return s.length();
        char[] chars = s.toCharArray();
        int l = 0, r = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap();

        while(r < chars.length){
            char cur = chars[r];
            if(!map.containsKey(cur)){
                map.put(cur, r);
            }else {
                int temp = map.get(cur) + 1;
                while(l < temp)
                    map.remove(chars[l++]);
                map.put(cur, r);
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
