import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words,(o1,o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else{
                return Integer.compare(o2.length(),o1.length());
            }
        });
        Set<String> set = new HashSet<>(words.length);
        for (String word : words) {
            set.add(word);
        }

        for(String word : words){
            set.remove(word);
            if(find(set, word))
                return word;
        }
        return "";
    }

    private boolean find(Set<String> set, String word){
        if(word.length() == 0)
            return true;
        for(int i = 0; i < word.length(); i++){
            if(set.contains(word.substring(0, i+1))
                    && find(set,word.substring(i+1)))
                return true;
        }
        return false;
    }
}
