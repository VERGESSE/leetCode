class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        // 注意一定要转为long，否则 n = Integer.MIN_VALUE会溢出
        long tn =  n > 0 ?  n : -n;
        long cn = 1;
        double res = x;
        while(cn << 1 <= tn){
            res *= res;
            cn <<= 1;
        }
        res *= myPow(x, (int)(tn - cn));
        return n > 0 ? res : 1 / res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        System.out.println(solution.myPow(2, Integer.MIN_VALUE));
        System.out.println(System.currentTimeMillis() - l);
    }
}

/* 快速幂算法
public double myPow(double x, int n) {
    if(x == 0) return 0;
    long b = n;
    double res = 1.0;
    if(b < 0) {
        x = 1 / x;
        b = -b;
    }
    while(b > 0) {
        if((b & 1) == 1) res *= x;
        x *= x;
        b >>= 1;
    }
    return res;
}
 */
