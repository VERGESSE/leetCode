import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chars = new char[2*n];
        chars[0] = '(';
        generate(n-1,2*n-1,1,chars,res);
        return res;
    }

    private void generate(int ln,int n, int index, char[] chars, List<String> res) {

        if (ln < 0 && n != 0)
            return;
        if (n == 0){
            if (isTrue(chars))
                res.add(String.copyValueOf(chars));
            return;
        }
        chars[index] = '(';
        generate(ln-1,n-1,index+1,chars,res);
        chars[index] = ')';
        generate(ln ,n-1,index+1,chars,res);
    }

    private boolean isTrue(char[] chars){
        int balance = 0;
        for (char c: chars) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}