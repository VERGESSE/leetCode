import java.util.Scanner;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        return numBottles +
                numWaterBottlesEmpty(numExchange, numBottles);
    }

    private int numWaterBottlesEmpty(int numExchange, int empty) {
        if(empty < numExchange){
            return 0;
        }
        int n = empty / numExchange;
        empty %= numExchange;
        empty += n;
        return n + numWaterBottlesEmpty(numExchange, empty);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        System.out.println(
                solution.numWaterBottles(1000, 2)
        );
    }
}
