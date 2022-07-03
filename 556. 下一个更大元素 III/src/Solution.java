import java.util.Arrays;

class Solution {
    public int nextGreaterElement(int n) {

        int[] intArr = int2intArr(n);
        int res = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = intArr.length - 1; i > 0; i--){
            for (int j = i - 1; j >= 0; j--){
                if (intArr[j] < intArr[i]){
                    swap(intArr, i, j);
                    Arrays.sort(intArr, j + 1, intArr.length);
                    int cur = intArr2int(intArr);
                    if (cur > 0 && cur > n){
                        flag = true;
                        res = Math.min(res, cur);
                    }
                    intArr = int2intArr(n);
                    break;
                }
            }
        }

        return flag ? res : -1;
    }

    private int[] int2intArr(int n){
        int[] inrArr = new int[11];
        int index = 10;
        while (n != 0){
            inrArr[index--] = n % 10;
            n /= 10;
        }
        int[] res = new int[10 - index];
        System.arraycopy(inrArr, index + 1, res, 0, res.length);
        return res;
    }

    private int intArr2int(int[] intArr){
        int res = 0;
        for (int i = 0; i < intArr.length; i++){
            res = res * 10 + intArr[i];
        }
        return res;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(2147483476));
    }
}

/* lc题解
class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
 */
