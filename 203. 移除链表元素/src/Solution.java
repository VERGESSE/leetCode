class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummmyHead = new ListNode(0);
        dummmyHead.next = head;
        ListNode cur = dummmyHead;

        while (cur.next != null){

            if (cur.next.val == val){
                cur.next = cur.next.next;

            }else
                cur = cur.next;
        }
        return dummmyHead.next;
    }
}

/* 2021/6/5
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 头
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode dummyHead = head;
        // 中
        while(head != null && head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummyHead;
    }
}
 */
