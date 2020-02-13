import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final String[][] lettepMap= {
        {""},
        {""},
        {"a","b","c"},
        {"d","e","f"},
        {"g","h","i"},
        {"j","k","l"},
        {"m","n","o"},
        {"p","q","r","s"},
        {"t","u","v"},
        {"w","x","y","z"},
    } ;

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        res.clear();

        if (digits.length() == 0) {
            return res;
        }

        findCombination(digits,0,"");

        return res;
    }

    private void findCombination(String digits,int index,String s){

        if (digits.length() == index) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String[] strings = lettepMap[c - '0'];
        for (String string : strings) {
            findCombination(digits,index + 1, s + string);
        }

        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
    }
}