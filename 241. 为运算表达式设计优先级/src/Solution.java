import java.util.*;

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        //递归结束条件，只剩下数字时，返回只包含该数的list即可
        if (expression.length() < 3) {
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        for (int i = 1; i < expression.length() - 1; i++) {
            char c = expression.charAt(i);
            //如果第i位是符号位
            if (c < 48 || c > 57) {
                //分治思想，根据符号位把字符串划分为左右两部分，并且分别递归获取左右list
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                //分别遍历左右list，并根据当前运算符对里面的数进行运算
                for (Integer a : left) {
                    for (Integer b : right) {
                        //运算后的结果添加到新的list中
                        ans.add(operation(a, b, c));
                    }
                }
            }
        }
        return ans;
    }

    //运算方法
    public int operation(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
