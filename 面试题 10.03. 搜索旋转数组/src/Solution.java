class Solution {
    public int search(int[] arr, int target) {
        if (arr.length == 0) return - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 特殊情况
            if (arr[left] == target && (left - 1 < 0 || arr[left-1] != target))
                return left;
            if (arr[mid] == target && (mid-1 < 0 || arr[mid-1] != target))
                return mid;

            if (arr[mid] < arr[left]) { // 说明中间位置是旋转后的位置
                // 说明在左边
                if (target > arr[left] || target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (arr[mid] > arr[left]) {
                if (target > arr[mid] || target < arr[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
                left++;
        }
        return -1;
    }
}
