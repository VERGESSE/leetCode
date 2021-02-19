class Solution {
    public int longestOnes(int[] A, int K) {

        int len = A.length;
        int l = 0, r = 0;
        int zeroNum = 0;

        while(zeroNum < K && r < len){
            zeroNum += A[r] ^ 1;
            r++;
        }
        if (r == len){
            return len;
        }

        for (; r < len; r++){
            if(A[r] == 0 || zeroNum > K){
                if(zeroNum < K){
                    zeroNum++;
                } else {
                    zeroNum -= A[l] ^ 1;
                    zeroNum += A[r] ^ 1;
                    l++;
                }
            }
        }

        return r - l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestOnes(
                new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},
                3
        ));
    }
}

/* 简化版
class Solution {
    public int longestOnes(int[] A, int K) {

        int len = A.length;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        while (right < len) {
            if (A[right++]==0){
                maxCount++;
            }
            if (maxCount>K){
                if (A[left++]==0){
                    maxCount--;
                }
            }
        }

        return right - left;
    }
}
 */
