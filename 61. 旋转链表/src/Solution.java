class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummmyHead = new ListNode(0);
        dummmyHead.next = head;

        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        if (length == 0)
            return null;

        ListNode p = dummmyHead;
        ListNode q = dummmyHead;
        for (int i = 0; i < k % length; i++){
            q = q.next;
        }

        while (q.next != null){
            q = q.next;
            p = p.next;
        }

        q.next = dummmyHead.next;
        dummmyHead.next = p.next;
        p.next = null;

        return dummmyHead.next;
    }
}