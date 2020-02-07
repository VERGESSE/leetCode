class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        right = reverce(right);

        while (right != null){
            if (right.val != left.val)
                return false;

            right = right.next;
            left = left.next;
        }

        return true;
    }

    public ListNode reverce(ListNode node){
//        if (node == null || node.next == null)
//            return node;
//        ListNode last = reverce(node.next);
//        node.next.next = node;
//        node.next = null;
//        return last;

        //这样颠倒链表快很多   206题就是这种解法
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

//        ListNode listNode1 = new ListNode(5);
//        listNode1.next = new ListNode(6);
//        listNode1.next.next = new ListNode(4);

        Solution solution = new Solution();
        boolean listNode2 = solution.isPalindrome(listNode);
        System.out.println(listNode2);
//        while (listNode2 != null){
//            System.out.println(listNode2.val);
//            listNode2 = listNode2.next;
    }
}