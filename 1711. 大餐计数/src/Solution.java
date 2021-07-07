class Solution {
	public static int countPairs(int[] ds) {
		int min, max;
		min = max = ds[0];
		for (int v : ds) {
			if (v < min)
				min = v;
			else if (v > max)
				max = v;
		}
		int[] map = new int[max - min + 1];
		long res = 0;
		for (int v : ds) {
			for(int s=1;;s<<=1) {
				int x = s - v;
				if(x < min) continue;
				if(x > max) break;
				res += map[x-min];
			}
			map[v - min]++;
		}
		return (int) (res % 1_000_000_007L);
	}
}

/*
class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}
 */
