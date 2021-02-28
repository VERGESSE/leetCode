class Solution {
    public boolean isMonotonic(int[] A) {

        int len  = A.length;
        if(len < 2){
            return true;
        }

        int index = 1;
        while (index < len && A[index] == A[index - 1]){
            index++;
        }
        if(index >= len){
            return true;
        }
        boolean flag = A[index - 1] > A[index];

        for(int i = 1; i < len; i++){
            while (i < len && A[i] == A[i - 1]){
                i++;
            }
            if(i >= len){
                break;
            }
            if(flag){
                if(A[i] > A[i - 1]){
                    return false;
                }
            } else {
                if(A[i] < A[i - 1]){
                    return false;
                }
            }
        }

        return true;
    }
}

/* 简洁
class Solution {
    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
 */
