import java.util.*;

class Solution {

    // 定义可执行运算符
    private static final String OPERATORS = "+-*/()";

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        // 获取输入
        String expression = in.next();
        int result = solution.calculate(expression);
        System.out.println(result);
    }

    // 对输入字符串S进行计算
    private int calculate(String s) {
        // 去除空格
        String expression = s.replaceAll(" ", "");
        // 获取表达式的所有操作符集合
        List<String> infix = expressionToList(expression);
        // 中缀转后缀
        List<String> suffix = infixToSuffix(infix);
        // 存储中间结果
        Stack<String> stack = new Stack<>();
        // 逆波兰计算器
        for (String tmp : suffix) {
            if (isOperator(tmp)) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                long result = cal(num1, tmp, num2);
                stack.push(String.valueOf(result));
            } else {
                // 数字直接入栈
                stack.push(tmp);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * num1 和 num2 进行 operator 计算
     */
    private long cal(String num1, String operator, String num2) {
        long result = 0L;
        long a = Long.parseLong(num1);
        long b = Long.parseLong(num2);
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        return result;
    }

    /**
     * 中缀转后缀
     */
    private List<String> infixToSuffix(List<String> infix) {
        List<String> suffix = new ArrayList<>();
        // 只用于保存操作符
        Stack<String> stack1 = new Stack<>();
        // 用于保存中间结果
        Stack<String> stack2 = new Stack<>();
        for (String tmp : infix) {
            // 操作符要根据情况来入栈 1
            if (isOperator(tmp)) {
                if (stack1.isEmpty() || "(".equals(tmp)) {
                    // 如果 stack1 是空的，或者 tmp 是左括号，直接入栈
                    stack1.push(tmp);
                }
                // stack1 不是空的，且 tmp 不是左括号
                else {
                    if (")".equals(tmp)) {
                        // tmp 是右括号，则把 stack1 遇到左括号之前，全部倒入 stack2
                        while (!"(".equals(stack1.peek())) {
                            stack2.push(stack1.pop());
                        }
                        // 丢掉左括号
                        stack1.pop();
                    } else {
                        // tmp 是 +-*/ 其中之一
                        while (!stack1.isEmpty() && priority(stack1.peek()) >= priority(tmp)) {
                            // 在 tmp 能够碾压 stack1 的栈顶操作符之前，把 stack1 的栈顶操作符倒入 stack 2 中
                            stack2.push(stack1.pop());
                        }
                        // 离开 while 时，要么 stack1 已经倒空了，要么就是现在 tmp 可以压住 stack.peek() 了
                        stack1.push(tmp);
                    }
                }
            } else {
                // 操作数直接入栈 2
                stack2.push(tmp);
            }
        }

        // stack1 剩余操作符全部倒入 stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // stack2 的逆序才是结果，所以要再倒一次
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // 现在 stack1 的元素倒出来的顺序就是后缀表达式
        while (!stack1.isEmpty()) {
            suffix.add(stack1.pop());
        }

        return suffix;
    }

    /**
     * 字符串转为中缀 List
     */
    private List<String> expressionToList(String expression) {
        List<String> list = new ArrayList<>();
        int len = expression.length();
        StringBuilder keepNum = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (isNum(c)) {
                if (i != len - 1 && isNum(expression.charAt(i + 1))) {
                    // 如果下一个字符也是数字
                    keepNum.append(c);
                } else {
                    // 当前是最后一个字符，或者下一个开始不是数字
                    keepNum.append(c);
                    list.add(keepNum.toString());
                    keepNum = new StringBuilder();
                }
            } else {
                list.add(c + "");
            }
        }
        return list;
    }

    /**
     * 判断字符 c 是不是数字
     */
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 判断字符串 str 是不是操作符
     */
    private boolean isOperator(String str) {
        return OPERATORS.contains(str);
    }

    /**
     * 返回操作符的优先级，+- 为 0，* / 为 1
     */
    private int priority(String operator) {
        if ("+".equals(operator) || "-".equals(operator)) {
            return 0;
        } else if ("*".equals(operator) || "/".equals(operator)) {
            return 1;
        } else {
            return -1;
        }
    }
}
