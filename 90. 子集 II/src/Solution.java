import java.util.*;

class Solution {
    
    
    int n;
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> path = new Stack();
    // 加上剪枝操作, 相同层, 如果当前元素与上一个元素相同, 则跳过不遍历以实现剪枝.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length <= 0) return result;
        n = nums.length;
        
        // 先排序, 这是很重要的.
        Arrays.sort(nums);
        
        dfs(nums, 0);
        
        return result;
    }
    
    public void dfs(int[] nums, int start){
        result.add(new ArrayList<>(path));
        
        for(int i = start; i < n; i++){
            if((i-1)>=start && nums[i-1] == nums[i]) continue;
            path.push(nums[i]);
            dfs(nums, i+1);
            path.pop();
        }
        
    }
}

// 1ms
class Solution2 {
    private void backtracking(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(path);
        } else {
            int m = index + 1;
            while (m < nums.length && nums[index] == nums[m]) m++;
            backtracking(nums, m, path, result);
            for (int i = index; i < m; i++) {
                List<Integer> path2 = new ArrayList<>(path);
                for (int j = index; j <= i; j ++)
                    path2.add(nums[j]);
                backtracking(nums, m, path2, result);
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, result);
        return result;
    }
}