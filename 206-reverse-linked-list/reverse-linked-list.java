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
        ListNode temp = head, prev = null;
        while(temp != null){
            /*
            Here we are taking prev node which is initally null as it will be the end of the list
            then we are taking front pointer which points to the head's next whole part
            now our head is pointing to the null in the first place
            now we move our prev pointer to the head and the temp pointer to the head.next part so that we can move till the end and we will do this recursively till the head becomes null
            in our case temp pointer
            */
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}