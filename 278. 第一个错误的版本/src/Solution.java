/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int l = 1, r = n;
        int mid = l + (r - l) / 2;
        while(!(isBadVersion(mid) && !isBadVersion(mid - 1))){
            if(isBadVersion(mid)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }
        return mid;
    }
}

/* fast
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n==0)return 0;
        int left =0;
        int right = n;
        int tmp = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                tmp = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return tmp;
    }
}
 */
