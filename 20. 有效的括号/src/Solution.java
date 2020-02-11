import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++){

            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '('){
                stack.push(chars[i]);
            }else {

                switch (chars[i]){
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') return false;
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') return false;
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') return false;
                        break;
                    default: return false;
                }
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

}