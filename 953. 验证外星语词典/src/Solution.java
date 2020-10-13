class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] dic = new int[26];
        for(int i = 0; i < order.length(); i++){
            dic[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++){
            if(compare(words[i - 1], words[i], dic) > 0)
                return false;
        }
        return true;
    }

    private int compare(String s1, String s2, int[] dic){
        int index = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while(index < len1 && index < len2){
            int i = dic[s1.charAt(index) - 'a'];
            int j = dic[s2.charAt(index) - 'a'];
            if(i > j)
                return 1;
            else if(i < j)
                return -1;
            index++;
        }
        if(index < len1)
            return 1;
        else if(index < len2)
            return -1;

        return 0;
    }
}
