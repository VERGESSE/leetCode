class Solution {
    public String makeGood(String s) {

        int len = s.length();
        if(len <= 1) return s;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int p = 0;
        while (i < len){
            char cur = chars[i];
            char pre = chars[p];
            if(pre - 32 == cur || pre + 32 == cur){
                chars[p] = ' ';
                chars[i] = ' ';
                i ++;
                while (p > 0 && chars[--p] == ' ');
                continue;
            }
            p = i;
            i ++;
        }
        for (char c : chars) {
            if (c != ' ')
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("NAanorRoOrROwnTNW"));
    }
}
