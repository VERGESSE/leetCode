class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null || m == n)
            return head;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        for (int i = 1; i < m; i++){
            pre = cur;
            cur = cur.next;
        }
        ListNode prepre = pre;
        for (int i = m; i < n; i++){
            cur = cur.next;
        }
        ListNode nextnext = cur.next;
        cur = pre.next;
        pre = nextnext;

        while (cur != nextnext){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (m == 1){
            return pre;
        }
        prepre.next = pre;

        return head;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode head = new ListNode(3);
//        ListNode next1 = new ListNode(5);
//        head.next = next1;
        head = solution.reverseBetween(head,1,1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //    ListNode tmp=new  ListNode(0);
        //    tmp.next=head;
        return reverseBetween(head,m,n,1);
    }

    ListNode v=null;

    public ListNode reverseBetween(ListNode head, int m, int n,int now) {
        if(now==n){
            v=head.next;
            return head;
        }
        ListNode p=reverseBetween(head.next,m,n,now+1);
        if(now>=m&&now<n){
            head.next.next=head;
            head.next=v;
            return p;
        }else if(now==m-1){
            head.next=p;
        }
        return head;
    }
}