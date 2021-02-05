class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int len = s.length();
        int[] subArray = new int[len];

        for(int i = 0; i < len; i++){
            subArray[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int sum = 0;
        int max = 0;
        int l = 0, r = 0;
        while(r < len){
            sum += subArray[r++];
            if(sum > maxCost){
                sum -= subArray[l++];
            } else{
                max = Math.max(max, r - l);
            }
        }

        return max;
    }
}
