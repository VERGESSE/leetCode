import java.util.HashMap;

class WordsFrequency {

    private final HashMap<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for(String s : book){
            map.compute(s, (k, v) -> (v == null ? 1 : v + 1));
            // map.merge(str, 1, (old_val, new_val) -> old_val + new_val);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */
