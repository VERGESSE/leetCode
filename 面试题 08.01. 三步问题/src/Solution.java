class Solution {
    public int waysToStep(int n) {

        if (n < 4) {
            return n == 3 ? 4 : n;
        }

        int one = 4;
        int two = 2;
        int three = 1;

        for(int i = 4; i <= n; i++){
            if(i % 3 == 1)
                three = ((one + two) % 1000000007 + three) % 1000000007;
            else if(i % 3 == 2)
                two = ((one + two) % 1000000007 + three) % 1000000007;
            else if(i % 3 == 0)
                one = ((one + two) % 1000000007 + three) % 1000000007;
        }

        return n % 3 == 1 ? three : n % 3 == 2 ? two : one;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToStep(1000000));
    }
}
