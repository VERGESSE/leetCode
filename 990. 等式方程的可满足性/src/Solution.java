class Solution {
    public boolean equationsPossible(String[] equations) {

        UnionForm equal = new UnionForm(26);

        for (String equation : equations) {
            // ==
            if (equation.charAt(1) == '='){
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                equal.union(a, b);
            }
        }
        for (String equation : equations) {
            // !=
            if (equation.charAt(1) == '!'){
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                if (a == b || equal.connected(a, b)){
                    return false;
                }
            }
        }

        return true;
    }

    static class UnionForm {

        final int[] parent;

        UnionForm(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int n){
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }

        boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.equationsPossible(new String[]{"b!=c","a==b","e!=d","b!=f","a!=b"})
        );
    }
}
