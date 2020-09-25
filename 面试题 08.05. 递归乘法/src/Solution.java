class Solution {
    public int multiply(int A, int B) {

        if (A == 0 || B == 0){
            return 0;
        }
        if(A == 1 || B == 1){
            return A == 1 ? B : A;
        }
        // 让B为较小的数
        if (A < B){
            int t = A; A = B; B = t;
        }
        int sum = A;
        int count = 1;
        while ((count << 1) <= B){
            sum += sum;
            count <<= 1;
        }
        sum += multiply(A, B - count);
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.nanoTime();
        System.out.println(solution.multiply(2, Integer.MAX_VALUE / 2));
        System.out.println(System.nanoTime() - l);
    }
}
