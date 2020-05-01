class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode first = (l1.val >= l2.val)? l2 : l1;
        ListNode later = (l1.val >= l2.val)? l1 : l2;
        ListNode retNode = first;

        while (first.next != null && later != null){
            if (later.val < first.next.val){
                ListNode tmpfirst = first.next;
                first.next = later;
                ListNode tmplater = later.next;
                later.next = tmpfirst;
                later = tmplater;
            }
            first = first.next;
        }
        if (later != null)
            first.next = later;

        return retNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode2 = solution.mergeTwoLists(listNode, listNode1);
        while (listNode2 != null){
            System.out.print(listNode2.val);
            listNode2 = listNode2.next;
        }
    }
}

/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else{
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }

        if(l1 != null){
            cur.next = l1;
        }

        if(l2 != null){
            cur.next = l2;
        }

        return head.next;
    }
}
 */