class Solution {
    public int countVowelStrings(int n) {
        // 排列组合
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
