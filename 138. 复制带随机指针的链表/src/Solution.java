import java.util.*;
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        if (head.random != null)
            node.random = map.get(head.random);

        return node;
    }
}
