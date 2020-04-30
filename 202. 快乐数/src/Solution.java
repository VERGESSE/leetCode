import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> memo = new HashSet();

        while(!memo.contains(n)){
            memo.add(n);
            n = cal(n);
            if(n == 1)
                return true;
        }
        return false;
    }

    private int cal(int num){
        int res = 0;
        while(num > 0){
            res += Math.pow(num%10,2);
            num = num / 10;
        }
        return res;
    }
}

//fast   快慢指针
class Solution2 {
    public boolean isHappy(int n) {
        int slow = cal(n);
        int fast = cal(slow);
        while(slow!=fast){
            if(slow==1||fast==1) return true;
            slow=cal(slow);
            fast=cal(cal(fast));
        }
        return slow==1;
    }

    public int cal(int num){
        int result=0;
        while(num>0){
            result+=Math.pow(num%10,2);
            num/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
        String pattren = "asdasfas";
        System.out.println(pattren.charAt(3));
        System.out.println(pattren.indexOf(pattren.charAt(3)));
    }
}