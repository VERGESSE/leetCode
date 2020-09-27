import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] permutation(String S) {
        if (S == null || S.length() == 0)
            return new String[]{};
        int len = S.length();
        int n = len;
        for(int i = 1; i < len; i++){
            n *= i;
        }
        List<String> res = new ArrayList<>(n);
        permutation(S.toCharArray(), 0, len, res);
        return res.toArray(new String[0]);
    }

    private void permutation(char[] chars, int start, int end, List<String> res) {
        if (start == end){
            res.add(new String(chars));
        }
        for(int i = start; i < end; i++){
            swap(chars, start, i);
            permutation(chars, start + 1, end, res);
            swap(chars, start, i);
        }
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/* 33ms  基于字符串实现
class Solution {
    public String[] permutation(String S) {
        List<String> permutation = permutation2(S, new HashMap<>());
        return permutation.toArray(new String[0]);
    }

    private List<String> permutation2(String S, HashMap<String, List<String>> memo) {
        if (S.length() == 1){
            return List.of(S);
        }
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            char cur = S.charAt(i);
            String next = S.substring(0, i) + S.substring(i+1);
            // 剪枝
            List<String> suffixList = memo.get(next);
            if (suffixList == null){
                suffixList = permutation2(next, memo);
                memo.put(next, suffixList);
            }
            for(String suffix : suffixList){
                ret.add(cur + suffix);
            }
        }
        return ret;
    }
}
 */
