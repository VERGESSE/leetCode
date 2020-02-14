import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int numSquares(int n) {     // 动态规划  超31.88%

        int[] memo = new int[n+1];
        memo[1] = 1;

        for (int i = 2; i < n+1; i++){
            if ((int)Math.sqrt(i)*(int)Math.sqrt(i) == i)
                memo[i] = 1;
            for (int j = 1; j < Math.sqrt(i); j++){
                memo[i] = min3(memo[i],1+memo[i-j*j],Integer.MAX_VALUE);
            }
        }
        return memo[n];
    }

    private int min3(int a,int b,int c){
        if (a == 0)
            return Math.min(b,c);
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(13));
    }

}

/*  图的解法，广度优先遍历   超93%
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        boolean record[] = new boolean[n];
        while (!queue.isEmpty()) {
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            // 每一层的广度遍历
            for (int i = 1;; i++) {
                int nextVal = val - i * i;
                // 说明已到最大平方数
                if (nextVal < 0)
                    break;

                // 由于是广度遍历，所以当遍历到0时，肯定是最短路径
                if(nextVal == 0)
                    return step;

                // 当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长
                if(!record[nextVal]){
                    queue.add(new Node(nextVal,step + 1));
                    record[nextVal] = true;
                }
            }
        }
        return -1;
    }
 */