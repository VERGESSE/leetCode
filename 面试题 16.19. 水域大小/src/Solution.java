import java.util.*;

class Solution {

    private static final int[][] dirs = new int[][]{
            {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}
    };

    public int[] pondSizes(int[][] land) {

        List<Integer> resList = new ArrayList<>();
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[0].length; y++){
                if (land[x][y] == 0){
                    int num = dfs(land, x, y);
                    resList.add(num);
                }
            }
        }
        Collections.sort(resList);
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int dfs(int[][] land, int x, int y){
        if(land[x][y] != 0){
            return 0;
        }
        land[x][y] = -1;
        int num = 1;
        for(int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX >= 0 && newX < land.length
                    && newY >= 0 && newY < land[0].length){
                num += dfs(land, newX, newY);
            }
        }
        return num;
    }
}
