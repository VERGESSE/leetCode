class Solution {
    public int countTriplets(int[] arr) {

        int n = arr.length;
        if(n == 1){
            return 0;
        }
        int[] memo = new int[n + 1];
        for(int i = 0; i < n; i++){
            memo[i + 1] = arr[i] ^ memo[i];
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (memo[i] == memo[k + 1]) {
                    count += k - i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countTriplets(new int[]{2,3,1,6,7}));
    }
}

/* 哈希表 一重循环
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0, s = 0;
        for (int k = 0; k < n; ++k) {
            int val = arr[k];
            if (cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s ^= val;
        }
        return ans;
    }
}
 */
