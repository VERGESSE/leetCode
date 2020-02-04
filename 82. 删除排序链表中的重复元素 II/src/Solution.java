class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummmyNode = new ListNode(0);
        dummmyNode.next = head;
        ListNode pre = dummmyNode;
        ListNode cur = dummmyNode.next;

        Integer temp = null;
        while (cur != null){

            if (temp != null && cur.val == temp){
                cur = cur.next;

                pre.next = cur;
                continue;
            }

            if (cur.next != null){
                if (cur.val == cur.next.val) {
                    temp = cur.val;
                    cur = cur.next.next;

                    pre.next = cur;
                    continue;
                }
            }
            pre = cur;
            cur = cur.next;
        }

        return dummmyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(0);
        listNode.next .next.next.next= new ListNode(0);

        Solution solution = new Solution();
        ListNode listNode1 = solution.deleteDuplicates(listNode);
        while (listNode1 != null){
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }
}

// 0ms
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {

        // 边界条件。
        if (head == null || head.next == null){
            return head;
        }

        //如果head.val和head.next.val 不相同，递归求下一个节点的delete nodes
        //并拼接 在1的后面。
        if (head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
        }else{
            //如果head.val和head.next.val相同，则找到下一个与其不相同的点，递归求解下一个点的结果。
            // 由于它本身也要被删除，所以修改head的值，而不是head。next的值。
            ListNode cur = head;

            //找到下一个不同的点。
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }

            head = deleteDuplicates(cur.next);
        }

        return head;

    }
}

// 1ms
class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode retnode = new ListNode(0);
        ListNode tempnode = retnode;
        ListNode fastnode = head;
        Integer lastnum = null;
        while(fastnode.next !=null){
            if(fastnode.val != fastnode.next.val && !Integer.valueOf(fastnode.val).equals(lastnum)){
                tempnode.next = fastnode;
                tempnode = tempnode.next;
            }
            else{
                lastnum = fastnode.val;
            }
            fastnode = fastnode.next;
        }
        tempnode.next = (Integer.valueOf(fastnode.val).equals(lastnum))?null:fastnode;
        return retnode.next;
    }
}