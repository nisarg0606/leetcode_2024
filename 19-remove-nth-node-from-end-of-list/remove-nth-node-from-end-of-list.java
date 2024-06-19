/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // iterate through the list to find the length
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        // if the length is 1 and n is 1, return null
        if (len == 1 && n == 1)
            return null;
        // if the length is equal to n, return the next node
        if (len == n)
            return head.next;
        // iterate through the list to find the node before the nth node from the end
        curr = head;
        for (int i = 0; i < len - n - 1; i++)
            curr = curr.next;
        // remove the nth node from the end
        curr.next = curr.next.next;
        return head;
    }
}