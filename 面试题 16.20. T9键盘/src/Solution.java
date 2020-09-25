import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private static final char[][] word = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> getValidT9Words(String num, String[] words) {

        char[] nums = num.toCharArray();
        int len = nums.length;
        Set<String> set = new HashSet<>();
        newWord:
        for(String s : words){
            if(s.length() != len){
                continue;
            }
            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                boolean flag = false;
                for(char t9 : word[nums[i] - '0']){
                    if(t9 == cur){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    continue newWord;
                }
            }
            set.add(s);
        }

        return new ArrayList<>(set);
    }
}
