import java.util.*;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        int n = adjacentPairs.length + 1;
        Map<Integer, Node> map = new HashMap<>(n);
        for (int[] pair : adjacentPairs) {
            Node n1 = map.getOrDefault(pair[0], new Node(pair[0]));
            Node n2 = map.getOrDefault(pair[1], new Node(pair[1]));
            if (n1.n1 == null){
                map.put(pair[0], n1);
                n1.n1 = n2;
            } else {
                n1.n2 = n2;
            }
            if (n2.n1 == null){
                map.put(pair[1], n2);
                n2.n1 = n1;
            } else {
                n2.n2 = n1;
            }
        }

        Node cur = new Node(0);
        for (Node node : map.values()) {
            if (node.n2 == null){
                cur = node;
                break;
            }
        }
        int[] res = new int[n];
        res[0] = cur.value;
        Node pre = cur;
        cur = cur.n1;
        for(int i = 1; i < n; i++){
            res[i] = cur.value;
            if (cur.n1 == pre){
                pre = cur;
                cur = cur.n2;
            } else {
                pre = cur;
                cur = cur.n1;
            }
        }

        return res;
    }

    static class Node {
        int value;
        Node n1;
        Node n2;
        Node(int value){
            this.value = value;
        }
    }
}

/*
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for(int[] pair : adjacentPairs){
            map.putIfAbsent(pair[0], new ArrayList<>(2));
            map.putIfAbsent(pair[1], new ArrayList<>(2));
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        int[] res = new int[n];
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            if(entry.getValue().size() == 1){
                res[0] = entry.getKey();
                break;
            }
        }

        res[1] = map.get(res[0]).get(0);
        for(int i = 2; i < n; i++){
            List<Integer> list = map.get(res[i - 1]);
            res[i] = list.get(0) == res[i - 2] ? list.get(1) : list.get(0);
        }

        return res;
    }
}
 */
