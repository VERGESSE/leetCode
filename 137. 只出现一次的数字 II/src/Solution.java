import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }

        return -1;
    }
}

/* 位运算，空间复杂度O(1)   NOT，AND 和 XOR
class Solution {
  public int singleNumber(int[] nums) {
    int seenOnce = 0, seenTwice = 0;

    for (int num : nums) {
      // first appearence:
      // add num to seen_once
      // don't add to seen_twice because of presence in seen_once

      // second appearance:
      // remove num from seen_once
      // add num to seen_twice

      // third appearance:
      // don't add to seen_once because of presence in seen_twice
      // remove num from seen_twice
      seenOnce = ~seenTwice & (seenOnce ^ num);
      seenTwice = ~seenOnce & (seenTwice ^ num);
    }

    return seenOnce;
  }
}
 */