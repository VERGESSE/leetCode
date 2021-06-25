import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);

        if (deadSet.contains("0000") || deadSet.contains(target)) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        HashMap<String,Integer> visited = new HashMap<>();
        visited.put("0000",0);
        while (!queue.isEmpty()){
            String curs = queue.remove();
            char[] curArray = curs.toCharArray();

            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++){
                char o = curArray[i];
                curArray[i] = Character.forDigit((curArray[i] - '0' + 1) % 10, 10);
                nexts.add(String.copyValueOf(curArray));
                curArray[i] = Character.forDigit((o - '0' + 9) % 10, 10);
                nexts.add(String.copyValueOf(curArray));
                curArray[i] = o;
            }

            for (String next : nexts){
                if (!visited.containsKey(next) && !deadSet.contains(next)){
                    queue.add(next);
                    visited.put(next, visited.get(curs) + 1);
                    if (next.equals(target))
                        return visited.get(next);
                }
            }
        }

        return -1;
    }
}
