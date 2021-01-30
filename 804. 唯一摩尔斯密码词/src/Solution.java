import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final String[] PASSWORD = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {

        Set<String> set = new HashSet<>();

        for(String word : words){
            StringBuffer sb = new StringBuffer();
            char[] chars = word.toCharArray();
            for(char c : chars){
                sb.append(PASSWORD[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
