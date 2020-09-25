class Solution {
    public String replaceSpaces(String S, int length) {

        char[] chars = S.toCharArray();
        char[] res = new char[S.length()];
        int index = 0;
        for(int i = 0; i < length; i++){
            char c = chars[i];
            if(c != ' '){
                res[index++] = c;
            } else {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            }
        }
        return new String(res, 0, index);
    }
}

/* slow
class Solution {
    public String replaceSpaces(String S, int length) {

        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder(S.length());
        for(int i = 0; i < length; i++){
            char c = chars[i];
            if(c != ' '){
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
 */
