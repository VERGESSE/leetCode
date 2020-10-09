class Solution {
    public void wiggleSort(int[] nums) {

        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 1){
                if(nums[i] > nums[i - 1])
                    swap(nums, i, i - 1);
            } else {
                if(nums[i] < nums[i - 1])
                    swap(nums, i, i -1);
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
