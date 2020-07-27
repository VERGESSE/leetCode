class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                return false;
            }
        }
        return true;
    }

    private static int indexOf(String[] arrays, String searchString) {
        int ans = -1;
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(searchString)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}

/*
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String s = map.get(c);
            if(s == null){
                map.put(c, words[i]);
                if(map2.get(words[i]) != null)
                    return false;
                map2.put(words[i], c);
            } else if(!s.equals(words[i])){
                return false;
            }
        }
        return true;
    }
}
 */

/*
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Object, Integer> mem = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            if (!Objects.equals(mem.put(words[i], i), mem.put(pattern.charAt(i), i)))
                return false;
        return true;
    }
}
 */
