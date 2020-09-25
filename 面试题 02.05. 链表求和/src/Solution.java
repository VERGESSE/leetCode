/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode node = new ListNode(0);
        ListNode ret = node;
        // 进位
        int c = 0;
        while (l1 != null && l2 != null){
            int a = l1.val;
            int b = l2.val;
            node.next = new ListNode((a + b + c) % 10);
            c = (a + b + c) / 10;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        while (l1 != null){
            int a = l1.val;
            node.next = new ListNode((a + c) % 10);
            c = (a + c) / 10;
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null){
            int a = l2.val;
            node.next = new ListNode((a + c) % 10);
            c = (a + c) / 10;
            l2 = l2.next;
            node = node.next;
        }
        if (c != 0){
            node.next = new ListNode(c);
        }

        return ret.next;
    }
}
