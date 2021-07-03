import java.util.*;

class Solution {
    public String frequencySort(String s) {

        int[] cont = new int[256];
        char[] chars = s.toCharArray();
        for(char c : chars){
            cont[c] ++;
        }
        List<Object[]> list = new ArrayList<>();
        for(int i = 0; i < cont.length; i++){
            if(cont[i] > 0){
                StringBuilder sb = new StringBuilder(cont[i]);
                for(int j = 0; j < cont[i]; j++){
                    sb.append((char)i);
                }
                list.add(new Object[]{cont[i], sb.toString()});
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        list.stream()
                .sorted((a, b) -> (int) b[0] - (int) a[0])
                .map(a -> (String)a[1])
                .forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }
}

/*
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
 */
