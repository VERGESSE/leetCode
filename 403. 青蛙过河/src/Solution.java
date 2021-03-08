class Solution {
    public boolean canCross(int[] stones) {

        if (stones[1] > 1){
            return false;
        }
        boolean[][] memo = new boolean[stones.length][stones.length];
        return dfs(stones, 0, 1, memo);
    }

    private boolean dfs(int[] stones, int index, int k, boolean[][] memo){
        if(index == stones.length - 1){
            return true;
        }
        if (memo[index][k]){
            return false;
        }

        int max = stones[index] + k + 1;
        int K = stones[index] + k;
        for(int i = index + 1; i < stones.length; i++){
            if(stones[i] > max){
                break;
            }
            if(stones[i] == K - 1){
                if(dfs(stones, i, k - 1, memo)){
                    return true;
                }
                memo[i][k - 1] = true;
            } else if(stones[i] == K){
                if(dfs(stones, i, k, memo)){
                    return true;
                }
                memo[i][k] = true;
            } else if(stones[i] == K + 1){
                if(dfs(stones, i, k + 1, memo)) {
                    return true;
                }
                memo[i][k + 1] = true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCross(
                new int[]{0,1,3,5,6,8,12,17}
        ));
    }
}

/* 动态规划
public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
 */
