class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(7));
    }
}


/* 超时
import java.math.BigInteger;

class Solution {
    public int trailingZeroes(int n) {

        // Calculate n!
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        // Count how many 0's are on the end.
        int zeroCount = 0;

        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }

        return zeroCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(7));
    }
}
 */

