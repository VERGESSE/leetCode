class Solution {
    public Node insert(Node head, int insertVal) {

        if (head == null){
            head = new Node();
            head.val = insertVal;
            head.next = head;
            return head;
        }

        Node newNode = new Node();
        newNode.val = insertVal;
        Node pre = head;
        Node cur = head;
        boolean flag = true;
        while (cur != head || flag){
            flag = false;
            pre = cur;
            cur = cur.next;
            if (insertVal >= pre.val){
                if (insertVal <= cur.val || pre.val > cur.val){
                    pre.next = newNode;
                    newNode.next = cur;
                    break;
                }
            } else {
                if (insertVal < cur.val && (pre.val > cur.val || pre == cur)){
                    pre.next = newNode;
                    newNode.next = cur;
                    break;
                }
            }
        }
        if (newNode.next == null){
            pre.next = newNode;
            newNode.next = cur;
        }

        return head;
    }
}

/* 宫水三叶 的题解
class Solution {
    public Node insert(Node he, int x) {
        Node t = new Node(x);
        t.next = t;
        if (he == null) return t;
        Node ans = he;
        int min = he.val, max = he.val;
        while (he.next != ans) {
            he = he.next;
            min = Math.min(min, he.val);
            max = Math.max(max, he.val);
        }
        if (min == max) {
            t.next = ans.next;
            ans.next = t;
        } else {
            while (!(he.val == max && he.next.val == min)) he = he.next;
            while (!(x <= min || x >= max) && !(he.val <= x && x <= he.next.val)) he = he.next;
            t.next = he.next;
            he.next = t;
        }
        return ans;
    }
}
 */
