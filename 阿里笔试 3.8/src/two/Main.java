package two;

import java.util.*;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static final int mod = 1000000007;

    public static void main(String[] args) {
        Main main = new Main();
        int T = in.nextInt();
        while (T-- > 0){
            int m = in.nextInt();
            int n = in.nextInt();
            int p = in.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            for(int i = 0; i < m; i++){
                a[i] = in.nextInt();
            }
            for(int i = 0; i < m; i++){
                b[i] = in.nextInt();
            }
            System.out.println(main.fun(n, p, a, b));
        }
    }

    public int fun(int n, int p, int[] people, int[] price){
        HashMap<Integer, Integer> map = new HashMap<>();
        return dfs(map, people, price, 0, n, p);
    }

    private int dfs(Map<Integer, Integer> map, int[] people, int[] price, int index, int maxPeople, int minPrice){
        if (maxPeople <= 0 && minPrice > 0){
            return 0;
        }
        if (minPrice == 0){
            map.put(index, 1);
            return 1;
        }
        if (map.containsKey(index)){
            return map.get(index);
        }
        int res = 0;
        res += dfs(map, people, price, index + 1,
                maxPeople - people[index], minPrice - price[index]) % mod;
        res += dfs(map, people, price, index + 1, maxPeople, minPrice) % mod;
        map.put(index, res % mod);
        return res % mod;
    }
}
