import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {

        Map<Integer, Integer> map = new HashMap<>(K + 1);
        int l = 0, r = 0;
        int len = A.length;
        int res = 0;

        for(; r < len; r++){
            map.put(A[r], map.getOrDefault(A[r], 0) + 1);
            // 区间数的数量大于K，减小到K个
            for (; map.size() > K; l++){
                map.put(A[l], map.get(A[l]) - 1);
                if(map.get(A[l]) == 0){
                    map.remove(A[l]);
                }
            }
            // 满足条件 K 个元素的子数组
            if(map.size() == K){
                res++;
                // 统计以r为终点的子数组
                int tmp = l;
                for(; map.size() == K; l++){
                    map.put(A[l], map.get(A[l]) - 1);
                    if(map.get(A[l]) == 0){
                        map.remove(A[l]);
                    }
                    // 子数组满足条件
                    if(map.size() == K){
                        res ++;
                    }
                }
                for(l--; l > tmp; l--){
                    map.put(A[l], map.getOrDefault(A[l], 0) + 1);
                }
                map.put(A[l], map.getOrDefault(A[l], 0) + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysWithKDistinct(
                new int[]{1,2,1,3,4}, 3));
    }
}

/* 3ms
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {

        int length = A.length, left = 0, right = 0, diff = 0, ans = 0;
        int[] arr = new int[length + 1];

        while (right < length) {
            if (arr[A[right]]++ == 0) {
                diff++;
            }
            while (diff > K) {
                if (--arr[A[left]] == 0) {
                    diff--;
                }
                left++;
            }
            if (diff == K) {
                int leftTemp = left;
                while (diff == K) {
                    if (--arr[A[leftTemp]] == 0) {
                        diff--;
                    }
                    leftTemp++;
                    ans++;
                }
                for (int i = left; i < leftTemp; i++)
                    if (arr[A[i]]++ == 0) {
                        diff++;
                    }
            }
            right++;
        }
        return ans;
    }
}
 */
