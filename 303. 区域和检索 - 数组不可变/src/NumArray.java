class NumArray {

    private final int[] sums;

    public NumArray(int[] nums) {
        this.sums = nums;
        if(nums != null && nums.length > 0){
            for(int i = 1; i < nums.length; i++){
                sums[i] += sums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
