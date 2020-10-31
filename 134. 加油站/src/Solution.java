class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[] resume = new int[gas.length];
        boolean flag = false;
        for(int i = 0; i < gas.length; i++){
            resume[i] = gas[i] - cost[i];
            if(!flag && resume[i] >= 0)
                flag = true;
        }
        if(!flag) return -1;

        outer:
        for(int i = 0; i < resume.length; i++){
            if(resume[i] >= 0){
                int temp = resume[i];
                for(int j = i+1; j < resume.length; j++){
                    temp += resume[j];
                    if(temp < 0)
                        continue outer;
                }
                for(int j = 0; j < i; j++){
                    temp += resume[j];
                    if(temp < 0)
                        continue outer;
                }
                return i;
            }
        }
        return -1;
    }
}

/* 0ms
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = cost[0], start = 0, cur = 0, total = gas[0];
        int n = gas.length;
        cur = gas[start];
        for(int i = 1; i < n; i++){
            totalCost += cost[i];
            total += gas[i];
            cur -= cost[i-1];
            if(cur < 0){
                start = i;
                cur = gas[start];
            } else {
                cur += gas[i];
            }
        }
        return total >= totalCost ? start : -1;
    }
}
 */
