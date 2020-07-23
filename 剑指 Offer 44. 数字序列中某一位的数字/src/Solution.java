class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(Integer.MAX_VALUE));
        System.out.println(System.currentTimeMillis() - l);
    }
}

/* 超时
class Solution {
    public int findNthDigit(int n) {

        int cur = 0;
        int len = 0;
        for(; len <= n; cur ++){
            len += intBit(cur);
        }
        len -= intBit(--cur);

        return getInt(cur, n - len + 1);
    }

    private int intBit(int a){
        int res = 0;
        do {
            a /= 10;
            res ++;
        } while(a != 0);
        return res;
    }

    private int getInt(int a, int index){
        System.out.println(a);
        int intBit = intBit(a);
        if (intBit - index == 0)
            return a % 10;
        for (int i = intBit - index; i > 0; i--)
            a /= 10;
        return a % 10;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(Integer.MAX_VALUE));
        System.out.println(System.currentTimeMillis() - l);
    }
}
 */
