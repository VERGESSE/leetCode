class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){

            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}

class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        ListNode tmpSingleHead = new ListNode(0);
        ListNode tmpDoubleHead = new ListNode(0);
        ListNode tmpSingle = tmpSingleHead;
        ListNode tmpDouble = tmpDoubleHead;
        int count = 0;
        while (head != null) {
            count ++;
            if(count % 2 == 1) {
                tmpSingle.next = head;
                tmpSingle = tmpSingle.next;
            }else {
                tmpDouble.next = head;
                tmpDouble = tmpDouble.next;
            }
            head = head.next;
        }
        tmpSingle.next = tmpDoubleHead.next;
        tmpDouble.next = null;
        return tmpSingleHead.next;
    }
}