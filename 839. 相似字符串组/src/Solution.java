class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int strLen = strs[0].length();
        // 将原来的字符串数组转化为二维字符数组便于对比处理
        char[][] strsArr = new char[n][];
        // 1. 初始化并查集及字符数组
        for (int i = 0; i < n; i++) {
            // 转化字符串数组
            strsArr[i] = strs[i].toCharArray();
        }

        UnionForm unionForm = new UnionForm(n);

        // 2. 合并相似字符
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 先确认两个字符串是否属于一个集合，如不是再看是否相似从而进行合并
                if (!unionForm.connected(i, j) &&
                        similar(strsArr[i], strsArr[j], strLen)) {
                    unionForm.union(i, j);
                }
            }
        }

        return unionForm.groupNum();
    }

    // 判断两个字符串是否相似
    private boolean similar(char[] s1, char[] s2, int strLen) {
        int diff = 0;
        /*
         * 因为所有字符串都由相同字符进行不同排列构成，
         * 所以一次两字符的交换只可能造成交换后的字符串和原字符串只有两处不同。
         * 反过来如果两字符串只有两处不同则说明可以通过交换变成同一字符，
         * 若超过两处则无法通过一次交换实现。
         */
        for (int i = 0; i < strLen; i++) {
            // 先前将字符串转化为数组就是为了加速字符比较，避免charAt(i)方法中冗余的rangeCheck
            if (s1[i] != s2[i]) {
                if (++diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private class UnionForm{

        final int[] p;

        UnionForm(int n){
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        // 并查集查询
        int find(int x) {
            while (p[x] != x) {
                p[x] = p[p[x]];
                x = p[x];
            }
            return p[x];
        }

        // 并查集合并
        void union(int x, int y) {
            p[find(y)] = find(x);
        }

        // 判断两节点是否属于同一集合
        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        // 获取组数
        int groupNum(){
            int groupNum = 0;
            for (int i = 0; i < p.length; i++) {
                // 当根就是自己本身时，说明该结点是一个独立集合中所有点的根节点，可以代表一个独立集合
                if (p[i] == i) {
                    groupNum++;
                }
            }
            return groupNum;
        }
    }
}
