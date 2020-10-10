class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int count = 0, num = -1;
        for (int c : nums) {
            //投票清零，统计新牛郎
            if (count == 0) {
                num = c;
                count++;
            }else {
                //“我”得一票
                if (c == num) count++;
                    //我以外得一票（我减一票）
                else count--;
            }
        }
        //超过半数肯定会剩下来一个 count > 0
        //没剩下来count == 0 说明我跟我以外的一样没个第一
        return count == 0 ? -1 : num;
    }
}
