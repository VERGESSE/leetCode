import java.util.Stack;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        // 当前的操作数
        int operand = 0;
        // 存储结果
        int result = 0;
        // 标志，1表示正，-1表示负
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 是数字，加上上一个输入一起解析
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+') {
                // 计算+号前操作数的结果
                result += sign * operand;
                // 下一个操作数为正
                sign = 1;
                // 操作结束，当前操作数清零
                operand = 0;

            } else if (ch == '-') {
                result += sign * operand;
                // 下一个操作数为负
                sign = -1;
                // 操作结束，当前操作数清零
                operand = 0;
            } else if (ch == '(') {
                // 把之前的结果和要对括号做的操作压入栈
                // 先计算括号中的，遇到右括号把内外结果相加
                stack.push(result);
                stack.push(sign);
                // 重置当前括号内的操作符，做一次新的计算
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                // 计算出当前括号内的最终结果
                result += sign * operand;
                // 把当前括号运算结果带上之前的操作符与之前的结果进行运算
                result *= stack.pop();
                // 把括号前的计算结果与括号内的进行计算
                result += stack.pop();
                // 当前操作数清零
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
