class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1)
            return s;

        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            sbs[i] = new StringBuilder();

        for(int i = 0; i < len;){
            for(int j = 0; j < numRows && i < len; j++){
                sbs[j].append(s.charAt(i++));
            }
            for(int j = numRows - 2; j > 0 && i < len; j--){
                sbs[j].append(s.charAt(i++));
            }
        }
        for(int i = 1; i < numRows; i++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.convert(
                        "LEETCODEISHIRING",
                        4
                )
        );
    }
}

/*
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int l = s.length();
        char[] ans = new char[l];
        int m = 2 * numRows - 2;
        int t = 0;
        for (int i = 0; i < l; i += m) {
            ans[t] = s.charAt(i);
            t++;
        }
        for (int k = 1; k < numRows - 1; k++) {
            for (int i = k; i < l; i += m) {
                ans[t] = s.charAt(i);
                t++;
                if (i + m - 2 * k < l) {
                    ans[t] = s.charAt(i + m - 2 * k);
                    t++;
                }
            }
        }
        for (int i = numRows - 1; i < l; i += m) {
            ans[t] = s.charAt(i);
            t++;
        }
        return String.valueOf(ans);

    }
}
 */
