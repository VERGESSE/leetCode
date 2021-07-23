import java.util.Arrays;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {

        Arrays.sort(ranges, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        if(ranges[0][0] > left){
            return false;
        }
        if(ranges[0][1] >= right){
            return true;
        }
        int r = ranges[0][1];
        int i = 0;
        while(r < left && i < ranges.length - 1){
            r = ranges[++i][1];
        }
        for(; i < ranges.length; i++){
            if(ranges[i][0] - 1 > r){
                return false;
            }
            r = Math.max(ranges[i][1], r);
            if(r >= right){
                return true;
            }
        }
        return false;
    }
}

/*
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] count = new int[51];
        for(int[] range:ranges){
            int l=Math.max(range[0],left);
            int r=Math.min(range[1],right);
            for(int i=l; i<=r;i++){
                count[i]=1;
            }
        }
        for(int i=left; i<=right; i++){
            if(count[i]==0){
                return false;
            }
        }
        return true;
    }
}
 */
