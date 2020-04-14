import java.util.ArrayDeque;

class Solution {

    int flow=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res1=l1,res2=l2;
        int len1=0,len2=0;
        while(l1!=null){
            len1++;
            l1=l1.next;
        }
        while(l2!=null){
            len2++;
            l2=l2.next;
        }
        ListNode res=len1>len2?add(res1,res2,len1,len2):add(res2,res1,len2,len1);
        if(flow==1) {
            res1=new ListNode(1);
            res1.next=res;
            return res1;
        }
        return res;
    }
    public ListNode add(ListNode l1, ListNode l2,int len1,int len2) {
        int temp;
        if((len1==1)&&(len2==1)){
            temp=l1.val;
            l1.val=(l1.val+l2.val)%10;
            flow=(temp+l2.val)/10;
            return l1;
        }
        if(len1>len2) {
            temp=l1.val;
            l1.next=add(l1.next, l2,len1-1,len2);
            l1.val=(temp+flow)%10;
            flow=(temp+flow)/10;
            return l1;
        }
        l1.next=add(l1.next, l2.next,len1-1,len2-1);
        temp=l1.val;
        l1.val=(temp+flow+l2.val)%10;
        flow=(temp+flow+l2.val)/10;
        return l1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(4);
//        listNode.next.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);

        Solution solution = new Solution();
        ListNode listNode2 = solution.addTwoNumbers(listNode, listNode1);
        while (listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }
}
/*    栈
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}

 */

// TODO 用的栈，结果是反的
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode retNode = new ListNode(0);
        ListNode curNode = retNode;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int sum = carry + stack1.pop() + stack2.pop();
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
        }
        while (!stack1.isEmpty()){
            int sum = carry + stack1.pop();
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
        }
        while (!stack2.isEmpty()){
            int sum = carry + stack2.pop();
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
        }
        if (carry > 0){
            curNode.next = new ListNode(carry);
        }

        return retNode.next;
    }*/

    // TODO 队列，失败，无法回溯
    /*ListNode retNode = new ListNode(0);
        ListNode curNode = retNode;
        ListNode preNode = null;
        ArrayDeque<Integer> queue1 = new ArrayDeque<>();
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();

        while (l1 != null){
            queue1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            queue2.addLast(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (queue1.size() > queue2.size()){
                curNode.next = new ListNode(queue1.pollFirst());
                preNode = curNode;
                curNode = curNode.next;
            }else if (queue1.size() < queue2.size()){
                curNode.next = new ListNode(queue2.pollFirst());
                preNode = curNode;
                curNode = curNode.next;
            }else {
                int sum = carry + queue1.pollFirst() + queue2.pollFirst();
                carry = sum / 10;
                if (carry > 0) {
                    int csum = curNode.val + carry;
                    if (csum >= 10){
                        preNode.val += csum / 10;
                    }
                    curNode.val  = csum % 10;
                    carry = 0;
                }
                curNode.next = new ListNode(sum % 10);
                preNode = curNode;
                curNode = curNode.next;
            }
            if (retNode.val != 0){
            return retNode;
        }

        return retNode.next;*/