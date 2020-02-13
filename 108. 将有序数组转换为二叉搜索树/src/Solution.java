class Solution {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return sortedArrayToBST(0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int left, int right) {

        if (left > right) return null;

        int p = right - (right - left)/2;

        TreeNode ret = new TreeNode(nums[p]);
        ret.left = sortedArrayToBST(left,p-1);
        ret.right = sortedArrayToBST(p+1,right);
        return ret;
    }
}