import java.util.ArrayList;
import java.util.List;

class Solution {
    public void reorderList(ListNode head) {

        if(head == null)
            return;

        List<ListNode> listNodeList = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null){
            listNodeList.add(tmp);
            tmp = tmp.next;
        }

        for (int i = 0; i < listNodeList.size()/2; i++){
            listNodeList.get(i).next = listNodeList.get(listNodeList.size() - i -1);
            listNodeList.get(listNodeList.size() - i - 1).next = listNodeList.get(i + 1);
        }

        if (listNodeList.size()%2 == 0){
            listNodeList.get(listNodeList.size()/2).next = null;
        }else {
            listNodeList.get(listNodeList.size()/2).next = null;
        }
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
//        ListNode listNode2 = solution.reorderList(listNode);
//        while (listNode2 != null){
//            System.out.println(listNode2.val);
//            listNode2 = listNode2.next;
    }
}

//人数最多
class Solution2 {
    public void reorderList(ListNode head) {
        if(head==null)
            return ;
        ListNode mid=middle(head);
        ListNode left=head;
        ListNode right=mid.next;
        mid.next=null;
        right=reverse(right);
        merge(left,right);


    }
    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode node){
        if(node==null || node.next==null)
            return node;
        ListNode last=reverse(node.next);
        node.next.next=node;
        node.next=null;
        return last;
    }
    public void merge(ListNode left,ListNode right){
        ListNode leftt;
        ListNode rightt;
        while(left.next!=null && right!=null){
            leftt=left.next;
            rightt=right.next;

            left.next=right;
            right.next=leftt;

            left=leftt;
            right=rightt;
        }
    }
}

//最快
class Solution3 {
    public void reorderList(ListNode head) {
        //特殊情况
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        //将链表拆为两部分
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        //将后面部分slow反转,翻转之后头节点为 prenode
        ListNode prenode=null;
        ListNode curnode=slow;
        ListNode nextnode=null;
        while(curnode!=null){
            nextnode=curnode.next;
            curnode.next=prenode;
            prenode=curnode;
            curnode=nextnode;
        }
        //合并两部门链表
        ListNode header=new ListNode(Integer.MAX_VALUE);
        ListNode node=header;
        while(head!=null && prenode!=null){

            node.next=head;
            head=head.next;
            node.next.next=prenode;
            prenode=prenode.next;
            node=node.next.next;
        }
        if(prenode!=null){
            node.next=prenode;
        }
        head=header.next;
    }
}