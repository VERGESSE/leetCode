class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        // 解决next节点为空时的程序错误
        while (cur != null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

