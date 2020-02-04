
import java.util.ArrayList;
import java.util.List;

//快速排序
class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        quickSort(nums,0,nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    private void quickSort(int[] nums,int low,int high){

        if(low > high)
            return;

        int temp,t;
        int p1 = low;
        int p2 = high;
        temp = nums[low];
        while(p1 < p2){

            while ( temp < nums[p2] && p1 < p2)
                p2--;
            while ( temp >= nums[p1] && p1 < p2)
                p1++;
            if( p1 < p2){
                t = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = t;
            }
        }
        //基准和p1交换
        nums[low] = nums[p1];
        nums[p1] = temp;

        //递归调用
        quickSort(nums,low,p1-1);
        quickSort(nums,p1+1,high);
    }
}

//堆排序
class Solution2 {
    // 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
    private void heapSort(int[] arr) {
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        //Heapify
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }
    /**
     * @param n 参与排序的数组的长度（最后一个元素的下一个位置）
     * @param k 当前的元素
     */
    private void shiftDown(int[] arr, int n, int k) {
        int e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j++;
            }
            //当前节点大于子节点
            if (e >= arr[j]) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }
    // 交换堆中索引为i和j的两个元素
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }
}

//5ms
class Solution3{
    public List<Integer> sortArray(int[] nums) {
        int max = nums[0]; // 最大值
        int min = nums[0]; // 最小值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        // 用于计数
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // 用于存放排好序的数据
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[--counts[nums[i] - min]] = nums[i];
        }
        List<Integer> output2 = new ArrayList<>();
        for (int i = 0; i < output.length; i++) {
            output2.add(output[i]);
        }
        return output2;
    }
}














