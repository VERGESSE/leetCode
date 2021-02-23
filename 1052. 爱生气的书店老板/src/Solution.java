class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int len = customers.length;
        if(len != grumpy.length) return -1;

        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += grumpy[i] == 0 ? customers[i] : 0;
        }

        int extra = 0;
        int r = 0;
        while(r < X){
            extra += grumpy[r] == 1 ? customers[r] : 0;
            r++;
        }
        int maxExtra = extra;
        while(r < len){
            extra -= grumpy[r - X] == 1 ? customers[r - X] : 0;
            extra += grumpy[r] == 1 ? customers[r] : 0;
            maxExtra = Math.max(maxExtra, extra);
            r++;
        }

        return sum + maxExtra;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(
                new int[]{10, 1, 7},
                new int[]{0, 0, 0},
                2
        ));
    }
}
