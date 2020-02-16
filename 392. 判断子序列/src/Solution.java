class Solution {
    public boolean isSubsequence(String s, String t) {

        int n = -1;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            n = t.indexOf(c,n+1);
            if (n == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc","ahbgdc"));
    }
}

/**  fast 0ms
 class Solution {
     public boolean isSubsequence(String s, String t) {
         int index = -1;
         for (char c : s.toCharArray()){
             index = t.indexOf(c, index+1);
             if (index == -1) return false;
        }
    return true;
    }
 }
 */