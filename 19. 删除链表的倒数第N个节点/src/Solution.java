class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummmyHead = new ListNode(0);
        dummmyHead.next = head;

        ListNode p = dummmyHead;
        ListNode q = dummmyHead;
        for (int i = 0; i < n + 1; i++){
            q = q.next;
        }

        while (q != null){
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return dummmyHead.next;
    }
}