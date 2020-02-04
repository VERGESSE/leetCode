import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> record = new HashMap<>();

        for(int i = 0; i < nums1.length; i++){
            Integer count = record.getOrDefault(nums1[i], 0);
            record.put(nums1[i],count + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            Integer num2Count = record.getOrDefault(nums2[i], 0);
            if( num2Count > 0){
                resultList.add(nums2[i]);
                record.put(nums2[i],num2Count-1);
            }
        }

        int[] ints = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            ints[i] = resultList.get(i);
        }

        return ints;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
//        System.out.println(solution.intersect(nums1,nums2).length);
//    }
}