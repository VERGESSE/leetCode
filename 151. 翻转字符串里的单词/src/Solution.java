class Solution {
    public String reverseWords(String s) {

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--){
            if (!strs[i].equals("")) {
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        if (sb.length() > 0)
            sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(""));
    }
}

/*使用java原生API
class Solution {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
 */

/*  trim()除去开头和末尾的空白字符
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }

        return sb.toString();
    }
}
 */