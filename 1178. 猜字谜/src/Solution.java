import java.util.*;

class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            // 将 word 中的字母按照字典序排序并去重
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; ++i) {
                if (i == 0 || arr[i] != arr[i - 1]) {
                    sb.append(arr[i]);
                }
            }
            // 加入字典树中
            add(root, sb.toString());
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            char required = puzzle.charAt(0);
            char[] arr = puzzle.toCharArray();
            Arrays.sort(arr);
            ans.add(find(new String(arr), required, root, 0));
        }
        return ans;
    }

    private void add(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                cur.child[ch - 'a'] = new TrieNode();
            }
            cur = cur.child[ch - 'a'];
        }
        ++cur.frequency;
    }

    // 在回溯的过程中枚举 puzzle 的所有子集并统计答案
    // find(puzzle, required, cur, pos) 表示 puzzle 的首字母为 required, 当
    // 前搜索到字典树上的 cur 节点，并且准备枚举 puzzle 的第 pos 个字母是否选择（放入子集中）
    // find 函数的返回值即为谜底的数量
    private int find(String puzzle, char required, TrieNode cur, int pos) {
        // 搜索到空节点，不合法，返回 0
        if (cur == null) {
            return 0;
        }
        // 整个 puzzle 搜索完毕，返回谜底的数量
        if (pos == puzzle.length()) {
            return cur.frequency;
        }

        // 选择第 pos 个字母
        int ret = find(puzzle, required,
                cur.child[puzzle.charAt(pos) - 'a'], pos + 1);

        // 当 puzzle.charAt(pos) 不为首字母时，可以不选择第 pos 个字母
        if (puzzle.charAt(pos) != required) {
            ret += find(puzzle, required, cur, pos + 1);
        }

        return ret;
    }
}

class TrieNode {
    int frequency;
    TrieNode[] child;

    TrieNode() {
        frequency = 0;
        child = new TrieNode[26];
    }
}


/* 超时
class Solution2 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        int[] answer = new int[puzzles.length];
        char[][] chars = new char[puzzles.length][26];
        char[][] wordArray = new char[words.length][26];

        for(int i = 0; i < puzzles.length; i++){
            for(int j = 0; j < puzzles[i].length(); j++){
                chars[i][puzzles[i].charAt(j) - 'a'] ++;
            }
        }

        for(int i = 0; i < wordArray.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                wordArray[i][words[i].charAt(j) - 'a'] ++;
            }
        }
        words = null;

        for (int j = 0; j < answer.length; j++) {
            for (char[] word : wordArray) {
                if (word[puzzles[j].charAt(0) - 'a'] == 0){
                    continue;
                }
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (word[k] > 0 && chars[j][k] == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer[j]++;
                }
            }
        }

        List<Integer> res = new ArrayList<>(answer.length);
        for (int num : answer) {
            res.add(num);
        }
        return res;
    }
}*/
