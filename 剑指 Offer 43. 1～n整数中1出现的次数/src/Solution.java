class Solution {
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

/*
public class Solution {
    public int countDigitOne(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
            //此处将a分为小于1，等于1，大于1三种
            //a+8就是分成两种情况，小于2的+8不进位，大于等于2的+8进位。
            //a % 10 == 1 再把小于2的分成0和1
        }
        return cnt;
    }
}
 */
