class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummmyHead = new ListNode(0);
        dummmyHead.next = head;
        ListNode cur = dummmyHead;

        while (cur != null && cur.next != null){

            if (cur.next.val == val){
                cur.next = cur.next.next;

            }else
                cur = cur.next;
        }
        return dummmyHead.next;
    }
}