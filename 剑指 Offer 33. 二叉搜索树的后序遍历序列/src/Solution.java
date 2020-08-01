class Solution {
    public boolean verifyPostorder(int[] postorder) {

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if(end - start <= 1)
            return true;
        int p1 = start, p2;
        int curRoot = postorder[end];
        while(postorder[p1] < curRoot)
            p1++;
        if(!verifyPostorder(postorder, start, p1 - 1))
            return false;
        p2 = p1;
        while(p2 < end)
            if(postorder[p2++] <= curRoot)
                return false;
        return verifyPostorder(postorder, p1, end - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(
                new int[]{1,6,3,2,5}
        ));
    }
}
