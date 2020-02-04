import java.util.ArrayList;

//class Solution {
//    public void moveZeroes(int[] nums) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++){
//            if (nums[i] != 0) {
//                list.add(nums[i]);
//            }
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            nums[i] = list.get(i);
//        }
//
//        for(int i =list.size(); i < nums.length; i++){
//            nums[i] = 0;
//        }
//    }
//}

//class Solution {
//    public void moveZeroes(int[] nums) {
//
//        int k = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] != 0){
//                nums[k] = nums[i];
//                k++;
//            }
//        }
//        for(;k < nums.length ; k++){
//            nums[k] = 0;
//        }
//    }
//}

class Solution {
    public void moveZeroes(int[] nums) {

        int k = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 ){
                if( i != k){
                    temp = nums[k];
                    nums[k++] = nums[i];
                    nums[i] = temp;
                }else {
                    k++;
                }
            }
        }
    }
}































