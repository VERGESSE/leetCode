import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        char[] map = new char[26];
        char[] mapRev = new char[26];
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < pattern.length(); i ++){
                char a = word.charAt(i);
                char b = pattern.charAt(i);
                if ((map[b - 'a'] != 0 && map[b - 'a'] != a)
                        || (mapRev[a - 'a'] != 0 && mapRev[a - 'a'] != b)){
                    flag = false;
                    break;
                }
                map[b - 'a'] = a;
                mapRev[a - 'a'] = b;
            }
            if (flag){
                ret.add(word);
            }
            map = new char[26];
            mapRev = new char[26];
        }

        return ret;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAndReplacePattern(
                new String[]{"abc","cba","xyx","yxx","yyx"},
                "abc"));
    }
}
