class Solution {
    public void deleteNode(ListNode node) {

        // 不是穿针引线而是改变节点的值
        if (node == null || node.next == null){
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;

        return;
    }
}