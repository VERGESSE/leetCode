import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {

        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length);
        Arrays.sort(expected);

        int res = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expected[i]){
                res++;
            }
        }
        return res;
    }
}

/* fast
class Solution {
    public int heightChecker(int[] heights) {
        int count[]=new int[105];
        for(int i=0;i<heights.length;i++){count[heights[i]]++;}
        int ans=0;
        for(int i=0,j=1;i<heights.length;i++){
            while(count[j]==0){j++;}
            if(j!=heights[i]){ans++;}
            count[j]--;
        }
        return ans;
    }
}
 */
