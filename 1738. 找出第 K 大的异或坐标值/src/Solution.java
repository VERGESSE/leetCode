import java.util.PriorityQueue;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(m + n);
        queue.offer(matrix[0][0]);
        for(int i = 1; i < n; i++){
            matrix[0][i] ^= matrix[0][i - 1];
            queue.offer(matrix[0][i]);
        }
        for(int j = 1; j < m; j++){
            matrix[j][0] ^= matrix[j - 1][0];
            queue.offer(matrix[j][0]);
        }

        while (queue.size() > k){
            queue.poll();
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] ^= matrix[i-1][j] ^ matrix[i][j-1] ^ matrix[i-1][j-1];
                if (queue.size() < k || queue.peek() < matrix[i][j]){
                    queue.offer(matrix[i][j]);
                    if (queue.size() > k){
                        queue.poll();
                    }
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthLargestValue(
                new int[][]{{5, 2}, {1, 6}}, 4));
    }
}
