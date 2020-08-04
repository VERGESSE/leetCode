import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {

        int sum1 = 0;
        for(int c : array1)
            sum1 += c;
        int sum2 = 0;
        for(int c : array2)
            sum2 += c;
        if(sum1 == sum2)
            return new int[0];
        int differ = sum1 - sum2;
        if(Math.abs(differ) % 2 == 1)
            return new int[0];
        differ /= 2;
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(array2);
        for(int i : array1){
            if (set.contains(i))
                continue;
            set.add(i);
            int index = Arrays.binarySearch(array2, i - differ);
            if (index >= 0)
                return new int[]{i, array2[index]};
        }
        return new int[0];
    }
}
