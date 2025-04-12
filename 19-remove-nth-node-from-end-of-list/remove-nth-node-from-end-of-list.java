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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempList = head;
        int length = 0;
        while (tempList != null) {
            length++;
            tempList = tempList.next;
        }

        if (n == length) {
            return head.next;
        }

        int stepsToTake = length - n;
        tempList = head;
        for (int i = 1; i < stepsToTake; i++) {
            tempList = tempList.next;
        }

        if (tempList.next != null) {
            tempList.next = tempList.next.next;
        }

        return head;
    }
}