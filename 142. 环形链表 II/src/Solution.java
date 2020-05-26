// Floyd 算法
/*
假设链表存在环，设head距离入环点距离为n，整个环的长度为m
一阶段:
    慢指针每次走一步，快指针走两步，当慢指针走n步走到入环点的时候快指针已经走了2n步，
    此时快指针还需走m-n步走到入环点，从现在的状态，慢指针走m-n步到达距离入环点m-n处，
    快指针对应走2(m-n)步，正好追上慢指针，此时可以判断出链表存在环，而且此时相交点处
    距离入环点距离为m-n，也就是说还需走m-(m-n)=n的距离再次到达入环点，这个很关键
二阶段:
    我们利用一阶段返回的快慢指针相交处ptr，而且经过前面的分析得知ptr还需往前走n步到
    达入环点，而且头结点距离入环点的距离也为n，所以现在让头结点和ptr不断指向他们的
    下一个节点，他们相遇的点即为入环点
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 一阶段
        // 判断是否存在环，存在环则获得快慢指针相遇的节点，否则返回空
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // 二阶段
        // 一阶段 快慢指针相遇的位置距离入环点的距离和头节点距离入环点距离相同
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    // 使用快慢指针判断是否存在环，并返回在环内快慢指针相遇的节点，如果无环返回空
    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 使用快慢指针寻找相遇节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }
}