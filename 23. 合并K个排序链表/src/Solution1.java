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