class Solution {
    public int maxAliveYear(int[] birth, int[] death) {

        // 统计每年的人口净增长
        int[] inc = new int[102];
        for(int i = 0; i < birth.length; i++){
            // 当年出生
            inc[birth[i] - 1900] ++;
            // 当年死亡，算在明年
            inc[death[i] - 1899] --;
        }
        int all = 0;
        int max = 0;
        int year = 0;
        for(int i = 0; i < inc.length; i++){
            all += inc[i];
            if(all > max){
                max = all;
                year = i + 1900;
            }
        }
        return year;
    }
}
