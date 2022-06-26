import java.util.*;

class Solution {

    private final TreeMap<Integer, Integer> sumMap;
    private final List<int[]> subList;
    private int sum = 0;
    private final Random random = new Random();

    public Solution(int n, int[] blacklist) {
        sumMap = new TreeMap<>();
        subList = new ArrayList<>();
        Arrays.sort(blacklist);
        int start;
        int end;
        int index = 0;
        int blLength = blacklist.length + 2;
        int[] bl = new int[blLength];
        System.arraycopy(blacklist, 0, bl, 1, blacklist.length);
        bl[0] = -1; bl[blLength - 1] = n;
        for (int i = 0; i < blLength - 1; i++){
            start = bl[i];
            end = bl[i + 1];
            if (start + 1 >= end){
                continue;
            }
            sum += end - start - 1;
            sumMap.put(sum, index++);
            subList.add(new int[]{start + 1, end - 1});
        }
    }

    public int pick() {
        int r = random.nextInt(sum);
        Map.Entry<Integer, Integer> higherEntry = sumMap.higherEntry(r);
        if (higherEntry == null){
            return -1;
        }
        int[] sub = subList.get(higherEntry.getValue());
        return sub[0] + random.nextInt(sub[1] - sub[0] + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution(7, new int[]{2, 3, 5});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }
}

/* 黑名单映射
class Solution {
    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    public Solution(int n, int[] blacklist) {
        b2w = new HashMap<Integer, Integer>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;
        Set<Integer> black = new HashSet<Integer>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }
}
 */

