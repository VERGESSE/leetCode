import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public Node treeToDoublyList(Node root) {

        if (root == null)
            return null;
        Node head = null, node = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            Node pop = stack.pop();
            if (head == null){
                head = pop;
                node = pop;
            } else {
                node.right = pop;
                pop.left = node;
                node = pop;
            }
            root = pop.right;
        }
        head.left = node;
        node.right = head;
        return head;
    }
}
/*
class Solution {
    public Node rear=null,head=null;
    public Node treeToDoublyList(Node root) {
        BitreeToLinklist(root);
        if(rear==null)return null;
        rear.right=head;head.left=rear;
        return head;
    }
    public void BitreeToLinklist(Node root){
        if(root==null)return ;
        BitreeToLinklist(root.left);
        if(rear==null)rear=head=root;
        else{
            rear.right=root;
            root.left=rear;
            rear=rear.right;
        }
        BitreeToLinklist(root.right);
        return ;
    }
}
 */

/* 中序遍历，后连接节点，O(n)空间
class Solution {
    public Node treeToDoublyList(Node root) {

        if (root == null)
            return null;
        if (root.left == null && root.right == null){
            root.left = root;
            root.right = root;
            return root;
        }
        List<Node> list = new ArrayList<>();
        inorderTraversal(list, root);
        Node head = list.get(0);
        for (int i = 1; i < list.size() - 1; i++){
            Node node = list.get(i);
            node.left = list.get(i-1);
            node.right = list.get(i+1);
        }
        head.right = list.get(1);
        head.left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = head;
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        return head;
    }

    private void inorderTraversal(List<Node> list, Node node){
        if (node == null)
            return;
        inorderTraversal(list, node.left);
        list.add(node);
        inorderTraversal(list, node.right);
    }
}*/
