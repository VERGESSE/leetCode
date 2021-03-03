class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // 第 i 个数的1的个数等于 i 右移一位的数的1的个数加上 i 末位是否是1
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
