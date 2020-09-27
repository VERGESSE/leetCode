class Solution {
    public double[] cutSquares(int[] square1, int[] square2) {
        double centerX1 = square1[0] + square1[2]/2.0;
        double centerY1 = square1[1] + square1[2]/2.0;
        double centerX2 = square2[0] + square2[2]/2.0;
        double centerY2 = square2[1] + square2[2]/2.0;
        //parallel to the Y-axis
        if(centerX1 == centerX2){
            double maxY = Math.max(square1[1]+square1[2],square2[1]+square2[2]);
            double minY = Math.min(square1[1],square2[1]);
            return new double[]{centerX1,minY,centerX1,maxY};
        }
        double k = (centerY2-centerY1)/(centerX2-centerX1);
        double b = centerY1-k*centerX1;
        double x1, y1, x2, y2;
        if(Math.abs(k)<1) {
            x1 = Math.min(square1[0],square2[0]);
            y1 = k*x1+b;
            x2 = Math.max(square1[0]+square1[2],square2[0]+square2[2]);
            y2 = k*x2+b;
        }
        else {
            y1 = Math.min(square1[1],square2[1]);
            x1 = (y1-b)/k;
            y2 = Math.max(square1[1]+square1[2],square2[1]+square2[2]);
            x2 = (y2-b)/k;
            if(x1>x2){
                double temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
        }
        return new double[]{x1, y1, x2, y2};
    }

    // 求两条线的交点
    // ax - by + c = 0
    private double[] intersect(double[] l1, double[] l2){
        double a1 = (l1[1] - l1[3]) / (l1[0] - l1[2]),
                b1 = l1[1] - a1 * l1[0],
                a2 = (l2[1] - l2[3]) / (l2[0] - l2[2]),
                b2 = l2[1] - a2 * l2[0];
        double x = (b2 - b1) / (a1 - a2);
        double y = a1 * x + b1;
        return new double[]{x, y};
    }

    // 比较两个点的大小，靠右的点为大
    private boolean compare(double[] p1, double[] p2){
        if (p1[0] < p2[0])
            return true;
        else return p1[0] == p2[0] && p2[1] >= p1[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] intersect = solution.intersect(
                new double[]{1,2,-1,0},
                new double[]{-1,2,1,0}
        );
        System.out.println(intersect[0] + ", " + intersect[1]);
    }
}
