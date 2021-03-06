/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while(head != null){
            for(int i = 0; i < k - 1; i++){
                head = head.next;
                if(head == null){
                    return dummyHead.next;
                }
            }
            ListNode end =  head.next;
            ListNode nextPre =  pre.next;
            reverse(pre, pre.next, end);
            pre = nextPre;
            head = end;
        }

        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode node, ListNode end){
        ListNode pre = end;
        ListNode cur = node;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = pre;
        return pre;
    }
}
