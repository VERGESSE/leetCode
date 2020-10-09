import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        for(int i = 0; i < len / 2; i++){
            if (!Objects.equals(list.get(i), list.get(len - i - 1))){
                return false;
            }
        }
        return true;
    }
}

/*
class Solution {
    public boolean isPalindrome(ListNode head) {
       if (head==null){
            return true;
        }
        ListNode midNode=mid(head);
        midNode=reverse(midNode);
        ListNode mov1=head;
        ListNode mov2=midNode;
        while (mov2!=null){
            if (mov1.val!=mov2.val){
                return false;
            }
            mov1=mov1.next;
            mov2=mov2.next;
        }
        return true;
    }

    // 快指针每次走两步，慢指针每次一步
    // 在快指针到达链表尾的时候，慢指针到达链表中间
    private ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.next;
    }

    // 反转后半段链表
    private ListNode reverse(ListNode head){
        ListNode newHead=new ListNode();
        ListNode mov=head;
        ListNode temp;
        while (mov!=null){
            temp=mov.next;
            mov.next=newHead.next;
            newHead.next=mov;
            mov=temp;
        }
        return newHead.next;
    }
}
 */
