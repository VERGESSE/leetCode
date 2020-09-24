class Solution {
    public int massage(int[] nums) {
        int first=0;
        int second=0;
        for(int i:nums){
            int temp=second;
            second=Math.max(second,first+i);
            first=temp;
        }
        return second;
    }
}
