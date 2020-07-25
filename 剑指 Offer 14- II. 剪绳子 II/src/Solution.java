// 数学规律 最多3相乘时最大
class Solution {
    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        System.out.println(solution.cuttingRope(1000));
        System.out.println(System.currentTimeMillis() - l);
    }
}


