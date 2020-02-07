
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummmyNode = new ListNode(0);
        dummmyNode.next = head;

        ListNode p = dummmyNode;
        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;

            p = node1;
        }

        return dummmyNode.next;
    }
}