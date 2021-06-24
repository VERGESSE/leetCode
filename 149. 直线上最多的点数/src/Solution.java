import java.util.HashMap;
import java.util.HashSet;

class Solution {

    public int maxPoints(int[][] points) {
        if(points.length < 3){
            return points.length;
        }
        int i = 0;
        //判断所有点是否都相同的特殊情况
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }

        }
        if (i == points.length - 1) {
            return points.length;
        }
        HashSet<String> set = new HashSet<>();
        int max = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                String key = getK(points[i][0], points[i][1], points[j][0], points[j][1])
                        + "@"
                        + getB(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (set.contains(key)) {
                    continue;
                }
                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }

                }
                if (tempMax > max) {
                    max = tempMax;
                }
                set.add(key);
            }
        }
        return max + 2;
    }

    private double getB(int x1, int y1, int x2, int y2) {
        if (y2 == y1) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (x2 - x1) * (-y1) / (y2 - y1) + x1;
    }

    private double getK(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long)(y2 - y1) * (x - x2) == (long)(y - y2) * (x2 - x1);
    }


    //另一种解法
    public int maxPoints2(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        //遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;//保存经过当前点的直线中，最多的点
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                //求出分子分母
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;

                }
                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}

//fast
class Solution2 {
    public int maxPoints(int[][] points) {
        //暴力点就是,选出两个点，判断剩下的点和这些点在不在一个直线上;
        if (points.length <= 0){
            return 0;
        }
        int maxPoint = 1;
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                int count = 2;
                //判断在这个线上的个数;
                //考虑一个问题1,2,3,4都在一条直线上;
                //2的时候，需要再去考虑1吗？
                //1的时候应该一定考虑过了把;
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int deltaY = y2 - y1;
                int deltaX = x2 - x1;

                for (int k = j + 1; k < points.length; k++){
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if ((y3 - y1) * deltaX == (x3 - x1) * deltaY){
                        count++;
                    }
                }
                if (count > maxPoint){
                    maxPoint = count;
                }
            }
        }
        return maxPoint;
    }
}
