class Solution {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int[] pos = new int[row.length];

        for (int i = 0; i < pos.length; i++) {
            pos[row[i]] = i;  //每个人对应的位置
        }

        for (int i = 0; i < pos.length; i += 2) {
            int pairPerson = row[i] ^ 0x1;  //i号位置的情侣应该是谁
            if (row[i + 1] == pairPerson) {
                continue;  //右边是情侣，直接继续处理下一个。
            }

            int nextPerson = row[i + 1]; //右边不是情侣，得到右边的人是谁
            int changePos = pos[pairPerson]; //得到情侣的位置在哪

            row[changePos] = nextPerson; //交换后，情侣位置坐上了右边的人nextPerson
            pos[nextPerson] = changePos; //交换后，右边人nextPerson的位置发生了改变，记录下来。
            ans++;
        }

        return ans;
    }
}

/* 广度优先搜索
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int tot = n / 2;

        List<Integer>[] graph = new List[tot];
        for (int i = 0; i < tot; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i += 2) {
            int l = row[i] / 2;
            int r = row[i + 1] / 2;
            if (l != r) {
                graph[l].add(r);
                graph[r].add(l);
            }
        }
        boolean[] visited = new boolean[tot];
        int ret = 0;
        for (int i = 0; i < tot; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<Integer>();
                visited[i] = true;
                queue.offer(i);
                int cnt = 0;

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    cnt += 1;

                    for (int y : graph[x]) {
                        if (!visited[y]) {
                            visited[y] = true;
                            queue.offer(y);
                        }
                    }
                }
                ret += cnt - 1;
            }
        }
        return ret;
    }
}
 */

/* 并查集
public class Solution {

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();
    }

    private class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count--;
        }
    }
}
 */
