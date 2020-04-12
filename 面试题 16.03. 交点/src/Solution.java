class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double x = 0, y = 0;
        double  x1 = start1[0], y1 = start1[1],
                x2 = end1[0],   y2 = end1[1],
                x3 = start2[0], y3 = start2[1],
                x4 = end2[0],   y4 = end2[1];
        // 第一条直线平行于 X 轴
        if (x1 - x2 == 0) {
            // 第二条直线也平行于 X 轴
            if (x3 - x4 == 0) {
                // 两条线段有重叠：同一直线，且一个端点在另一条线段之内
                if (x1 == x3 && Math.max(y1, y2) >= Math.min(y3, y4) && Math.min(y1, y2) <= Math.max(y3, y4))
                    return new double[] {x1, Math.max(Math.min(y1, y2), Math.min(y3, y4))};
                // 另一条直线不平行于此直线
            } else {
                x = x1;
                y = (x - x4) * (y3 - y4) / (x3 - x4) + y4;
            }
            // 第一条直线平行于 Y 轴
        } else if (y1 - y2 == 0) {
            // 四个端点的对称点
            int[] newStart1     = new int[] {start1[1], start1[0]},
                    newEnd1     = new int[] {end1[1], end1[0]},
                    newStart2   = new int[] {start2[1], start2[0]},
                    newEnd2     = new int[] {end2[1], end2[0]};
            double[] tmp = intersection(newStart1, newEnd1, newStart2, newEnd2);
            return new double[] {tmp[1], tmp[0]};
            // 第二条直线平行于 X 轴
        } else if (x3 - x4 == 0)
            return intersection(start2, end2, start1, end1);
            // 第二条直线平行于 Y 轴
        else if (y3 - y4 == 0)
            return intersection(start2, end2, start1, end1);
            // 两条直线平行，但不平行于 X 轴或 Y 轴
        else if ((y1 - y2) / (x1 - x2) == (y3 - y4) / (x3 - x4) &&
                x2 * (y2 - y1) / (x1 - x2) + y2 == x4 * (y4 - y3) / (x3 - x4) + y4) {
            x = Math.max(Math.min(x1, x2), Math.min(x3, x4));
            y = Math.max(Math.min(y1, y2), Math.min(y3, y4));
            // 普通情况
        } else {
            x = ((y4 - y2) * (x1 - x2) * (x3 - x4) + x2 * (y1 - y2) * (x3 - x4) - x4 * (y3 - y4) * (x1 - x2))
                    / ((y1 - y2) * (x3 - x4) - (y3 - y4) * (x1 - x2));
            y = (x - x2) * (y1 - y2) / (x1 - x2) + y2;
        }
        // 交点可能存在的左、右、下、上边界
        double  left    = Math.max(Math.min(x1, x2), Math.min(x3, x4)),
                right   = Math.min(Math.max(x1, x2), Math.max(x3, x4)),
                bottom  = Math.max(Math.min(y1, y2), Math.min(y3, y4)),
                top     = Math.min(Math.max(y1, y2), Math.max(y3, y4));
        if (left <= x && x <= right && bottom <= y && y <= top)
            return new double[] {x, y};
        else return new double[] {};
    }
}
