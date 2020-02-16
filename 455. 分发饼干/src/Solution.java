import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int si = s.length-1,gi = g.length-1;

        while ( si >= 0 && gi >= 0 ){

            if (s[si] >= g[gi]){
                res++;
                gi--; si--;
            }else
                gi--;
        }

        return res;
    }
}