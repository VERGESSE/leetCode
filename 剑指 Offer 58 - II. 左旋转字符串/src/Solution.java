class Solution {
    public String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0, n);
    }
}

/*
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
}
 */
