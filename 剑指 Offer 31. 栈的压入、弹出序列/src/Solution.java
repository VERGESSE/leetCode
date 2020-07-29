import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if(pushed.length == 0 && popped.length == 0)
            return true;
        // 模拟栈的压入
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed){
            stack.push(num);
            // 如果当前栈顶元素和当前出栈序列元素相等，则出栈
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
