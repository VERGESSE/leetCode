/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        if(head == null || head.next == null)
            return head;
        int len = 1;
        ListNode tempHead = head;
        while(tempHead.next != null){
            len++;
            tempHead = tempHead.next;
        }

        while(len-- != k){
            head = head.next;
        }
        return head;
    }
}

/* 快慢指针
public ListNode getKthFromEnd(ListNode head, int k) {

    ListNode frontNode = head, behindNode = head;
    while (frontNode != null && k > 0) {
        frontNode = frontNode.next;
        k--;
    }

    while (frontNode != null) {
        frontNode = frontNode.next;
        behindNode = behindNode.next;
    }

    return behindNode;
}
 */
