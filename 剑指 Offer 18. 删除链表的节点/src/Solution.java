/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode node = head;
        while (head.next != null){
            if (head.next.val == val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }
}
