import java.util.HashMap;
import java.util.LinkedList;

/**
 * 自己实现双向链表，实现查找更新时O(1)复杂度的更新Node节点到链表末尾
 */
class LRUCache {

    private final HashMap<Integer, Node> map;
    private final LinkedNode linkedNode;
    private final int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.linkedNode = new LinkedNode();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        linkedNode.update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = map.get(key);
        if (node == null){
            if (size == capacity){
                Node first = linkedNode.removeFirst();
                map.remove(first.key);
                size--;
            }
            node = new Node(key, value);
            map.put(key, node);
            linkedNode.putNode(node);
            size++;
        } else {
            node.value = value;
            linkedNode.update(node);
        }
    }

    private class Node {
        int key;
        int value;
        Node next;
        Node pre;
        Node() {}
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private class LinkedNode {
        Node head;
        Node tail;

        LinkedNode(){
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void putNode(Node node){
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
        }

        void update(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            this.putNode(node);
        }

        Node removeFirst(){
            Node remove = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            return remove;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*class LRUCache {
    private int capacity;
    private HashMap<Integer,Integer> map;
    private LinkedList<Integer> list;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            list.remove((Integer)key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove((Integer)key);
            list.addLast(key);
            map.put(key,value);
            return;
        }
        if(list.size() == capacity){
            map.remove(list.removeFirst());
            map.put(key,value);
            list.addLast(key);
        }
        else{
            map.put(key,value);
            list.addLast(key);
        }
    }
}

*//**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
