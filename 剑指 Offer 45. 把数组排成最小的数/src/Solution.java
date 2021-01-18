import java.util.Arrays;

class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> {
            char[] c1 = x.toCharArray();
            char[] c2 = y.toCharArray();
            if (c1[0] != c2[0]){
                return c1[0] - c2[0];
            }
            int i = 0, j = 0, timeI = 0, timeJ = 0;
            while (c1[i] == c2[j]){
                if (timeI ==2 || timeJ==2) break;
                if (i+1 >= c1.length) {
                    i = 0;
                    timeI++;
                } else i ++;

                if (j+1 >= c2.length){
                    j = 0;
                    timeJ++;
                } else j++;
            }
            return c1[i] - c2[j];
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}

/*
class Solution {
    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        IntStream.of(nums)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> {
                if (a.length() == b.length()){
                    return a.compareTo(b);
                }
                return (a + b).compareTo(b + a);
            })
            .forEach(res::append);
        return res.toString();
    }
}
 */

/*
class Solution {
    public String minNumber(int[] nums) {

        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,
                (x, y) -> (x + y).compareTo(y + x));

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
*/
