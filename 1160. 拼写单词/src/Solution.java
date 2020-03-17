class Solution {

    int[] charNums = new int[26];

    public int countCharacters(String[] words, String chars) {

        int res = 0;
        for (char c : chars.toCharArray()) {
            charNums[c - 'a']++;
        }

        for (String str : words)
            if (check(str))
                res += str.length();

        return res;
    }

    private boolean check(String str){
        int temp = 0;
        int[] tempCharNums = new int[26];
        for (char c : str.toCharArray()){
            int i = c - 'a';
            tempCharNums[i]++;
            if (tempCharNums[i] > charNums[i])
                return false;
        }
        return true;
    }
}