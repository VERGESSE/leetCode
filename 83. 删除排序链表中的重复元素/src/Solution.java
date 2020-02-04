class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode pre = head;
//        ListNode cur = head.next;
//
//        while (cur != null){
//            if(cur.val == pre.val){
//                pre = cur.next;
//                cur = cur.next;
//            }
//            if (cur != null)
//                cur = cur.next;
//        }
//
//        return head;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2};
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode duplicates = solution.deleteDuplicates(listNode);
        System.out.println(duplicates);
    }
}