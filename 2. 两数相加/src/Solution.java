class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode retNode = new ListNode(0);
        ListNode listNode = retNode;
        int carry = 0;

        while (l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = carry + l1.val;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = carry + l2.val;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            l2 = l2.next;
        }

        if (carry > 0)
            listNode.next = new ListNode(carry);

        return retNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode2 = solution.addTwoNumbers(listNode, listNode1);
        while (listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }
}