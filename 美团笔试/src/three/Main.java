package three;

import java.util.*;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int K = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i ++){
            array[i] = in.nextInt();
        }
        HashMap<Integer, Integer> rate = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int i = 0; i < K; i++){
            Integer curRate = rate.getOrDefault(array[i], 0);
            TreeSet<Integer> set = map.getOrDefault(curRate, new TreeSet<>());
            if (set.isEmpty()){
                map.remove(curRate);
            } else {
                map.put(curRate, set);
            }
            map.put(curRate, set);
            rate.put(array[i], curRate + 1);
            set = map.getOrDefault(curRate + 1, new TreeSet<>());
            set.add(array[i]);
            map.put(curRate + 1, set);
        }
        System.out.println(map.lastEntry().getValue().first());
        for(int i = 1; i < n - K + 1; i++){
            int j = i + K - 1;

            Integer curRate = rate.get(array[i - 1]);
            TreeSet<Integer> set = map.get(curRate);
            set.remove(array[i - 1]);
            if (set.isEmpty()){
                map.remove(curRate);
            } else {
                map.put(curRate, set);
            }
            rate.put(array[i - 1], curRate - 1);
            set = map.getOrDefault(curRate - 1, new TreeSet<>());
            set.add(array[i - 1]);
            map.put(curRate - 1, set);

            curRate = rate.getOrDefault(array[j], 0);
            set = map.getOrDefault(curRate, new TreeSet<>());
            if (set.isEmpty()){
                map.remove(curRate);
            } else {
                map.put(curRate, set);
            }
            map.put(curRate, set);
            rate.put(array[j], curRate + 1);
            set = map.getOrDefault(curRate + 1, new TreeSet<>());
            set.add(array[j]);
            map.put(curRate + 1, set);

            System.out.println(map.lastEntry().getValue().first());
        }
    }
}
