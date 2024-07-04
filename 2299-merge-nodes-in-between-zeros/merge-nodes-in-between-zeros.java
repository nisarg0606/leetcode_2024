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
    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        // create a list to store the sum of nodes between 0's
        List<Integer> sumList = new ArrayList<>();
        ListNode current = head.next;
        int sum = 0;

        while (current != null) {
            if (current.val == 0) {
                sumList.add(sum);
                sum = 0;
            } else {
                sum += current.val;
            }
            current = current.next;
        }

        // create a new list with the sum of nodes between 0's
        ListNode newHead = new ListNode(sumList.get(0));
        ListNode newCurrent = newHead;

        for (int i = 1; i < sumList.size(); i++) {
            newCurrent.next = new ListNode(sumList.get(i));
            newCurrent = newCurrent.next;
        }

        return newHead;
    }
}