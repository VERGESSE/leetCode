import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Integer p1,p2;
        for (String s : tokens) {

            switch (s){
                case "+":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    stack.push(p2 + p1); break;
                case "-":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    stack.push(p2 - p1); break;
                case "*":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    stack.push(p2 * p1); break;
                case "/":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    stack.push(p2 / p1); break;
                default: stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] strings = {"4","13","5","/","+"};
        Solution solution = new Solution();
        int i = solution.evalRPN(strings);
        System.out.println(i);
    }
}

/*
class Solution {
	//纯数组模拟栈实现(推荐)   3 ms	36 MB
	public static int evalRPN(String[] tokens) {
		int[] numStack = new int[tokens.length / 2 + 1];
		int index = 0;
		for (String s : tokens) {
			switch (s) {
			case "+":
				numStack[index - 2] += numStack[--index];
				break;
			case "-":
				numStack[index - 2] -= numStack[--index];
				break;
			case "*":
				numStack[index - 2] *= numStack[--index];
				break;
			case "/":
				numStack[index - 2] /= numStack[--index];
				break;
			default:
				// numStack[index++] = Integer.valueOf(s);
				//valueOf改为parseInt，减少自动拆箱装箱操作
				numStack[index++] = Integer.parseInt(s);
				break;
			}
		}
		return numStack[0];
	}
}
 */