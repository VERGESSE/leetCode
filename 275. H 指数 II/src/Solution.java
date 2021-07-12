class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;
        int l = 0, r = n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int h = n - mid;
            if (citations[mid] < h){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return n - l;
    }
}
