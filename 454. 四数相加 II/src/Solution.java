import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int ret = 0;

        Map<Integer,Integer> CDMap = new HashMap<>();

        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++) {
                Integer count = CDMap.getOrDefault(C[i] + D[j], 0);
                CDMap.put(C[i] + D[j], count + 1);
            }
        }

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(CDMap.getOrDefault( 0 - A[i] - B[j], 0) != 0){
                    ret += CDMap.get(0 - A[i] - B[j]);
                }
            }
        }

        return ret;
    }
}