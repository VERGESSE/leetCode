import java.util.*;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        for (int[] position : positions) {
            position[0] = position[0] + position[1];
        }
        Arrays.sort(positions, Comparator.comparingInt(position -> position[0]));

        List<Integer> ret = new ArrayList<>(n);
        ret.set(0, positions[0][1]);

        for (int i = 1; i < n; i ++){

        }

        return ret;
    }
}
