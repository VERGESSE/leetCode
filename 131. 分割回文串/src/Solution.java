import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ret = new ArrayList<>();

        if(s.length() == 0){
            return ret;
        }

        getPartition(ret, s, 0, new ArrayList<>(s.length()));

        return ret;
    }

    private void getPartition(List<List<String>> ret, String s,
                              int index, List<String> res){
        if(index == s.length()){
            ret.add(new ArrayList<>(res));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(!isPalindrome(s, index, i)){
                continue;
            }
            res.add(s.substring(index, i + 1));
            getPartition(ret, s, i + 1, res);
            res.remove(res.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end){

        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
