class Solution {
    public String reverseWords(String s) {
        if(s == null || s.trim().length() == 0)
            return "";
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1; i >= 0; i--){
            if (!words[i].equals("")) {
                sb.append(words[i].trim());
                sb.append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(" "));
    }
}
