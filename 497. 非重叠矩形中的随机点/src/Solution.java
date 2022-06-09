import java.util.*;

class Solution {

    private final int[][] rects;
    private final int[] pointsMap;
    private int allPoints = 0;
    private final Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.pointsMap = new int[rects.length];
        this.random = new Random();
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            allPoints += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            pointsMap[i] = allPoints;
        }
    }

    public int[] pick() {
        int randomPoint = random.nextInt(allPoints);
        for (int i = 0; i < pointsMap.length; i++){
            if (randomPoint < pointsMap[i]){
                int[] rect = this.rects[i];
                int pre = 0;
                if (i > 0){
                    pre = pointsMap[i - 1];
                }
                int cur = randomPoint - pre;
                int l = rect[2] - rect[0] + 1;
                int w = rect[3] - rect[1] + 1;
                int cl = cur / w;
                int cw = cur - w * cl;
                return new int[]{rect[0] + cl, rect[1] + cw};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{{1, 1, 5, 5}});
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }
}
