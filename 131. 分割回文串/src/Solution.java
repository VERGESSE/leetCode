import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> partition(String s) {
        ret.clear();

        if (s.length() == 0)
            return ret;

        getPartition(s,0,new ArrayList<>());

        return ret;
    }

    private void getPartition(String s,int index,List<String> res) {

//        if (String.join("", res).length() == s.length()){
        if (index == s.length()){
//            System.out.println("--  get " + res);
            
            ret.add(new ArrayList<>(res));
            return;
        }

        for (int i = 1; i <= s.length() - index; i++){
            if (index+i > s.length()) break;

            String s1 = s.substring(index, index + i);
            if (!isPartition(s1)) continue;

            res.add(s1);
//            System.out.println("-- add " + s1);

            getPartition(s,index+i,res);

            String s2 = res.remove(res.size() - 1);
//            System.out.println("-- remove1 " + s2);
        }

    }

    private boolean isPartition(String s){

        if (s.length() == 1)
            return true;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;
    }
}