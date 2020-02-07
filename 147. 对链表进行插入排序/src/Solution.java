class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode cur = head;
        ListNode next = null;
        ListNode sortList = null;

        while (cur != null){
            next = cur.next;
            sortList = sortListNode(sortList,cur);
            cur = next;
        }
        return sortList;
    }

    public ListNode sortListNode(ListNode sortList,ListNode cur){
        ListNode retNode = sortList;
        if (sortList == null){
            sortList = cur;
            sortList.next = null;
            return sortList;
        }
        if (sortList.val >= cur.val){
            cur.next = sortList;
            return cur;
        }
        while (sortList != null){
            if (sortList.next == null) {
                sortList.next = cur;
                cur.next = null;
                break;
            }
            if (sortList.val < cur.val && sortList.next.val >= cur.val){
                cur.next = sortList.next;
                sortList.next = cur;
                break;
            }
            sortList = sortList.next;
        }
        return retNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
//        listNode.next.next.next.next = new ListNode(5);

//        ListNode listNode1 = new ListNode(5);
//        listNode1.next = new ListNode(6);
//        listNode1.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode2 = solution.insertionSortList(listNode);
        while (listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }
}

//人数最多
class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next  == null){
            return head;
        }
        ListNode dy = new ListNode(0);
        dy.next = head;
        ListNode pre;
        while (head != null && head.next != null){
            if(head.next.val > head.val){
                head = head.next;
                continue;
            }
            pre = dy;
            while (pre.next.val< head.next.val){
                pre = pre.next;
            }
            //插入节点
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dy.next;
    }
}

//最快
class Solution3 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode lo = head, hi = head, mid = head;
        while(hi.next != null && hi.next.next != null)
        {
            mid = mid.next;
            hi = hi.next.next;
        }
        hi = mid.next;
        mid.next = null;
        ListNode i = insertionSortList(lo);
        ListNode j = insertionSortList(hi);
        ListNode n_head = new ListNode(-1);
        ListNode k = n_head;
        while(i != null || j != null)
        {
            if(i == null)
            {
                k.next = j;
                break;
            }
            else if(j == null)
            {
                k.next = i;
                break;
            }
            else if(i.val < j.val)
            {
                k.next = i;
                k = k.next;
                i = i.next;
            }
            else
            {
                k.next = j;
                k = k.next;
                j = j.next;
            }
        }
        return n_head.next;
    }
}