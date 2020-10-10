class Solution {
    public boolean oneEditAway(String first, String second) {

        int len1 = first.length();
        int len2 = second.length();
        if(Math.abs(len1 - len2) > 1)
            return false;
        if(len1 > len2){
            String tmp = first;
            first = second; second = tmp;
            len1 = first.length();
            len2 = second.length();
        }
        boolean flag = true;
        if(len1 == len2){
            for(int i = 0; i < len1; i++){
                if(first.charAt(i) != second.charAt(i)){
                    if(flag)
                        flag = false;
                    else
                        return false;
                }
            }
        } else {
            int i = 0, j = 0;
            while(i < len1){
                if(first.charAt(i) != second.charAt(j)){
                    if(flag){
                        flag = false;
                        j++;
                        continue;
                    } else
                        return false;
                }
                i++; j++;
            }
        }
        return true;
    }
}
