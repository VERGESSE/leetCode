import java.util.ArrayList;
import java.util.List;

class Solution {
    // cur : 当前答案，以 String List的形式，最后再join成String形式 例如 [[255],[255],[111],[35]] -> 255.255.111.35
    // pos, 当前扫描到的s的位置， ans最终答案
    private void backtracking(String s, int pos, List<String> cur,  List<String> ans) {
        if (cur.size() >= 4) {
            System.out.println("-- get" + String.join(".", cur));
            if (pos == s.length()) {
                ans.add(String.join(".", cur));
                System.out.println("-- getLast" + String.join(".", cur));
            }
            return;
        }
        // 分割得到ip地址的一段后，下一段只能在长度1-3范围内选择
        for (int i = 1; i <= 3; i++) {
            if (pos+i > s.length()) break;
            String segment = s.substring(pos, pos+i);
            // 剪枝条件：不能以0开头，不能大于255
            if (segment.startsWith("0") && segment.length() > 1
                    || (i == 3 && Integer.parseInt(segment) > 255)) continue;
            cur.add(segment);
            System.out.println("-- add " + segment);
            // 注意此处传的参数
            backtracking(s, pos+i, cur, ans);
            String remove = cur.remove(cur.size() - 1);
            System.out.println("-- remove " + remove);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> stringList = solution.restoreIpAddresses("25525511135");
        System.out.println(stringList);
    }
}

/*  fast
class Solution {

    private List<String> result = new ArrayList<>();
    private int[] indices = new int[4];

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, 0);
        return result;
    }

    void restoreIpAddresses(String s, int num, int pos) {
        if (num == 3) {
            int len = s.length() - pos;
            if (len > 3 || (len == 3 && s.substring(pos).compareTo("255") > 0)) {
                return;
            }
            if (s.charAt(pos) == '0' && len > 1) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(s.substring(indices[i], indices[i + 1])).append('.');
            }
            result.add(sb.append(s.substring(indices[3])).toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (pos + i >= s.length()) {
                return;
            }
            if (i == 3 && s.substring(pos, pos + i).compareTo("255") > 0) {
                return;
            }
            indices[num + 1] = pos + i;
            restoreIpAddresses(s, num + 1, pos + i);
            if (s.charAt(pos) == '0') {
                return;
            }
        }
    }
}
 */

/*  more
class Solution {
    List<String> list = new ArrayList<>();

    public  List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) return list;
        int index = 1;
        String build = "";
        int dian = 0;
        add(index, build, s, dian);
        return list;
    }

    public  void add(int index, String build, String s, int dian) {

        int sl = s.length();
        if (build.length() == sl + 3 && dian == 3) {
            list.add(build);
            return;
        }
        if (dian > 3 || index > sl) {
           // System.out.println("index==>" + index + ",build==>" + build + ",dian==>" + dian);
            return;
        }
   if (sl - index > 3 * (4 - dian)) return;
        int begin = build.length() - dian;
        if (begin - index >= 3) return;
        String first = s.substring(begin, index);
        //  System.out.println("first==>" + first);
        if (first.equals("")) return;
        int fn = Integer.parseInt(first);
        if (first.equals("0") || (fn > 0 && fn <= 255&&first.charAt(0)!='0')) {
            if (build.length() == 0) {
                add(index + 1, first, s, dian);
            } else {
                add(index + 1, build.concat(".").concat(first), s, dian + 1);
            }
        } else {
            return;
        }
        add(index + 1, build, s, dian);
    }
}
 */