class Solution {
    public int strToInt(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int index = 0;
        while(index < len && chars[index] == ' ')
            index++;
        if(len == index)
            return 0;
        boolean negative = false;
        if(chars[index] == '-'){
            negative = true;
            index++;
        }
        else if(chars[index] == '+')
            index++;
        else if(chars[index] < '0' || chars[index] > '9')
            return 0;
        int res = 0;
        while(index < len && chars[index] >= '0' && chars[index] <= '9'){
            int cur = chars[index] - '0';
            if(res > (Integer.MAX_VALUE - cur) / 10)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + cur;
            index++;
        }

        return negative ? -res : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("4193 with words"));
    }
}
