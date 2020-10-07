class Solution {
    public int minCount(int[] coins) {

        int time = 0;
        for(int num : coins){
            //time += num / 2 + num % 2;
            time += (num + 1) / 2;
        }
        return time;
    }
}

/*
class Solution {
    public int minCount(int[] coins) {
        return Arrays.stream(coins).map(num -> (num + 1) / 2).sum();
    }
}
 */
