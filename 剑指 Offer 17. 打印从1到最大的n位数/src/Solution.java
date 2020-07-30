class Solution {
    public int[] printNumbers(int n) {
        int max = 1;
        while(n-- > 0)
            max *= 10;
        int[] res = new int[max - 1];
        for(int i = 0; i < max - 1; i++)
            res[i] = i + 1;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = solution.printNumbers(3);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
