class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        boolean[] exists = new boolean[n + 1];
        int multiNum = 0;
        int missNum = n + 1;
        for(int num : nums){
            if(!exists[num]){
                exists[num] = true;
            } else {
                multiNum = num;
            }
        }
        for(int i = 1; i < exists.length; i++){
            if(!exists[i]){
                missNum = i;
            }
        }
        return new int[]{multiNum, missNum};
    }
}
