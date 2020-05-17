import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 建立图
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // 返回结果
        int[] res = new int[numCourses];
        // 记录当年索引
        int index = 0;
        // 记录每个节点的入度值
        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            // 为有向图增加边
            List<Integer> list =
                    graph.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            graph.put(prerequisite[1], list);
            // 增加入度值
            indegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++)
            if (indegrees[i] == 0)
                queue.add(i);

        while(!queue.isEmpty()){
            Integer cur = queue.remove();
            res[index++] = cur;

            for (Integer next : graph.getOrDefault(cur, new ArrayList<>())) {
                indegrees[next]--;
                if (indegrees[next] == 0)
                    queue.add(next);
            }
        }

        // 如果存在环，即无法拓扑排序，返回空数组
        return index == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] order = solution
                .findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for (int i : order) {
            System.out.print(i + " ");
        }
    }
}