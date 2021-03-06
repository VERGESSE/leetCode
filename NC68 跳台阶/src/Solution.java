public class Solution {
    public int jumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        int one = 2;
        int two = 1;

        for(int i = 3; i <= target; i++){
            if(i % 2 == 0){
                one += two;
            } else {
                two += one;
            }
        }

        return target % 2 == 0 ? one : two;
    }
}
