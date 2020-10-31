import java.util.*;

class Solution {
    public List<String> commonChars(String[] A) {

        int[] chars = new int[26];
        for(char c : A[0].toCharArray()){
            chars[c - 'a'] ++;
        }
        for(int i = 1; i < A.length; i++){
            int[] cur = new int[26];
            for(char c : A[i].toCharArray()){
                cur[c - 'a'] ++;
            }
            for(int j = 0; j < 26; j++){
                if(chars[j] == 0 || cur[j] == 0){
                    chars[j] = 0;
                } else {
                    chars[j] = Math.min(chars[j], cur[j]);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0){
                while(chars[i]-- > 0){
                    res.add((char)(i + 'a') + "");
                }
            }
        }
        return res;
    }
}
