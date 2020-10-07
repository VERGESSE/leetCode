class Solution {
    public boolean canPermutePalindrome(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean odd = len % 2 == 1;
        int[] map = new int[256];
        for (char c : chars) {
            map[c]++;
        }
        for (int n : map) {
            if (n % 2 != 0){
                if (!odd)
                    return false;
                else
                    odd = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("atcocta"));
    }
}
