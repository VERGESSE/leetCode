class Solution {
    public int numWays(int n) {

        int m = 0, p = 0;
        int r = 1;
        for(int i = 0; i < n; i++){
            m = p;
            p = r;
            r = (m + p) % 1000000007;
        }

        return r;
    }
}
