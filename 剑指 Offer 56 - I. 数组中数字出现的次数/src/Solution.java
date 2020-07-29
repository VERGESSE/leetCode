class Solution {
    public int[] singleNumbers(int[] nums) {

        int ret = 0;
        int a = 0,b = 0;

        for (int num : nums) {
            ret ^= num;
        }

        int i = 1;
        while ((ret & i) == 0)
            i <<= 1;

        for (int num : nums) {

            if ((num & i) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[]{a,b};
    }
}
