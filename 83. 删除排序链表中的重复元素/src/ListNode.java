public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        while (next != null){
            stringBuilder.append(" -> ");
            stringBuilder.append(next.val);
            next = next.next;
        }
        stringBuilder.append(" -> " + "NULL");
        return stringBuilder.toString();
    }
}