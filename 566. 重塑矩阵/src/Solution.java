class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if(nums == null){
            return nums;
        }
        int row = nums.length;
        if(row == 0){
            return nums;
        }
        int cow = nums[0].length;
        if(row * cow != r * c){
            return nums;
        }
        int[][] res = new int[r][c];

        int index = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++, index++){
                int x = index / cow;
                int y = index % cow;
                res[i][j] = nums[x][y];
            }
        }

        return res;
    }
}
