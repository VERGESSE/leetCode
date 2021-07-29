import java.util.*;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int h = height(label);
        List<Integer> res = new ArrayList<>(h);
        res.add(label);
        if (label == 1){
            return res;
        }
        int pre = pre(label, h);
        while (pre != 1){
            res.add(pre);
            h--;
            pre = pre(pre, h);
        }
        res.add(pre);
        Collections.reverse(res);
        return res;
    }

    public int pre(int label, int h) {
        if (h % 2 == 0){
            int max = (int) Math.pow(2, h);
            int min = (int) Math.pow(2, h - 2);
            int dev = max - 1 - label;
            return min + dev / 2;
        } else {
            int min = (int) Math.pow(2, h - 1);
            int dev = label - min;
            return min - 1 - dev / 2;
        }
    }

    private int height(int label){
        int h = 1;
        while(label / 2 != 0){
            label /= 2;
            h++;
        }
        return h;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pathInZigZagTree(14));
    }
}
