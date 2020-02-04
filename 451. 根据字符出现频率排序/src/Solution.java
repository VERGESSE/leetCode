import java.util.*;

class Solution {
    public String frequencySort(String s) {

        Map<Character,Integer> charNumMap = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            Integer count = charNumMap.getOrDefault(s.charAt(i), 0);
            charNumMap.put(s.charAt(i), count + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entrySet = charNumMap.entrySet();
        List<Map.Entry<Character,Integer>> list=new ArrayList<>();
        list.addAll(entrySet);
        ValueComparator comparator = new ValueComparator();
        Collections.sort(list,comparator);
        for (Map.Entry<Character, Integer> entry : list) {
            Integer value = entry.getValue();
            while (value > 0){
                stringBuilder.append(entry.getKey().toString());
                value--;
            }
        }

        return stringBuilder.toString();
    }

    private static class ValueComparator implements Comparator<Map.Entry<Character,Integer>>
    {
        public int compare(Map.Entry<Character,Integer> m,Map.Entry<Character,Integer> n)
        {
            return n.getValue()-m.getValue();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }
}