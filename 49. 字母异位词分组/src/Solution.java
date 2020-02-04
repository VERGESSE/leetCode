import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> retString = new ArrayList<>();

        List<String> nullList = new ArrayList<>();

        Map<Character,Integer> record = new HashMap<>();

        if(strs.length <= 1) {
            retString.add(new ArrayList<String>(Arrays.asList(strs)));
            return retString;
        }

        int flag = 0;
        int now = 1;
        int l = 0;
        int r = strs.length - 1;
        while (flag < strs.length) {

            if(strs[flag] == ""){
                nullList.add("");
                String temp = strs[r];
                strs[r] = strs[flag];
                strs[flag] = temp;
                flag++;
                r--;
                continue;
            }

            for (int i = 0; i < strs[flag].length(); i++) {
                Integer count = record.getOrDefault(strs[flag].charAt(i), 0);
                record.put(strs[flag].charAt(i), count + 1);
            }
            for(int i = flag; i < strs.length; i++ ){

                if(i < now)
                    continue;
                Boolean ifSave = false;
                for(int j = 0; j < strs[i].length(); j++){
                    Integer defCount = record.getOrDefault(strs[i].charAt(j), 0);
                    if(defCount == 0) {
                        ifSave = false;
                        break;
                    }
                    ifSave = true;
                }
                if(ifSave) {
                    String temp;
                    temp = strs[now];
                    strs[now] = strs[i];
                    strs[i] = temp;
                    now++;
                    if(now >= strs.length - 1)
                        now = strs.length - 1;
                }
            }

            flag = now;
            now++;
//            if(now >= strs.length - 1)
//                now = strs.length - 1;
            List<String> tempList = new ArrayList<>();
            for(int i = l; i < flag; i++){
                tempList.add(strs[i]);
            }
            retString.add(tempList);
            l = flag;
        }
        if(nullList.size()>0)
            retString.add(nullList);
        return retString;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"",""};
        System.out.println(solution.groupAnagrams(strs));
    }
}

//上面自己写的代码不知名原因错误
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))    map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"",""};
        System.out.println(solution.groupAnagrams(strs));
    }
}