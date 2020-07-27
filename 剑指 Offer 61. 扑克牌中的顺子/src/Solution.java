import java.util.Arrays;

class Solution {
    public boolean isStraight(int[] nums) {

        int pre = 0;
        int zeroNum = 0;
        Arrays.sort(nums);
        for(int cur : nums){
            if(cur != 0){
                pre = cur - 1;
                break;
            }
        }

        for(int cur : nums){
            if(cur == 0){
                zeroNum ++;
                continue;
            }
            if (pre == cur)
                return false;
            while(pre + 1 != cur){
                zeroNum --;
                pre ++;
            }
            if(zeroNum < 0)
                return false;
            pre = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        System.out.println(solution
            .isStraight(new int[]{0,0,2,2,5}));
        System.out.println(System.currentTimeMillis() - l);
    }
}
