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
    int result = 0;

    public  int maxPoints(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return len;
        }

        for (int i = 0; i < len - 1; i++) {
            int x = points[i + 1][0] - points[i][0];
            int y = points[i + 1][1] - points[i][1];
            if (x != 0 || y != 0) {
                maxPointsHelper(points, x, y, i);
            }
        }
        //怎么解决的重复点问题：
        //如果数组中所有点都相等，返回数组长度
        //只要有不相同的两个点，就能进入下面的方法，就能统计到所有的点
        return result == 0 ? len : result;
    }

    private  void maxPointsHelper(int[][] points, long a, long b, int base) {
        int path = 2;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            if (i != base && i != base + 1) {
                if ((points[i][1] - points[base][1]) * a == (points[i][0] - points[base][0]) * b)
                {
                    path++;
                }
            }
        }
        result = Math.max(result, path);
    }
}