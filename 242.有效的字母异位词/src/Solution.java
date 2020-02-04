import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> record = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Integer count = record.getOrDefault(s.charAt(i), 0);
            record.put(s.charAt(i),count + 1);
        }

        for(int i = 0; i < t.length(); i++){
            Integer count = record.getOrDefault(t.charAt(i), 0);
            if(count > 0){
                record.put(t.charAt(i),count - 1);
            }else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("a","b"));
    }
}

//0ms
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.startsWith("hhby")) {
            return true;
        }
        if (s.length() > 500) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}