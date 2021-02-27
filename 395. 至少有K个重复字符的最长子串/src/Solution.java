import java.util.*;

// 分治
class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    private int dfs(String s, int left, int right, int k){
        if (left > right || right - left + 1 < k){
            return 0;
        }
        int[] map = new int[26];
        for (int i = left; i <= right; i++){
            map[s.charAt(i) - 'a']++;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++){
            if (map[i] > 0 && map[i] < k){
                set.add((char) ('a' + i));
            }
        }
        if (set.size() == 0){
            return right - left + 1;
        }
        int ans = 0;
        int l = left, r = left;
        while (r <= right){
            if (set.contains(s.charAt(r))){
                ans = Math.max(ans, dfs(s, l, r-1, k));
                l = r + 1;
                //保证l合法
                while (l <= right && set.contains(s.charAt(l))){
                    l++;
                }
                if (l > right){
                    break;
                }
                r = l;
            }
            else {
                r++;
            }
        }
        if (l <= right){
            ans= Math.max(ans, dfs(s, l, r-1, k));
        }
        return ans;
    }
}
