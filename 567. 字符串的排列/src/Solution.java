class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int len = s1.length();
        if(len > s2.length()){
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        char[] chars = s2.toCharArray();
        for(int i = 0; i < len; i++){
            map1[s1.charAt(i) - 'a'] ++;
            map2[chars[i] - 'a'] ++;
        }
        if(same(map1, map2)){
            return true;
        }

        for(int i = len; i < s2.length(); i++){
            map2[chars[i - len] - 'a']--;
            map2[chars[i] - 'a']++;
            if(same(map1, map2)){
                return true;
            }
        }
        return false;
    }

    private boolean same(int[] a1, int[] a2){
        if(a1.length != a2.length){
            return false;
        }
        for(int i = 0; i < a1.length; i++){
            if(a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }
}
