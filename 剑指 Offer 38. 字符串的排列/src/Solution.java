import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, res, 0);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] chars, List<String> res, int index){
        if(index == chars.length - 1){
            res.add(new String(chars));
            return;
        }

        // 去重
        Set<Character> set = new HashSet<>();
        for(int i = index; i < chars.length; i++){
            if(set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(chars, i, index);
            dfs(chars, res, index + 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int a, int b){
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
    }
}

/*
class Solution {

    List<String> res = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[]);
    }

    // 确定 x 位置的元素
    private void dfs(int x){
        if(x == chars.length - 1)
            res.add(String.valueOf(chars));

        // 去重
        Set<Character> set = new HashSet<>();
        for(int i = x; i < chars.length; i++){
            // 如果x位置曾有过chars[i]元素，则不再计算
            if(set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            // 确定x位置元素
            swap(x, i);
            // 确定下一个位置元素
            dfs(x + 1);
            // 还原现场
            swap(i, x);
        }
    }

    // 交换两位置的元素
    private void swap(int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
 */
