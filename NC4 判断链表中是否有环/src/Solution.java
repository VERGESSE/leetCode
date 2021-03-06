/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pre = null;

        while(head != null){
            pre = head;
            if(head.next == dummyHead){
                return true;
            }
            head = head.next;
            pre.next = dummyHead;
        }

        return false;
    }
}
