class Solution {

    public int cuttingRope(int n) {
        if (n <= 2)
            return 1;
        int res = 0;
        for(int i = 2; i < n; i++){
            int a = n / i;
            int b = n % i;
            int cur = 1;
            for(int j = 0; j < i; j++){
                if (j < b)
                    cur *= a + 1;
                else
                    cur *= a;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        System.out.println(solution.cuttingRope(58));
        System.out.println(System.currentTimeMillis() - l);
    }
}

/* 递归回溯 超时
class Solution {

    private int res = 0;

    public int cuttingRope(int n) {

        for(int i = 1; i < n; i++)
            help(i, n - i);
        return res;
    }

    private void help(int sum, int n){
        if(n == 0){
            res = Math.max(sum, res);
        }
        for(int i = 1; i <= n; i++){
            help(sum * i, n - i);
        }
    }
}

 */
