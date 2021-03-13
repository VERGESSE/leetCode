package five;

import java.util.*;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] height = new int[n + 1];
        for(int i = 0; i < n; i++){
            height[i + 1] = in.nextInt();
        }
        Map<Integer, List<Integer>> graph = new HashMap<>((int)(n / 0.75));
        for(int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            List<Integer> list = graph.getOrDefault(a, new ArrayList<>());
            list.add(b);
            graph.put(a, list);
            list = graph.getOrDefault(b, new ArrayList<>());
            list.add(a);
            graph.put(b, list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
        }
        int[] memo = new int[n + 1];
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (Integer cur : graph.keySet()) {
            int dfs = dfs(graph, set, memo, cur, height);
            memo[cur] = dfs;
            res = Math.max(res, dfs);
        }
        System.out.println(res);
    }

    private static int dfs(Map<Integer, List<Integer>> graph, Set<Integer> set, int[] memo, int cur, int[] height){
        List<Integer> list = graph.get(cur);
        int curH = height[cur];
        if (height[list.get(0)] >= curH){
            return 1;
        }
        if (memo[cur] != 0){
            return memo[cur];
        }

        int res = 1;
        set.add(cur);
        for (Integer next : list) {
            if (curH > height[next] && !set.contains(next)){
                int dfs = dfs(graph, set, memo, next, height);
                memo[next] = dfs;
                res = Math.max(res, dfs + 1);
            }
        }
        set.remove(cur);
        return res;
    }
}
