import java.util.*;

class Solution {
    public int subarraysDivByK(int[] A, int K) {

        int res = 0;
        int[] map = new int[K];
        map[0] = 1;
        int sum = 0;

        for (int num : A) {
            sum += num;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            res += map[modulus];
            map[modulus] ++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{2,-2,2,-4};
        int divByK = solution.subarraysDivByK(A, 6);
        System.out.println(divByK);
    }
}

/*
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}
 */