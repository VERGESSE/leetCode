import java.util.Arrays;

class Solution {
    public int[] subSort(int[] array) {

        if (array.length <= 1){
            return new int[]{-1, -1};
        }
        int left = 0, right = array.length - 1;
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, copy.length);
        Arrays.sort(copy);

        while (left < right){
            if (array[left] != copy[left]){
                break;
            }
            ++left;
        }
        if (left == right){
            return new int[]{-1, -1};
        }
        while (right > 0){
            if (array[right] != copy[right]){
                break;
            }
            --right;
        }
        return new int[]{left, right};
    }
}

/*
class Solution {
    public int[] subSort(int[] arr) {
        if (arr == null || arr.length < 2) return new int[] {-1, -1};
        int len = arr.length;

        int i = 0; // find the max from left.
        while (i < len - 1 && arr[i] <= arr[i+1]){
            ++i;
        }

        int j = len - 1; // find the min from right
        while (j > 0 && arr[j] >= arr[j-1]) {
            j--;
        }

        if (j < i) return new int[] {-1, -1};

        int m = i;
        int n = j;

        // ajust the m and n
        for (int k = i; k <= j; ++k) {
            while (m > 0 && arr[k] < arr[m - 1]) {
                m--;
            }

            while (n < len - 1 && arr[k] > arr[n + 1]) {
                n++;
            }
        }
        return new int[] {m, n};
    }
}
 */
