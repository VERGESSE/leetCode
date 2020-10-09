class Solution {
    public int[] smallestK(int[] arr, int k) {

        if (arr.length < 1 || k == 0) return new int[0];
        if (arr.length == k) return arr;
        int[] res = new int[k];
        int end = arr.length - 1;
        int start = 0;
        while(true){
            int pos = quickSort(arr, start, end);
            if(pos == k){
                System.arraycopy(arr, 0, res, 0, k);
                break;
            } else if(pos > k){
                end = pos - 1;
            } else {
                start = pos;
            }
        }
        return res;
    }

    private int quickSort(int[] arr, int start, int end){
        int pos = arr[end];
        int l = start, r = end;
        while (l < r){
            while(arr[l] <= pos && l < r){
                l++;
            }
            while(arr[r] > pos && l < r){
                r--;
            }
            swap(arr, l, r);
        }
        return l;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
    }
}

/*
class Solution {
    public int[] smallestK(int[] arr, int k) {

        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
 */
