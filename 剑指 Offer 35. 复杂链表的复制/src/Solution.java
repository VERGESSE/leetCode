import java.util.HashMap;

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

    private HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {

        if(head == null)
            return head;
        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = map.get(head.random);
        return node;
    }
}
