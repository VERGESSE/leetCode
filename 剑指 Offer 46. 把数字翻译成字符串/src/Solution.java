class Solution {
    public int translateNum(int num) {
        if(num / 10 ==0)
            return 1;
        int res = 0;
        res += translateNum(num / 10);
        int mod = num % 100;
        if(mod > 9 && mod < 26){
            res += translateNum(num / 100);
        }
        return res;
    }
}
