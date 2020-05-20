import java.util.Arrays;

class Solution {
    public int findTheLongestSubstring(String s) {

        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;

        int score = 0, ans = 0;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == 'a')
                score ^= 1;
            else if(cur == 'e')
                score ^= 1 << 1;
            else if(cur == 'i')
                score ^= 1 << 2;
            else if(cur == 'o')
                score ^= 1 << 3;
            else if(cur == 'u')
                score ^= 1 << 4;

            if(pos[score] >= 0){
                ans = Math.max(ans, i + 1 - pos[score]);
            } else {
                pos[score] = i + 1;
            }
        }

        return ans;
    }
}