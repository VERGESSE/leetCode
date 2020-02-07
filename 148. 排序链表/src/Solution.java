class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}

//最快
class Solution2 {
    public ListNode sortList(ListNode head) {
        // 快排
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }

        ListNode leftStart = null;
        ListNode leftEnd = null;
        ListNode rightStart = null;
        ListNode rightEnd = null;
        ListNode targetStart = head;
        ListNode targetEnd = head;

        head = head.next;
        while (head != null && head != tail) {
            if (head.val == targetStart.val) {
                targetEnd.next = head;
                targetEnd = head;
            } else if (head.val > targetStart.val) {
                if (rightStart == null) {
                    rightStart = head;
                    rightEnd = head;
                } else {
                    rightEnd.next = head;
                    rightEnd = head;
                }
            } else {
                if (leftStart == null) {
                    leftStart = head;
                    leftEnd = head;
                } else {
                    leftEnd.next = head;
                    leftEnd = head;
                }
            }

            head = head.next;
        }

        if (rightEnd != null) {
            rightEnd.next = tail;
            targetEnd.next = quickSort(rightStart, tail);
        } else {
            targetEnd.next = tail;
        }
        if (leftStart != null) {
            leftEnd.next = targetStart;
            return quickSort(leftStart, targetStart);
        } else {
            return targetStart;
        }
    }

}