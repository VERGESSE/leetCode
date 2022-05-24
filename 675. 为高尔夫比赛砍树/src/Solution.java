import java.util.*;

class Solution {

    private static final int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};

    public int cutOffTree(List<List<Integer>> forest) {

        PriorityQueue<Node> trees = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        // 获取所有树
        for (int i = 0; i < forest.size(); i++){
            for (int j = 0; j < forest.get(0).size(); j++){
                Integer v = forest.get(i).get(j);
                if (v > 1){
                    trees.add(new Node(v, i ,j));
                }
            }
        }

        int ret = 0;
        Node from = new Node(forest.get(0).get(0), 0 , 0);
        if (forest.get(0).get(0) > 1 && !trees.isEmpty()){
            if (forest.get(0).get(0) == trees.peek().value){
                trees.poll();
            }
        }
        while (!trees.isEmpty()){
            Node to = trees.poll();
            int distance = bfs(forest, from, to);
//            int distance = bfs2(forest, from.x, from.y, to.x, to.y);
            if (distance == -1){
                return -1;
            }
            ret += distance;
            from = to;
        }
        return ret;
    }

    private int bfs(List<List<Integer>> forest, Node from, Node to){
        if (from.x == to.x && from.y == to.y){
            return 0;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, from.x, from.y));
        int mx = forest.size();
        int my = forest.get(0).size();
        boolean[][] memo = new boolean[mx][my];
        memo[from.x][from.y] = true;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for (int[] dir : dirs) {
                int newX = cur.x + dir[0];
                int newY = cur.y + dir[1];
                if (verify(memo, newX, newY) && forest.get(newX).get(newY) != 0){
                    if (newX == to.x && newY == to.y){
                        return cur.value + 1;
                    }
                    // 广搜
                    queue.offer(new Node(cur.value + 1, newX, newY));
                    memo[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    public int bfs2(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }

        int row = forest.size();
        int col = forest.get(0).size();
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; ++j) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean verify(boolean[][] memo, int x, int y){
        int mx = memo.length;
        int my = memo[0].length;
        return x >= 0 && y >= 0 && x < mx && y < my && !memo[x][y];
    }

    static class Node {

        int value;
        int x;
        int y;

        Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> forest = new ArrayList<>();
//        forest.add(Arrays.asList(1,2,3));
//        forest.add(Arrays.asList(0,0,5));
//        forest.add(Arrays.asList(7,6,4));

        forest.add(Arrays.asList(69438,55243,0,43779,5241,93591,73380));
        forest.add(Arrays.asList(847,49990,53242,21837,89404,63929,48214));
        forest.add(Arrays.asList(90332,49751,0,3088,16374,70121,25385));
        forest.add(Arrays.asList(14694,4338,87873,86281,5204,84169,5024));
        forest.add(Arrays.asList(31711,47313,1885,28332,11646,42583,31460));
        forest.add(Arrays.asList(59845,94855,29286,53221,9803,41305,60749));
        forest.add(Arrays.asList(95077,50343,27947,92852,0,0,19731));
        forest.add(Arrays.asList(86158,63553,56822,90251,0,23826,17478));
        forest.add(Arrays.asList(60387,23279,78048,78835,5310,99720,0));
        forest.add(Arrays.asList(74799,48845,60658,29773,96129,90443,14391));
        forest.add(Arrays.asList(65448,63358,78089,93914,7931,68804,72633));
        forest.add(Arrays.asList(93431,90868,55280,30860,59354,62083,47669));
        forest.add(Arrays.asList(81064,93220,22386,22341,95485,20696,13436));
        forest.add(Arrays.asList(50083,0,89399,43882,0,13593,27847));
        forest.add(Arrays.asList(0,12256,33652,69301,73395,93440,0));
        forest.add(Arrays.asList(42818,87197,81249,33936,7027,5744,64710));
        forest.add(Arrays.asList(35843,0,99746,52442,17494,49407,63016));
        forest.add(Arrays.asList(86042,44524,0,0,26787,97651,28572));
        forest.add(Arrays.asList(54183,83466,96754,89861,84143,13413,72921));
        forest.add(Arrays.asList(89405,52305,39907,27366,14603,0,14104));
        forest.add(Arrays.asList(70909,61104,70236,30365,0,30944,98378));
        forest.add(Arrays.asList(20124,87188,6515,98319,78146,99325,88919));
        forest.add(Arrays.asList(89669,0,64218,85795,2449,48939,12869));
        forest.add(Arrays.asList(93539,28909,90973,77642,0,72170,98359));
        forest.add(Arrays.asList(88628,16422,80512,0,38651,50854,55768));
        forest.add(Arrays.asList(13639,2889,74835,80416,26051,78859,25721));
        forest.add(Arrays.asList(90182,23154,16586,0,27459,3272,84893));
        forest.add(Arrays.asList(2480,33654,87321,93272,93079,0,38394));
        forest.add(Arrays.asList(34676,72427,95024,12240,72012,0,57763));
        forest.add(Arrays.asList(97957,56,83817,45472,0,24087,90245));
        forest.add(Arrays.asList(32056,0,92049,21380,4980,38458,3490));
        forest.add(Arrays.asList(21509,76628,0,90430,10113,76264,45840));
        forest.add(Arrays.asList(97192,58807,74165,65921,45726,47265,56084));
        forest.add(Arrays.asList(16276,27751,37985,47944,54895,80706,2372));
        forest.add(Arrays.asList(28438,53073,0,67255,38416,63354,69262));
        forest.add(Arrays.asList(23926,75497,91347,58436,73946,39565,10841));
        forest.add(Arrays.asList(34372,69647,44093,62680,32424,69858,68719));
        forest.add(Arrays.asList(24425,4014,94871,1031,99852,88692,31503));
        forest.add(Arrays.asList(24475,12295,33326,37771,37883,74568,25163));
        forest.add(Arrays.asList(0,18411,88185,60924,29028,69789,0));
        forest.add(Arrays.asList(34697,75631,7636,16190,60178,39082,7052));
        forest.add(Arrays.asList(24876,9570,53630,98605,22331,79320,88317));
        forest.add(Arrays.asList(27204,89103,15221,91346,35428,94251,62745));
        forest.add(Arrays.asList(26636,28759,12998,58412,38113,14678,0));
        forest.add(Arrays.asList(80871,79706,45325,3861,12504,0,4872));
        forest.add(Arrays.asList(79662,15626,995,80546,64775,0,68820));
        forest.add(Arrays.asList(25160,82123,81706,21494,92958,33594,5243));
        long l = System.currentTimeMillis();
        System.out.println(solution.cutOffTree(forest));
        System.out.println("用时: " + (System.currentTimeMillis() - l) + " ms");
    }
}
