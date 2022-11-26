import java.io.*;
import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        List<Object[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int[] line  = new int[]{1, edge[2], edge[2]};
            graph[edge[1]].add(new Object[]{edge[0], line});
            graph[edge[0]].add(new Object[]{edge[1], line});
        }

        int res = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{0, maxMoves, 0});
        boolean[] memo = new boolean[n];
        memo[0] = true;
        int[] maxDistance = new int[n];
        Arrays.fill(maxDistance, 0);
        while(!deque.isEmpty()) {
            int[] curPoint = deque.removeFirst();
            int cur = curPoint[0];
            if (maxDistance[cur] > curPoint[1]) {
                continue;
            }
            List<Object[]> point = graph[cur];
            for (Object[] nextPoint : point) {
                int next = (int) nextPoint[0];
                int[] remain = (int[]) nextPoint[1];
                final int step = Math.min(remain[2] + 1, curPoint[1]);
                if (cur < next) {
                    if (step >= remain[0]) {
                        int add = Math.max(Math.min(remain[1] - remain[0], step - remain[0]) + 1, 0);
                        res += add;
                        remain[0] += add;
                    }
                } else if (remain[2] - remain[1] < step) {
                    int des = Math.max(remain[1] - Math.max(remain[0] - 1, remain[2] - step), 0);
                    res += des;
                    remain[1] -= des;
                }
                if (step == remain[2] + 1) {
                    if (!memo[next]) {
                        memo[next] = true;
                        res++;
                    }
                    int maxDistanceInt = maxDistance[next];
                    if (curPoint[1] > step && maxDistanceInt < curPoint[1] - step) {
                        deque.addLast(new int[]{next, curPoint[1] - step, cur});
                        maxDistance[next] = curPoint[1] - step;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 13
        System.out.println(solution.reachableNodes(
                new int[][] {{0,1,10},{0,2,1},{1,2,2}},
                6,
                3
        ));
        // 17
        System.out.println(solution.reachableNodes(
                new int[][] {{0,1,11},{0,2,1},{1,2,2}},
                8,
                3
        ));
        // 18
        System.out.println(solution.reachableNodes(
                new int[][] {{2,4,2},{3,4,5},{2,3,1},{0,2,1},{0,3,5}},
                14,
                5
        ));
        int[][] ints = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("882. 细分图中的可到达节点\\11.txt"))) {
            String line = reader.readLine();
            String[] split = line.split("\\|");
            ints = new int[split.length][];
            for (int i = 0; i < split.length; i++) {
                int[] cur = new int[3];
                String[] split1 = split[i].split(",");
                cur[0] = Integer.parseInt(split1[0]);
                cur[1] = Integer.parseInt(split1[1]);
                cur[2] = Integer.parseInt(split1[2]);
                ints[i] = cur;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        long l = System.currentTimeMillis();
        // 12482956
        System.out.println(solution.reachableNodes(
                ints,
                820358,
                3000
        ));
        System.out.println((System.currentTimeMillis() - l) + "ms");
    }
}
