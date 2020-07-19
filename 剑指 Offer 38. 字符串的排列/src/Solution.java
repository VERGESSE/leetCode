import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    List<String> res = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
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
