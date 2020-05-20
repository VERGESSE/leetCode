class Solution {
    public boolean validPalindrome(String s) {

        // 取i,j两个指针分别指向头和尾
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j){
            // 如果当前位不符合回文字符串，则去判断删去左边或者右边是否是回文字符串
            if (chars[i] != chars[j]){
                return isPalindrome(chars, i+1, j) ||
                        isPalindrome(chars, i, j-1);
            }
            i++;
            j--;
        }

        return true;
    }

    /**
     * 判断是否回文字符串
     */
    private boolean isPalindrome(char[] chars, int i, int j){

        while (i < j){
            if(chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}