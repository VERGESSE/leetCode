class Solution {
    public String convertToTitle(int columnNumber) {

        columnNumber -= 1;
        StringBuilder res = new StringBuilder();

        int n = columnNumber / 26;
        int m = columnNumber % 26;
        if(n > 0){
            res.append(convertToTitle(n));
        }
        res.append((char)('A' + m));

        return res.toString();
    }
}
