class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int l = 0,r = numbers.length - 1;
        while (l < r){

            if(numbers[l] + numbers[r] == target){
                int[] res = {l + 1,r + 1};
                return res;
            }else if(numbers[l] + numbers[r] >= target) {
                r--;
            } else {
                l++;
            }
        }
        throw new RuntimeException();
    }
}