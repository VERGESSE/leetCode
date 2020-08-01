import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] res = new int[n];
        for(int i = n - 1; i >= 0; i--){
            res[i] = list.get(n-i-1);
        }
        return res;
    }
}
