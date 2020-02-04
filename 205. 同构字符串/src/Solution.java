import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
            return false;

        HashMap<Character,Character> isomorphicMapT = new HashMap<>();
        HashMap<Character,Character> isomorphicMapS = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Character oldCharS = isomorphicMapT.put(s.charAt(i), t.charAt(i));
            Character oldCharT = isomorphicMapS.put(t.charAt(i), s.charAt(i));
            if(oldCharT != null
                    && oldCharT != isomorphicMapS.get(t.charAt(i)))
                return false;
            if(oldCharS != null
                    && oldCharS != isomorphicMapT.get(s.charAt(i)))
                return false;
        }

        return true;
    }
}