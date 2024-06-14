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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        int middle = (count % 2 == 0) ? (count / 2) + 1 : (count + 1) / 2;
        int i = 1;
        while (i < middle) {
            head = head.next;
            i++;
        }
        return head;
    }
}