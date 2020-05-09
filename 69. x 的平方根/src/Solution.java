class Solution {
    public int mySqrt(int x) {

        int mid = x / 2;
        int r = x;
        while(true){
            if((long)mid*mid > x) {
                r = mid;
                mid /= 2;
            } else if((long)(mid+1)*(mid+1) > x){
                return mid;
            } else {
                int tmp = r-mid;
                if(tmp%2 != 0)
                    mid = mid + tmp/2 + 1;
                else
                    mid = mid + tmp/2;
            }
        }
    }
}

/*  二分
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

 */

/*   数学公式推倒
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
 */