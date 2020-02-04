import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> record = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for(int i = 0; i < nums1.length; i++ ){
            record.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            if(record.contains(nums2[i]))
                resultSet.add(nums2[i]);
        }

        int[] ints = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        for(int i = 0; i < resultSet.size(); i++){
            ints[i] = iterator.next();
        }

        return ints;
    }
}