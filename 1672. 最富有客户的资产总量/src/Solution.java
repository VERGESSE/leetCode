class Solution {
    public int maximumWealth(int[][] accounts) {

        int num = accounts.length;
        int numOfBank = accounts[0].length;
        int total = 0;

        int cur = 0;
        for (int[] account : accounts) {
            for (int j = 0; j < numOfBank; j++) {
                cur += account[j];
            }
            total = Math.max(cur, total);
            cur = 0;
        }

        return total;
    }
}
