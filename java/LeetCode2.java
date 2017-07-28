/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode index = result;
        int up = 0;
        while (l1 != null || l2 != null) {
            int sum = getVal(l1) + getVal(l2) + up;
            up = sum >= 10 ? 1 : 0;
            index.val = sum % 10;
            l1 = move(l1);
            l2 = move(l2);
            if(l1 != null || l2 != null || up==1){
                index.next = new ListNode(up);
                index = index.next;                
            }
        }
        return result;
    }

    private int getVal(ListNode node) {
        return node == null ? 0 : node.val;
    }

    private ListNode move(ListNode node) {
        return node == null ? null : node.next;
    }
}
