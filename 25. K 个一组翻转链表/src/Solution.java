class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        ListNode tmp = head;
        while (tmp != null){
            length ++;
            tmp = tmp.next;
        }

        ListNode p = dummyHead;
        ListNode[] listNodes = new ListNode[k];
        for (int i = 0; i < length/k; i++){
            tmp = p;
            for (int j = 0; j < k; j++){
                listNodes[j] = tmp.next;
                tmp = tmp.next;
            }
            ListNode next = tmp.next;
            for (int j = k -1 ; j > 0; j--){
                listNodes[j].next = listNodes[j -1];
            }
            p.next = listNodes[k - 1];
            listNodes[0].next = next;
            p = listNodes[0];
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

//        ListNode listNode1 = new ListNode(5);
//        listNode1.next = new ListNode(6);
//        listNode1.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode2 = solution.reverseKGroup(listNode,2);
        while (listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }
}

/*  fast
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
 */