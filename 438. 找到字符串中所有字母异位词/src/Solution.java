import java.util.ArrayList;
import java.util.List;

class Solution {
    // 双指针 -> 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length())
            return list;

        int [] a2z = new int[26];
        int [] curA2z = new int[26];

        for (int i=0; i<p.length(); ++i){
            a2z[p.charAt(i) - 'a']++;     // 记录p串有哪些字符
            curA2z[s.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = p.length();

        // 窗口大小固定为p的长度
        while (j < s.length()){
            if (isSame(a2z, curA2z))
                list.add(i);
            curA2z[s.charAt(i++) - 'a']--;
            curA2z[s.charAt(j++) - 'a']++; // 没找到符合条件的窗口，移动右指针
        }

        if (isSame(a2z, curA2z))   // 检查最末尾的 p.length() 个字符是否符合条件
            list.add(i);

        return list;
    }

    public boolean isSame(int[] arr1, int[] arr2){
        for (int i=0; i<arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}













