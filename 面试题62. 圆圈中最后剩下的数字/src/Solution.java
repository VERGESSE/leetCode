class Solution {
    public int lastRemaining(int n, int m) {

        int flag = 0;
        for(int i=2;i <=n;i++){
            flag = (flag + m)%i;
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = solution.lastRemaining(10,17);
        System.out.println(num);
    }
}

/* 递归实现
class Solution {
    public int lastRemaining(int n, int m) {

        return lastNum(n, m);
    }

    private int lastNum(int n, int m){

        if (n == 1)
            return 0;
        int temp = lastNum(n - 1, m);

        return (m + temp) % n;
    }
}
 */

/*
第一轮是 [0, 1, 2, 3, 4] ，所以是 [0, 1, 2, 3, 4] 这个数组的多个复制。这一轮 2 删除了。

第二轮开始时，从 3 开始，所以是 [3, 4, 0, 1] 这个数组的多个复制。这一轮 0 删除了。

第三轮开始时，从 1 开始，所以是 [1, 3, 4] 这个数组的多个复制。这一轮 4 删除了。

第四轮开始时，还是从 1 开始，所以是 [1, 3] 这个数组的多个复制。这一轮 1 删除了。

最后剩下的数字是 3。

图中的绿色的线指的是新的一轮的开头是怎么指定的，每次都是固定地向前移位 m 个位置。

然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。

最后剩下的 3 的下标是 0。

第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。

第三轮反推，补上 m 个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。

第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。

第一轮反推，补上 m 个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。

所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。

总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。

代码就很简单了。

 */