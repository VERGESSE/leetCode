import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int n = costs.length;
        int sum = 0;
        int cont = 0;
        for(int i = 0; i < n; i++){
            sum += costs[i];
            if(sum <= coins){
                cont++;
            } else {
                break;
            }
        }
        return cont;
    }
}

/*
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;
    }
}

 */
