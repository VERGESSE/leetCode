class Solution {
    public char firstUniqChar(String s) {

        if(s == null || s.equals("")) return ' ';
        int[] chars = new int[26];
        char[] array = s.toCharArray();

        for(char c : array){
            chars[c - 'a'] ++;
        }

        for(char c : array){
            if(chars[c - 'a'] == 1)
                return c;
        }

        return ' ';
    }
}

/* 2ms
class Solution {
    public char firstUniqChar(String s) {
        int index = -1;
        for(char c = 'a';c<='z';c++){
            int cur = s.indexOf(c);
            if(cur!=-1&&cur==s.lastIndexOf(c)){
                index = index==-1?cur:Math.min(index,cur);
            }
        }
        return index==-1?' ':s.charAt(index);
    }
}
 */
