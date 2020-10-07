class Solution {
    public int findString(String[] words, String s) {

        int len = s.length();
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            if(cur.length() != len){
                continue;
            }
            if(s.equals(cur)){
                return i;
            }
        }
        return -1;
    }
}

/*
class Solution {
    public int findString(String[] words, String s) {
        int l = 0;
        int r = words.length-1;
        while(l<r){
            int mid = l + r >>1;
            int tem = mid;
            while(mid<r&&words[mid].equals("")){
                mid++;
            }
            if(words[mid].equals("")) {//此时r边界也是""
                r = tem;
                continue;
            }
            if(words[mid].compareTo(s)>0) r = mid-1;
            else if (words[mid].compareTo(s)==0) return mid;
            else l = mid + 1;
        }
        if(words[l].equals(s)) return l;
        return -1;
    }
}
 */
