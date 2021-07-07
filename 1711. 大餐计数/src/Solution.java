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
