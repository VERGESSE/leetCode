class Solution {
    public int findSubstringInWraproundString(String p) {
        // 记录 p 中以每个字符结尾的最长连续子串的长度
        int[] dp = new int[26];
        char[] array = p.toCharArray();
        // 记录当前连续子串的长度
        int count = 0;
        // 遍历 p 中的所有字符
        for (int i = 0; i < array.length; i++) {
            // 判断字符是否连续
            if (i > 0 && (array[i] - array[i - 1] - 1) % 26 == 0) {
                // 连续则自加
                count++;
            } else {
                // 不连续则刷新
                count = 1;
            }
            // 只存储最长的连续长度
            dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], count);
        }
        int result = 0;
        // 统计所有以每个字符结尾的最长连续子串的长度，就是唯一相等子串的个数
        for (int i : dp) {
            result += i;
        }
        return result;
    }
}

/* 优化
class Solution {
    public int findSubstringInWraproundString(String p) {
        // // 记录 p 中以每个字符结尾的最长连续子串的长度
        int[] dp = new int[26];
        char[] array = p.toCharArray();
        // 连续子串的开始下标
        int start = 0;
        while (start < array.length) {
            // 连续子串的结束下标
            int end = start + 1;
            // 结束下标向后移动，寻找当前最长的连续子串
            while (end < array.length && (array[end] - array[end-1] - 1) % 26 == 0) {
                end++;
            }
            // 计算连续子串的长度
            int length = end - start;
            // 遍历连续子串的所有字符
            for (int i = start; i < end; i++) {
                // 计算当前字符在数组的下标
                int index = array[i] - 'a';
                // 计算当前连续子串的长度
                int l = length - (i - start);
                dp[index] = Math.max(dp[index], l);
            }
            start = end;
        }
        int result = 0;
        for (int i : dp) {
            result += i;
        }
        return result;
    }
}
 */
