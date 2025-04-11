/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        Stack<Integer> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        ListNode newHead = new ListNode(stack.pop());
        ListNode temp = newHead;
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }

        return newHead;
    }
}