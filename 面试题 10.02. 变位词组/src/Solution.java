import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String sortStr = sortStr(s);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            if (list.isEmpty()){
                map.put(sortStr, list);
            }
            list.add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String sortStr(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
