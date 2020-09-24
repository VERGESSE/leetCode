import java.util.*;

class Solution {
    // 构造后继图，每个单词的后继列表
    private void buildNextWordsMap(HashMap<String, Set<String>> nextWordsMap,
                                   Set<String> wordSet) {
        char[] wordArr;
        for (String word : wordSet) {
            wordArr = word.toCharArray();
            Set<String> nextWords = new HashSet<>();
            //对于每个单词，每次变换一位，然后查看worSet中是否含有，有的话就是后继。
            for (int i = 0; i < wordArr.length; i++) {
                char original = wordArr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (original != j) {
                        wordArr[i] = j;
                        String tempWord = String.valueOf(wordArr);
                        if (wordSet.contains(tempWord)) {
                            nextWords.add(tempWord);
                        }
                    }
                }
                wordArr[i] = original;
            }
            nextWordsMap.put(word, nextWords);
        }
    }

    //执行广度优先搜索
    private List<String> BFS(HashMap<String, Set<String>> nextWordsMap,
                             String beginWord, String endWord) {
        //保存结果
        List<String> changePaths = new LinkedList<>();
        //保存搜索路径，key表示当前节点，value是当前节点的前驱节点，最后从endWord反向索引至beginWord即得到最短的变换路径
        HashMap<String, String> findPathMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        queue.offer(beginWord);
        isVisited.add(beginWord);
        outer:
        while (!queue.isEmpty()) {
            String word = queue.poll();
            //遍历后继
            for (String nextWord : nextWordsMap.get(word)) {
                if (!isVisited.contains(nextWord)) {
                    queue.add(nextWord);
                    findPathMap.put(nextWord, word);
                    isVisited.add(nextWord);
                    if (nextWord.equals(endWord)) {
                        break outer;
                    }
                }
            }
        }
        //反向遍历得到索引路径，因为每个节点只有一个前驱，如果起点到终点有路径就可以到达。
        String cur = endWord;
        changePaths.add(cur);
        String pre;
        do {
            pre = findPathMap.get(cur);
            if (pre == null) {
                return new ArrayList<>();
            }
            changePaths.add(pre);
            cur = pre;
        } while (!cur.equals(beginWord));
        //反转
        Collections.reverse(changePaths);
        return changePaths;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 保存单词集
        Set<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        // 保存后继图
        HashMap<String, Set<String>> nextWordsMap = new HashMap<>();
        buildNextWordsMap(nextWordsMap, wordSet);
        //执行广度优先遍历
        return BFS(nextWordsMap, beginWord, endWord);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = List.of(new String[]{"hot","dot","dog","lot","log","cog"});
        List<String> ladders = solution.findLadders("hit", "cog", list);
        System.out.println(ladders);
    }
}
