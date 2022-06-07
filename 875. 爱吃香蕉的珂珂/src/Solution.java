class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;
        if(len > h) return -1;

        int maxPiles = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPiles = Math.max(pile, maxPiles);
        }

        int l = 1;
        int r = maxPiles;
        while (l <= r){
            int k = l + (r - l) / 2;
            int time = 0;
            for (int pile : piles) {
                if (pile <= k) {
                    time++;
                } else {
                    int c = pile % k == 0 ? 0 : 1;
                    time += pile / k + c;
                }
            }
            if(time <= h){
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{980628391,681530205,734313996,168632541}, 819870953));
    }
}

/*  冗余版
    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;
        if(len > h) return -1;

        Arrays.sort(piles);
        if(len == h) return piles[len - 1];

        int l = 0, r = len - 1;
        int maxK = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int k = piles[mid];
            if (k == 0){
                l = mid + 1;
                continue;
            }
            int time = 0;
            for (int pile : piles) {
                if (pile <= k) {
                    time++;
                } else {
                    int c = pile % k == 0 ? 0 : 1;
                    time += pile / k + c;
                }
            }
            if(time <= h){
                r = mid - 1;
                maxK = mid;
            } else {
                l = mid + 1;
            }
        }

        l = maxK == 0 ? 0 : piles[maxK - 1];
        r = piles[maxK];
        while (l <= r){
            int k = l + (r - l) / 2;
            if (k <= 0){
                break;
            }
            int time = 0;
            for (int pile : piles) {
                if (pile <= k) {
                    time++;
                } else {
                    int c = pile % k == 0 ? 0 : 1;
                    time += pile / k + c;
                }
            }
            if(time <= h && time > 0){
                r = k - 1;
                maxK = k;
            } else {
                l = k + 1;
            }
        }

        return maxK;
    }
 */
