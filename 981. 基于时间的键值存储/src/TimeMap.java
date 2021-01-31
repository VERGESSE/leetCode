import java.util.*;

class TimeMap {

    private final Map<String, TimestampList> keyMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        keyMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TimestampList timestampList = keyMap.getOrDefault(key, new TimestampList());
        timestampList.add(timestamp, value);
        keyMap.put(key, timestampList);
    }

    public String get(String key, int timestamp) {
        TimestampList timestampList = keyMap.get(key);
        if (timestampList == null){
            return "";
        }
        String search = timestampList.search(timestamp);
        if (search == null){
            return "";
        }
        return search;
    }

    private class TimestampList{
        private final List<Pair> list;

        TimestampList(){
            list = new ArrayList<>();
        }

        void add(int timestamp, String value){
            this.list.add(new Pair(timestamp, value));
        }

        /**
         * 二分查找 list 中 key 的键值或者第一个比 key 小的时间戳
         */
        String search(int key){
            int start = 0;
            int end = list.size() - 1;
            while (start <= end){
                int mid = start + (end - start) / 2;
                Pair cur = list.get(mid);
                if (cur.key == key){
                    return cur.value;
                }
                if (cur.key > key){
                    end = mid - 1;
                } else {
                    if (mid + 1 < list.size()){
                        Pair post = list.get(mid + 1);
                        if (post.key > key){
                            return cur.value;
                        }
                    } else {
                        // 最后一个元素小于指定时间戳
                        return cur.value;
                    }
                    start = mid + 1;
                }
            }
            return null;
        }
    }

    private class Pair{
        int key;
        String value;

        Pair(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
}

/*
class TimeMap {

    private final Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> values = map.getOrDefault(key, new TreeMap<>());
        values.put(timestamp, value);
        map.put(key, values);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values = map.get(key);
        if (values == null){
            return "";
        }
        Integer truthKey = values.floorKey(timestamp);
        if (null == truthKey){
            return "";
        }
        return values.get(truthKey);
    }
}
 */
