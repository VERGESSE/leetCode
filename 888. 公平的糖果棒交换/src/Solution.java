import java.util.Arrays;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int lenA = A.length;
        int lenB = B.length;

        int sumA = 0;
        for (int i : A) {
            sumA += i;
        }
        int sumB = 0;
        for (int i : B) {
            sumB += i;
        }

        int sub = (sumA - sumB) / 2;

        int a = 0;
        int b = 0;
        while(a < lenA && b < lenB){
            if(A[a] - B[b] == sub){
                return new int[]{A[a], B[b]};
            }
            if (A[a] - B[b] > sub) {
                b++;
            } else {
                a++;
            }
        }

        return new int[]{0, 0};
    }
}

/* 哈希表
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
 */
