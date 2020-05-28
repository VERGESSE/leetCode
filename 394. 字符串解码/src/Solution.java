import java.util.*;

class Solution {

    // 字符串索引位置指针
    private int ptr = 0;

    public String decodeString(String s) {

        LinkedList<String> stack = new LinkedList<>();

        while (ptr < s.length()){
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)){
                // 获取一个数字并进栈
                stack.addLast(getDigit(s));
            } else if (Character.isLetter(cur) || cur == '['){
                stack.addLast(String.valueOf(cur));
                ptr++;
            } else {
                ptr++;
                LinkedList<String> list = new LinkedList<>();
                String pop = stack.removeLast();
                while (!"[".equals(pop)){
                    list.addFirst(pop);
                    pop = stack.removeLast();
                }

                // 此时栈顶为此字符串应出现的次数
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                String s1 = getString(list);
                while (repTime-- > 0){
                    sb.append(s1);
                }
                // 构造好的字符串重新入栈
                stack.addLast(sb.toString());
            }
        }
        return getString(stack);
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))){
            sb.append(String.valueOf(s.charAt(ptr++)));
        }
        return sb.toString();
    }

    private String getString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}

/*  递归
class Solution {
    String src;
    int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
 */