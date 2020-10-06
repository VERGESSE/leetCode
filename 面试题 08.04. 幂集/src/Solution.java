import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>());
        //当前元素
        for(int n : nums){
            //原来元素的基础数
            int length = answers.size();
            for(int i = 0; i < length; i++){
                //将原来的元素集合全部加入新集合中
                List<Integer> lists = new ArrayList<>(answers.get(i));
                //将当前元素加入到新集合中
                lists.add(n);
                //结果集
                answers.add(lists);
            }
        }
        return answers;
    }
}
