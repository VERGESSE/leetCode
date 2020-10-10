class Solution {
    public boolean isUnique(String astr) {

        char[] charNum = new char[256];

        for(char c : astr.toCharArray()){
            if(charNum[c] > 0){
                return false;
            }
            charNum[c]++;
        }
        return true;
    }
}
