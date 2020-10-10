import java.util.*;

class Solution {
    public int findClosest(String[] words, String word1, String word2) {

        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
            list.add(i);
            map.put(cur, list);
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        if(list1 == null || list2 == null)
            return -1;
        int min = Integer.MAX_VALUE;
        for(int i : list1){
            for(int j : list2){
                min = Math.min(Math.abs(i - j), min);
            }
        }
        return min;
    }
}

/*
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int min = -1;
        int lastWord1Index = -1;
        int lastWord2Index = -1;
        for (int i = 0; i < words.length - 1; i++) {
            boolean flag = false;
            if (words[i].equals(word1)) {
                lastWord1Index = i;
                flag = true;
            }
            if (words[i].equals(word2)) {
                lastWord2Index = i;
                flag = true;
            }

            if (lastWord1Index == -1 || lastWord2Index == -1) {
                continue;
            }
            if(flag){
                int tmp = Math.abs(lastWord1Index - lastWord2Index);
                if (tmp < min || min == -1) {
                    min = tmp;
                }
            }
        }

        return min;
    }
}
 */
