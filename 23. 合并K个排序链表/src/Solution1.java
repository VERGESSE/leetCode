import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        //极端情况处理
        int len = 0;
        if (lists == null || (len=lists.length) == 0) return null;
        if (len == 1) return lists[0];
        //2个或以上个链表的情况
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        //按节点数值大小比较建立最小堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, (n1, n2) -> (n1.val - n2.val));
        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list);
        }
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return preHead.next;
    }
}

/*   两两合并
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
 */