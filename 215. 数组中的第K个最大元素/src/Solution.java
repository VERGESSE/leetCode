class Solution {
    public int findKthLargest(int[] nums, int k) {

        quickSort(nums,0,nums.length - 1);
        return nums[nums.length - k];
    }

    //快速排序
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