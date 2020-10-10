/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode HA = headA, HB = headB;

        while(HA != HB){
            HA = HA == null ? headB : HA.next;
            HB = HB == null ? headA : HB.next;
        }
        return HA;
    }
}
