class Solution {
    public int[] constructArr(int[] a) {

        if(a == null || a.length < 2)
            return a;
        int len = a.length;
        int[] pre = new int[len];
        pre[0] = a[0];
        int[] post = new int[len];
        post[len - 1] = a[len - 1];
        for(int i = 1; i < len - 1; i++){
            pre[i] = pre[i - 1] * a[i];
        }
        for(int i = len - 2; i > 0; i--){
            post[i] = post[i + 1] * a[i];
        }
        int[] res = new int[len];
        res[0] = post[1];
        res[len - 1] = pre[len - 2];
        for(int i = 1; i < len - 1; i++){
            res[i] = pre[i - 1] * post[i + 1];
        }
        return res;
    }
}

/*
class Solution {
    public int[] constructArr(int[] a) {
        if (a.length <= 1) return a;
        int[] res = new int[a.length];
        int product = 1;
        for (int i = 0; i < a.length; ++ i) {
            res[i] = product;
            product *= a[i];
        }

        product = 1;
        for (int i = a.length-1; i >= 0; -- i) {
            res[i] *= product;
            product *= a[i];
        }

        return res;
    }
}
 */
